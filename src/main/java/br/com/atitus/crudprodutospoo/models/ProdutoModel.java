package br.com.atitus.crudprodutospoo.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "produtos")
@Data // Objeto do lombok para não ter que escrever os Getters and Setters
public class ProdutoModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "valor_unidade", nullable = false)
    private BigDecimal valorUnidade;
}
