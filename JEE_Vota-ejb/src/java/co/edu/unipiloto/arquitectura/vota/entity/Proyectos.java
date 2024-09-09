/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitectura.vota.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Michael
 */
@Entity
@Table(name = "PROYECTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyectos.findAll", query = "SELECT p FROM Proyectos p"),
    @NamedQuery(name = "Proyectos.findByProyectoid", query = "SELECT p FROM Proyectos p WHERE p.proyectoid = :proyectoid"),
    @NamedQuery(name = "Proyectos.findByNombreproyecto", query = "SELECT p FROM Proyectos p WHERE p.nombreproyecto = :nombreproyecto"),
    @NamedQuery(name = "Proyectos.findByDescripcion", query = "SELECT p FROM Proyectos p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Proyectos.findByLocalidad", query = "SELECT p FROM Proyectos p WHERE p.localidad = :localidad"),
    @NamedQuery(name = "Proyectos.findByPresupuesto", query = "SELECT p FROM Proyectos p WHERE p.presupuesto = :presupuesto"),
    @NamedQuery(name = "Proyectos.findByNumerohabitantes", query = "SELECT p FROM Proyectos p WHERE p.numerohabitantes = :numerohabitantes")})
public class Proyectos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROYECTOID")
    private Integer proyectoid;
    @Size(max = 50)
    @Column(name = "NOMBREPROYECTO")
    private String nombreproyecto;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 80)
    @Column(name = "LOCALIDAD")
    private String localidad;
    @Column(name = "PRESUPUESTO")
    private Integer presupuesto;
    @Column(name = "NUMEROHABITANTES")
    private Integer numerohabitantes;

    public Proyectos() {
    }

    public Proyectos(Integer proyectoid, String nombreproyecto, String descripcion, String localidad, Integer presupuesto, Integer numerohabitantes) {
        this.proyectoid = proyectoid;
        this.nombreproyecto = nombreproyecto;
        this.descripcion = descripcion;
        this.localidad = localidad;
        this.presupuesto = presupuesto;
        this.numerohabitantes = numerohabitantes;
    }

    public Proyectos(Integer proyectoid) {
        this.proyectoid = proyectoid;
    }

    public Integer getProyectoid() {
        return proyectoid;
    }

    public void setProyectoid(Integer proyectoid) {
        this.proyectoid = proyectoid;
    }

    public String getNombreproyecto() {
        return nombreproyecto;
    }

    public void setNombreproyecto(String nombreproyecto) {
        this.nombreproyecto = nombreproyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Integer getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Integer presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Integer getNumerohabitantes() {
        return numerohabitantes;
    }

    public void setNumerohabitantes(Integer numerohabitantes) {
        this.numerohabitantes = numerohabitantes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyectoid != null ? proyectoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyectos)) {
            return false;
        }
        Proyectos other = (Proyectos) object;
        if ((this.proyectoid == null && other.proyectoid != null) || (this.proyectoid != null && !this.proyectoid.equals(other.proyectoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.arquitectura.vota.entity.Proyectos[ proyectoid=" + proyectoid + " ]";
    }
    
}
