/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Daniel Pérez Ramírez
 */
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT d FROM Cliente d")
    , @NamedQuery(name = "Cliente.findByNumdept", query = "SELECT d FROM Cliente d WHERE d.numdept = :numdept")
    , @NamedQuery(name = "Cliente.findByNombre", query = "SELECT d FROM Cliente d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "Cliente.findByLocalizacion", query = "SELECT d FROM Cliente d WHERE d.localizacion = :localizacion")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private int codigo;
    @Basic(optional = false)
    @Column(name = "num_social")
    private String num_social;
    @Column(name = "telefono")
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyecto", fetch = FetchType.LAZY)
    private List<Proyecto> proyectoList;

    public Cliente() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNum_social() {
        return num_social;
    }

    public void setNum_social(String num_social) {
        this.num_social = num_social;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    

    

    

    

    @XmlTransient
    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setPresupuestoList(List<Proyecto> presupuestoList) {
        this.proyectoList = presupuestoList;
    }

    
    
    
    
/*
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }
    */

    @Override
    public String toString() {
        return "modelo.Departamentos[ numdept=" + codigo + " ]";
    }
    
}
