package com.zoomtecnologia.zox.modelo.estoque;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "est_unidade")
@Data
@NamedQueries({
         @NamedQuery(name="Unidade.listarTodos",query = "select u from Unidades u"),
         @NamedQuery(name = "Unidade.buscarDescricao",query = "select u from Unidades u where u.descricao like :descricao")
 })
public class Unidades implements Serializable {

    @Id
    @Column(name = "UNCODIGO", length = 5, nullable = false)
    @Length(max = 5, message = "Código da Unidade com até {max}.")
    String codigo;

    @Column(name = "UNDESCRI", length = 20, nullable = false)
    @Length(max = 20, message = "Descrição da Unidade com até {max}.")
    String descricao;
    
    
}
