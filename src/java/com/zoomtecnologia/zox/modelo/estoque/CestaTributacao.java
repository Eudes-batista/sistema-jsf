/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "cesta_tributacao")
@Data
@NamedQueries({
    @NamedQuery(name = "CestaTributacao.listarTodos", query = "select u from CestaTributacao u"),
    @NamedQuery(name = "CestaTributacao.buscarDescricao", query = "select u from CestaTributacao u where u.descricao like :descricao")
})
public class CestaTributacao implements Serializable  {
    
  /**
     * CÓDIGO DA CESTA DE TRIBUTACAO
     */
    @Id
    @Column(name = "CTCODIGO", length = 04, nullable = false)
    @Length(max = 04, message = "Código da Cesta de Tributação com até {max}.")
    String codigo;
    
  /**
     * DESCRIÇÃO DA CESTA DE TRIBUTAÇÃO
     */
    @Column(name = "CTCODIGO", length = 50, nullable = false)
    @Length(max = 50, message = "Descrição da Cesta de Tributação com até {max}.")
    String descricao;
    
}
