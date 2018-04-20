package com.zoomtecnologia.zox.modelo.cadastros;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cidade")
@Data
@NamedQueries({
    @NamedQuery(name = "Cidade.listarTodos", query = "select c from Cidade c order by c.nome")
    ,@NamedQuery(name = "Cidade.buscarDescricao", query = "select c from Cidade c where c.nome like :nome")
})
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * CODIGO CHAVE DO MUNICIPIO DE ACORDO COM O IBGE
     */
    @Id
    @Column(name = "MUCODIGO", length = 7, nullable = false)
    private Integer codigo;

    /**
     * NOME DO MUNICIPIO DE ACORDO COM O IBGE
     */
    @Column(name = "MUNOMMUN", length = 60, nullable = false, columnDefinition = "varchar(60) not null default 'EXTERIOR'")
    private String nome;

    /**
     * CODIGO DO ESTADO DE ACORDO COM O IBGE
     */
    @Column(name = "MUCODIUF", length = 2, nullable = false)
    private Integer codigoUf;

    /**
     * SIGLA DO ESTADO
     */
    @Column(name = "MUESTADO", length = 2, nullable = false, columnDefinition = "varchar(2) not null default 'EX'")
    private String uf;

    /**
     * CODIGO DO PAIS DE ACORDO COM O IBGE
     */
    @Column(name = "MUCDPAIS", length = 4, nullable = false, columnDefinition = "varchar(4) not null default 'EX'")
    private String codigoPais;

    /**
     * NOME DO PAIS
     */
    @Column(name = "MUNMPAIS", length = 50, nullable = false, columnDefinition = "varchar(50) not null default 'BRASIL'")
    private String nomePais;

    /**
     * NOME DO ESTADO
     */
    @Column(name = "MUNMESTA", length = 50)
    private String nomeEstado;

}
