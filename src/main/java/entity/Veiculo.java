package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Veiculo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "placa", length = 255, unique = true)
    private String placa;
    @Column(name = "modelo", length = 255)
    private String modelo;
    @Column(name = "ano", length = 255)
    private Integer ano;
    @Column(name = "quilometragemAtual", length = 255)
    private Double quilometragemAtual;

    @OneToMany(mappedBy = "veiculo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrdemServico> ordensDeServico;

}