package br.com.atitus.crudprodutospoo.repositories;

import br.com.atitus.crudprodutospoo.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, UUID> {
}
