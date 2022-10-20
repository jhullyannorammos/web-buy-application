package br.com.application.dao;

import br.com.application.modelo.Produto;
import java.io.Serializable;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class ProdutoDAO<T> extends DAOGenerico<Produto> implements Serializable {

    public ProdutoDAO() {
        super();
        classePersistente = Produto.class;
        ordem = "nome";
    }
}
