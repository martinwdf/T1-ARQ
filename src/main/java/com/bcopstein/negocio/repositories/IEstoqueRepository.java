package com.bcopstein.negocio.repositories;

import com.bcopstein.adaptadores.repositories.IEstoqueRepositoryJPA;
import com.bcopstein.negocio.entities.ItemEstoque;


import java.util.List;

public interface IEstoqueRepository extends IEstoqueRepositoryJPA {

    ItemEstoque findById(long id);
    Iterable<ItemEstoque> findAll();
    ItemEstoque findByCodProd(long codigo);
    ItemEstoque save(ItemEstoque item);
    boolean saveAll(List<ItemEstoque> itens);
    void delete(ItemEstoque item);
    boolean update(ItemEstoque item);
}