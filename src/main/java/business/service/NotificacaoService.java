package business.service;

import infra.entity.OrdemServico;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificacaoService {
    private final EmailService emailService;

    public void notificarStatus(OrdemServico ordem) {
        String emailCliente = ordem.getVeiculo().getCliente().getEmail();

        switch (ordem.getStatus()) {
            case EM_ANDAMENTO -> emailService.enviarEmailAndamento(ordem, emailCliente);
            case CONCLUIDA -> emailService.enviarEmailConcluida(ordem, emailCliente);
            case CANCELADA -> emailService.enviarEmailCancelada(ordem, emailCliente);
        }
    }
}
