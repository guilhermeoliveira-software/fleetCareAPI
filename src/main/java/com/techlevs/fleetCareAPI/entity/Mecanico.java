package com.techlevs.fleetCareAPI.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Mecanico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", length = 255)
    private String nome;
    @Column(name = "idade")
    private int idade;
    @Column(name = "cpf", unique = true)
    private Integer cpf;
    @Column(name = "email", length = 255, unique = true)
    private String email;
    @Column(name = "senha", length = 255, unique = true)
    private String senha;

    @OneToMany(mappedBy = "mecanico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrdemServico> ordensDeServico;
}
