package com.example.demo.service;

import com.example.demo.model.Pedido;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.PedidoRepository;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PedidoService {
    @Autowired private PedidoRepository pedidoRepository;
    @Autowired private ClienteRepository clienteRepository;
    @Autowired private ProdutoRepository produtoRepository;

    public Pedido salvar(Pedido pedido) {
        if (clienteRepository.findById(pedido.getIdCliente()).isEmpty()) throw new IllegalArgumentException("Cliente inválido.");
        if (pedido.getIdsProdutos().isEmpty()) throw new IllegalArgumentException("Pedido deve conter produtos.");
        for (Long idProduto : pedido.getIdsProdutos()) {
            if (produtoRepository.findById(idProduto).isEmpty()) throw new IllegalArgumentException("Produto inválido.");
        }
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarTodos() { return pedidoRepository.findAll(); }

    public Pedido listarPorId(Long id) { return pedidoRepository.findById(id).orElse(null); }

    public List<Pedido> listarPorCliente(Long idCliente) { return pedidoRepository.findByIdCliente(idCliente); }

    public List<Pedido> listarPorProduto(Long idProduto) { return pedidoRepository.findByIdsProdutosContains(idProduto); }
}
