package business.service;

import business.enums.StatusOrdem;
import business.exception.BusinessRuleException;
import business.exception.ResourceNotFoundException;
import infra.dto.VeiculoRequestDTO;
import infra.entity.Mecanico;
import infra.entity.OrdemServico;
import infra.entity.Veiculo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import infra.repository.MecanicoRepository;
import infra.repository.OrdemServicoRepository;
import infra.repository.VeiculoRepository;

@Service
@RequiredArgsConstructor
public class OrdemServicoService {

    private final OrdemServicoRepository ordemServicoRepository;
    private final MecanicoRepository mecanicoRepository;
    private final VeiculoRepository veiculoRepository;


    @Transactional
    public Veiculo cadastrarVeiculo(VeiculoRequestDTO dto) {
        if (veiculoRepository.existsByPlaca(dto.placa())) {
            throw new RuntimeException("Já existe um veículo cadastrado com a placa " + dto.placa());
        }

        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca(dto.placa().toUpperCase());
        veiculo.setModelo(dto.modelo());
        veiculo.setAno(dto.ano());
        veiculo.setQuilometragemAtual(dto.quilometragemAtual());

        return veiculoRepository.save(veiculo);
    }

    @Transactional
    public OrdemServico atualizarStatus(Long id, StatusOrdem novoStatus, Long idMecanico) {
        OrdemServico ordem = ordemServicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ordem de Serviço não encontrada com o ID: " + id));


        validarTransicaoStatus(ordem.getStatus(), novoStatus);

        if (StatusOrdem.EM_ANDAMENTO.equals(novoStatus)) {
            vincularMecanicoSeNecessario(ordem, idMecanico);
        }

        ordem.setStatus(novoStatus);

        OrdemServico ordemAtualizada = ordemServicoRepository.save(ordem);

        return ordemAtualizada;
    }

    private void validarTransicaoStatus(StatusOrdem statusAtual, StatusOrdem novoStatus) {
        if (StatusOrdem.CONCLUIDA.equals(statusAtual) || StatusOrdem.CANCELADA.equals(statusAtual)) {
            throw new BusinessRuleException("Não é permitido alterar o status de uma ordem de serviço já finalizada como " + statusAtual);
        }
    }

    private void vincularMecanicoSeNecessario(OrdemServico ordem, Long idMecanico) {
        if (ordem.getMecanico() == null && idMecanico == null) {
            throw new BusinessRuleException("Uma ordem de serviço só pode entrar em andamento se houver um mecânico atribuído.");
        }

        if (idMecanico != null) {
            Mecanico mecanico = mecanicoRepository.findById(idMecanico)
                    .orElseThrow(() -> new ResourceNotFoundException("Mecânico não encontrado com o ID: " + idMecanico));
            ordem.setMecanico(mecanico);
        }
    }
}

