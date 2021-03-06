package com.zoomtecnologia.zox.filtros;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author eudes
 */
@Getter
@Setter
public abstract class Filtro implements Serializable {

    private static final long serialVersionUID = 1L;
    private int primeiroRegistro;
    private int quantidadeRegistros;
    private String propriedadeOrdenacao;
    private boolean ascendente;
    private String pesquisa;
    private boolean isFiltrar;
}
