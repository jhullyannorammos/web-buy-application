package br.com.application.dao;

import br.com.application.modelo.Estado;
import br.com.application.modelo.TipoEndereco;
import java.io.Serializable;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class TipoEnderecoDAO<T> extends DAOGenerico<TipoEndereco> implements Serializable {

    public TipoEnderecoDAO() {
        super();
        classePersistente = TipoEndereco.class;
        ordem = "descricao";
    }
}
