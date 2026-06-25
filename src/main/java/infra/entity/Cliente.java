package infra.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Table(name = "Cliente")
@Getter
@Setter
public class Cliente {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "nome", length = 255, nullable = false)
        private String nome;

        @Column(name = "email", length = 255, nullable = false)
        private String email;

        @Column(name = "telefone", length = 20)
        private String telefone;

        @Column(name = "cpf", length = 14, unique = true)
        private String cpf;

        @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Veiculo> veiculos;
}

