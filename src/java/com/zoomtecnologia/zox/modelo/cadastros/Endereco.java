package com.zoomtecnologia.zox.modelo.cadastros;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "endereco")
@Data
@NamedQueries({
    @NamedQuery(name = "Endereco.listarTodos", query = "select e from Endereco e order by e.logradouro")
    ,@NamedQuery(name = "Endereco.buscarPorEndereco", query = "select e from Endereco e where e.logradouro like :logradouro order by e.logradouro")
})
public class Endereco implements Serializable {

    @EmbeddedId
    EnderecoPK enderecoPk;
    @Column(name = "ENENDERO", length = 50, nullable = false)
    String logradouro;
    @Column(name = "ENBAIRRO", length = 50, nullable = false)
    String bairro;
}
