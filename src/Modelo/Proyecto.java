
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT d FROM Proyecto d")
    , @NamedQuery(name = "Proyecto.findByCodigo", query = "SELECT d FROM Proyecto d WHERE d.codigo = :codigo")
    , @NamedQuery(name = "Proyecto.findByDescripcion", query = "SELECT d FROM Proyecto d WHERE d.descripcion = :descripcion")
    , @NamedQuery(name = "Proyecto.findByLocalizacion", query = "SELECT d FROM Proyecto d WHERE d.localizacion = :localizacion")})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private int codigo;
    @Basic(optional = false)
    @Column(name = "Descripcion")
    private String descrip;
    @Column(name = "Localizacion")
    private String localizacion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "Colaborador", fetch = FetchType.LAZY)
    private List<Colaborador> colaboradorList;
    
    
    
    public Proyecto() {
    }

    public Proyecto(int codigo, String descrip) {
        this.codigo = codigo;
        this.descrip = descrip;
    }

    public Proyecto(int codigo, String descrip, String localizacion) {
        this.codigo = codigo;
        this.descrip = descrip;
        this.localizacion = localizacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    @XmlTransient
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @XmlTransient
    public List<Colaborador> getColaboradorList() {
        return this.colaboradorList;
    }

    public void setColaboradorList(List<Colaborador> colaboradorList) {
        this.colaboradorList = colaboradorList;
    }

    

    @Override
    public String toString() {
        return "modelo.Departamentos[ numdept=" + codigo + " ]";
    }
   
}