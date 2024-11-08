package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired private ClienteService clienteService;

    @PostMapping public Cliente salvar(@RequestBody Cliente cliente) { return clienteService.salvar(cliente); }

    @GetMapping public List<Cliente> listarTodos() { return clienteService.listarTodos(); }

    @GetMapping("/{id}") public Cliente listarPorId(@PathVariable Long id) { return clienteService.listarPorId(id); }

    @GetMapping("/nome/{nome}") public List<Cliente> listarPorNome(@PathVariable String nome) { return clienteService.listarPorNome(nome); }
}

