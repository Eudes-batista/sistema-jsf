package com.zoomtecnologia.zox.modelo.cadastros;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "endereco")
@Getter @Setter
@NamedQueries({
    @NamedQuery(name = "Endereco.listarTodos", query = "select e from Endereco e order by e.logradouro")
    ,@NamedQuery(name = "Endereco.buscarPorEndereco", query = "select e from Endereco e where e.logradouro like :logradouro order by e.logradouro")
})
public class Endereco implements Serializable {

    /**
     * CODIGO DO ENDERECO
     */
    @EmbeddedId
    private EnderecoPK enderecoPk;
    
    /**
     * DESCRICAO DO ENDERECO
     */
    @Column(name = "logradouro", length = 50, nullable = false)
    private String logradouro;
    /**
     * BAIRRO
     */
    @Column(name = "bairro", length = 50, nullable = false)
    private String bairro;
    /**
     * COMPLEMENTO
     */
    @Column(name = "complemento", length = 60, nullable = true)
    private String complento;
}
