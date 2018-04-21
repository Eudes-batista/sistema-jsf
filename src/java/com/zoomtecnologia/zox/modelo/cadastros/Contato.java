package com.zoomtecnologia.zox.modelo.cadastros;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "contado")
@Data
public class Contato implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CPCODIGO",length = 11,nullable = false)      
    Integer codigo;
    
    @ManyToOne
    @JoinColumn(name = "CPCODPES",referencedColumnName = "CUDOCIDE",nullable = false)    
    @ForeignKey(name = "contadoFKpessoa")        
    Pessoa pessoa;
    
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Campo nome da cidade não pode ser nulo")          
    TipoContato tipoContato;
    
    @Length(max = 30,message = "campo nome só pode ter apenas {max} caracteres")
    @Column(length = 30,name = "CPDESCRI")        
    String descricao;
}
