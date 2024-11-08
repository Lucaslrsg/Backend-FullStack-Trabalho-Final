package com.example.demo.service;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdutoService {
    @Autowired private ProdutoRepository produtoRepository;

    public Produto salvar(Produto produto) {
        if (produto.getNome().isEmpty()) throw new IllegalArgumentException("Nome não pode ser vazio.");
        if (produto.getPreco() < 0) throw new IllegalArgumentException("Preço não pode ser negativo.");
        return produtoRepository.save(produto);
    }

    public List<Produto> listarTodos() { return produtoRepository.findAll(); }

    public Produto listarPorId(Long id) { return produtoRepository.findById(id).orElse(null); }

    public List<Produto> listarPorNome(String nome) { return produtoRepository.findByNome(nome); }
}

