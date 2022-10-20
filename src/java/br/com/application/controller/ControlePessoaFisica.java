
package br.com.application.controller;

import br.com.application.dao.CidadeDAO;
import br.com.application.dao.PessoaFisicaDAO;
import br.com.application.dao.PaisDAO;
import br.com.application.dao.ProdutoDAO;
import br.com.application.dao.TipoEnderecoDAO;
import br.com.application.modelo.Cidade;
import br.com.application.modelo.Endereco;
import br.com.application.modelo.PessoaFisica;
import br.com.application.modelo.Pais;
import br.com.application.modelo.Produto;
import br.com.application.modelo.TipoEndereco;
import br.com.application.util.Util;
import br.com.application.util.UtilRelatorios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
@ManagedBean(name = "controlePessoaFisica")
@ViewScoped
public class ControlePessoaFisica implements Serializable {
    
    private PessoaFisicaDAO<PessoaFisica> dao;
    private PessoaFisica pessoaFisica;
    private CidadeDAO<Cidade> daoCidade;
    private TipoEnderecoDAO<TipoEndereco> daoTipoEndereco;
    private Endereco endereco;
    private Boolean novoEndereco;
    private ProdutoDAO<Produto> daoProduto;
    private Produto produto;
    
    public ControlePessoaFisica(){
        dao = new PessoaFisicaDAO<>();
        daoCidade = new CidadeDAO<>();
        daoTipoEndereco = new TipoEnderecoDAO<>();       
        daoProduto = new ProdutoDAO<>();
    }
    
    
    public void imprimeProdutos(){
        HashMap parametros = new HashMap();
        UtilRelatorios.imprimeRelatorio("relatorioProdutos", parametros, daoProduto.getListaTodos());
    }
    
    public void imprimePessoa(Integer id){
        pessoaFisica = dao.localizar(id);
        List<PessoaFisica> lista = new ArrayList<>();
        lista.add(pessoaFisica);
        HashMap parametros = new HashMap();
        UtilRelatorios.imprimeRelatorio("relatorioPessoaFisica", parametros, lista);
    }    
       
    public void adicionarDesejo(){
        if (produto != null){
            if (!pessoaFisica.getVendas().contains(produto)){
                //pessoaFisica.getVendas().add(produto);
                Util.mensagemInformacao("Desejo adicionado com sucesso!");
            } else {
                Util.mensagemErro("Este desejo já existe na sua lista!");
            }
        }
    }
    
    public void removerDesejo(int index){
        //produto = pessoaFisica.getVendas(). //.get(index);
        pessoaFisica.getVendas().remove(produto);
        Util.mensagemInformacao("Desejo removido com sucesso!");
    }
    
    public String listar(){
        return "/privado/pessoafisica/listar?faces-redirect=true";
    }
    
    public void novoEndereco(){
        endereco = new Endereco();
        novoEndereco = true;
    }
    
    public void alterarEndereco(int index){
        endereco = pessoaFisica.getEnderecos().get(index);
        novoEndereco = false;
    }
    
    public void salvarEndereco(){
        if (novoEndereco){
            pessoaFisica.adicionarEndereco(endereco);
        }
        Util.mensagemInformacao("Endereço persistido com sucesso!");
    }
    
    public void removerEndereco(int index){
        pessoaFisica.removerEndereco(index);
        Util.mensagemInformacao("Endereço removido com sucesso!");
    }
    
    public void novo(){
        pessoaFisica = new PessoaFisica();        
    }
    
    public void salvar(){
        /*
        boolean persistiu = false;
        if (pessoaFisica.getId() == null){
            persistiu = dao.persist(pessoaFisica);
        } else {
            persistiu = dao.merge(pessoaFisica);
        }
        if (persistiu){
            Util.mensagemInformacao(dao.getMensagem());            
        } else {
            Util.mensagemErro(dao.getMensagem());            
        }*/
    }
    
    public void editar(Integer id){
        pessoaFisica = dao.localizar(id);        
    }
    
    public void remover(Integer id){
        pessoaFisica = dao.localizar(id);
        if (dao.remove(pessoaFisica)){
            Util.mensagemInformacao(dao.getMensagem());
        } else {
            Util.mensagemErro(dao.getMensagem());
        }
    }
    
    public PessoaFisicaDAO getDao() {
        return dao;
    }

    public void setDao(PessoaFisicaDAO dao) {
        this.dao = dao;
    }

    public PessoaFisica getObjeto() {
        return pessoaFisica;
    }

    public void setObjeto(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }    

    public CidadeDAO<Cidade> getDaoCidade() {
        return daoCidade;
    }

    public void setDaoCidade(CidadeDAO<Cidade> daoCidade) {
        this.daoCidade = daoCidade;
    }

    public TipoEnderecoDAO<TipoEndereco> getDaoTipoEndereco() {
        return daoTipoEndereco;
    }

    public void setDaoTipoEndereco(TipoEnderecoDAO<TipoEndereco> daoTipoEndereco) {
        this.daoTipoEndereco = daoTipoEndereco;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Boolean getNovoEndereco() {
        return novoEndereco;
    }

    public void setNovoEndereco(Boolean novoEndereco) {
        this.novoEndereco = novoEndereco;
    }

    public ProdutoDAO<Produto> getDaoProduto() {
        return daoProduto;
    }

    public void setDaoProduto(ProdutoDAO<Produto> daoProduto) {
        this.daoProduto = daoProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }


}
