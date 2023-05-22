package br.com.atitus.crudprodutospoo.servicesImpl;

import br.com.atitus.crudprodutospoo.models.ProdutoModel;
import br.com.atitus.crudprodutospoo.repositories.ProdutoRepository;
import br.com.atitus.crudprodutospoo.services.ProdutoService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        super();
        this.produtoRepository = produtoRepository;
    }

    @Override
    @Transactional
    public ProdutoModel saveAndUpdate(ProdutoModel produtoModel) throws Exception {
        if (produtoModel.getNome().isBlank())
            throw new Exception("Por favor preencha o campo Nome.");

        if (produtoModel.getValorUnidade() == null)
            throw new Exception("Por favor preencha o campo Valor Unidade.");

        if (produtoModel.getValorUnidade().signum() <= 0)
            throw new Exception("Por favor preencha o campo Valor unidade com um número maior que 0.");

        return produtoRepository.save(produtoModel);
    }

    @Override
    @Transactional
    public void delete(UUID id) throws Exception {
        if (id.toString().isBlank())
            throw new Exception("Preencha o campo id.");

        produtoRepository.deleteById(id);
    }

    @Override
    public Page<ProdutoModel> findAll(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }
}
