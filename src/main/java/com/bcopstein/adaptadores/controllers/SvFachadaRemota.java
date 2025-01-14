package com.bcopstein.adaptadores.controllers;

import java.util.List;

import com.bcopstein.negocio.entities.ItemEstoque;
import com.bcopstein.negocio.entities.Produto;
import com.bcopstein.negocio.entities.Venda;
import com.bcopstein.negocio.services.EstoqueService;
import com.bcopstein.negocio.services.ProdutoService;
import com.bcopstein.negocio.services.VendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendas")
public class SvFachadaRemota {

  private VendaService vService;
  ProdutoService pService;
  EstoqueService sEstoque;

  @Autowired
  public SvFachadaRemota(VendaService vService, ProdutoService pService, EstoqueService sEstoque) {
    this.vService = vService;
    this.pService=pService;
    this.sEstoque=sEstoque;
  }

  @GetMapping("/produtos")
  @CrossOrigin(origins = "*")
  public List<Produto> listaProdutos() {
    return pService.findAll();
  }

  // @PostMapping("produto/cadastra")
  // @CrossOrigin(origins = "*")
  // public String novoProduto(@RequestBody final Produto[] p) {
  //   for(Produto p1 : p){
  //     if(pService.save(p1) == null) return "DEU RUIM";
  //   }
  //   return "FALA AE MLK";
  // }
  @GetMapping("/estoques")
  @CrossOrigin(origins = "*")
  public List<ItemEstoque> estoque() {
    return sEstoque.findAll();
  }
  @PostMapping("estoque/cadastra")
  @CrossOrigin(origins = "*")
  public Boolean novoItemEstoque(@RequestBody final ItemEstoque[] itens) {

    for(ItemEstoque item : itens){
    sEstoque.save(item);
    }
    return true;
  }

  // @GetMapping("/autorizacao")
  // @CrossOrigin(origins = "*")
  // public boolean podeVender(@RequestParam final Long codProd,
  //                           @RequestParam final Integer qtdade) {
  //   return service.podeVender(codProd, qtdade);
  // }

  @PostMapping("/confirmacao")
  @CrossOrigin(origins = "*")
  public boolean confirmaVenda(@RequestBody final ItemEstoque[] itens) {
    // for(ItemEstoque item : itens){
    //   sEstoque.save(item);
    // }
    vService.confirmaVenda(itens);
    return true;
  }

  @GetMapping("/historico")
  @CrossOrigin(origins = "*")
  public Iterable<Venda> vendasEfetuadas() {
    return vService.vendasEfetuadas();
  }

  // @PostMapping("/subtotal")
  // @CrossOrigin(origins = "*")
  // public Integer[] calculaSubtotal(@RequestBody final ItemEstoque[] itens) {
  //   return service.calculaSubtotal(itens);
  // }
}
