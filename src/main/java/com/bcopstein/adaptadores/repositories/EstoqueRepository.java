package com.bcopstein.adaptadores.repositories;

import com.bcopstein.negocio.entities.ItemEstoque;
import com.bcopstein.negocio.repositories.IEstoqueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EstoqueRepository implements IEstoqueRepository {

    private IEstoqueRepositoryJPA repository;

    @Autowired
    public EstoqueRepository(IEstoqueRepositoryJPA repository) {
        this.repository = repository;
    }

    @Override
    public ItemEstoque findByProduto(long codigo) {
       return repository.findByProduto(codigo);
    }   
    
    @Override
    public int findQtdProdutoByProduto(long codigo) {
       return repository.findQtdProdutoByProduto(codigo);
    }

    @Override
    public Iterable<ItemEstoque> findAll() {
        return repository.findAll();
    }

    @Override
    public ItemEstoque save(ItemEstoque item) {
        return repository.save(item);
    }

    @Override
    public boolean saveAll(List<ItemEstoque> itens) {
        return repository.saveAll(itens) != null;
    }

    @Override
    public void delete(ItemEstoque item) {
        repository.delete(item);
    }
}
