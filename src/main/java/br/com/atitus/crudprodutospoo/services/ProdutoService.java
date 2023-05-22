package br.com.atitus.crudprodutospoo.services;

import br.com.atitus.crudprodutospoo.models.ProdutoModel;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProdutoService {
    @Transactional
    ProdutoModel saveAndUpdate(ProdutoModel produtoModel) throws Exception;

    void delete(UUID id) throws Exception;

    Page<ProdutoModel> findAll(Pageable pageable);
}
