package com.zoomtecnologia.zox.filtros;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Administrador
 */
@Getter @Setter
public abstract class FiltroGeneric implements Serializable {
    private static final long serialVersionUID = 1L;
    private int primeiroRegistro;
    private int quantidadeRegistros;
    private String propriedadeOrdenacao;
    private boolean ascendente;
}
