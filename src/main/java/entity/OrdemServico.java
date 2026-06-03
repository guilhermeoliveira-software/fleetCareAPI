package entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
    @Column(name = "status")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }

    public String getMecanicoResponsável() {
        return mecanicoResponsavel;
    }

    public void setMecanicoResponsavel(String mecanicoResponsavel) {
        this.mecanicoResponsavel = mecanicoResponsavel;
    }

    public double getValorOrcado() {
        return valorOrcado;
    }

    public void setValorOrcado(double valorOrcado) {
        this.valorOrcado = valorOrcado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
