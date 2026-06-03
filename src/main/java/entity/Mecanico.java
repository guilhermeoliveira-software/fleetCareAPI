package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Mecanico")
public class Mecanico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", length = 255)
    private String nome;
    @Column(name = "idade", length = 5)
    private int idade;
    @Column(name = "cpf", unique = true, length = 10)
    private Integer cpf;
    @Column(name = "email", length = 255, unique = true)
    private String email;
    @Column(name = "email", length = 255, unique = true)
    private String senha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
