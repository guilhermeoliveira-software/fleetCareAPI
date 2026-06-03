package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "OrdemServico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrdemServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricaoProblema", length = 1000)
    private String descricaoProblema;
    @Column(name = "valorOrcado")
    private double valorOrcado;
    @Column(name = "mecanicoResponsavel", length = 255)
    private String mecanicoResponsavel;

    @ManyToOne
    @JoinColumn(name = "mecanico_id", nullable = false)
    private Mecanico mecanico;

    @ManyToOne
    @JoinColumn(name = "veiculo_id", nullable = false)
    private Veiculo veiculo;

    @Column(name = "status")
    private String status;


}
