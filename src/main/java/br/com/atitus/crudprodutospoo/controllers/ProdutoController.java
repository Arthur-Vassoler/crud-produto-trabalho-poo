package br.com.atitus.crudprodutospoo.controllers;

import br.com.atitus.crudprodutospoo.models.ProdutoModel;
import br.com.atitus.crudprodutospoo.services.ProdutoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/produto")
public class ProdutoController {
    final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        super();
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProdutoModel produtoModel) {
        try {
            return new ResponseEntity<>(produtoService.saveAndUpdate(produtoModel),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao criar um produto! \n\nErro: " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") UUID id) {
        try {
            produtoService.delete(id);

            return new ResponseEntity<>("Sucesso ao deletar o Produto: \n"+ id,
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao criar um produto! \n\nErro: " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ProdutoModel produtoModel) {
        if (produtoModel.getId().toString().isBlank())
            return new ResponseEntity<>("Insira o id do Produto.", HttpStatus.BAD_REQUEST);

        try {
            return new ResponseEntity<>(produtoService.saveAndUpdate(produtoModel),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao alterar um produto! \n\nErro: " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<Page<ProdutoModel>> findAll(Pageable pageable) {
        Page<ProdutoModel> produtoModels = produtoService.findAll(pageable);

        return new ResponseEntity<>(produtoModels, HttpStatus.OK);
    }
}
