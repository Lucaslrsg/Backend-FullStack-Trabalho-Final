package com.example.demo.controller;

import com.example.demo.model.Produto;
import com.example.demo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired private ProdutoService produtoService;

    @PostMapping public Produto salvar(@RequestBody Produto produto) { return produtoService.salvar(produto); }

    @GetMapping public List<Produto> listarTodos() { return produtoService.listarTodos(); }

    @GetMapping("/{id}") public Produto listarPorId(@PathVariable Long id) { return produtoService.listarPorId(id); }

    @GetMapping("/nome/{nome}") public List<Produto> listarPorNome(@PathVariable String nome) { return produtoService.listarPorNome(nome); }
}
