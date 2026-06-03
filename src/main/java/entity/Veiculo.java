package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Veiculo")
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

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public Integer getAno() { return ano; }
    public void setAno(Integer ano) { this.ano = ano; }

    public Double getQuilometragemAtual() {
        return quilometragemAtual;
    }

    public void setQuilometragemAtual(Double quilometragemAtual) {
        this.quilometragemAtual = quilometragemAtual;
    }
}