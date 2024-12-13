package com.example.demo.controller;

import com.example.demo.model.Pedido;
import com.example.demo.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired private PedidoService pedidoService;

    @PostMapping public Pedido salvar(@RequestBody Pedido pedido) { return pedidoService.salvar(pedido); }

    @GetMapping public List<Pedido> listarTodos() { return pedidoService.listarTodos(); }

    @GetMapping("/{id}") public Pedido listarPorId(@PathVariable Long id) { return pedidoService.listarPorId(id); }

    @GetMapping("/cliente/{idCliente}") public List<Pedido> listarPorCliente(@PathVariable Long idCliente) { return pedidoService.listarPorCliente(idCliente); }

    @GetMapping("/produto/{idProduto}") public List<Pedido> listarPorProduto(@PathVariable Long idProduto) { return pedidoService.listarPorProduto(idProduto); }
}
