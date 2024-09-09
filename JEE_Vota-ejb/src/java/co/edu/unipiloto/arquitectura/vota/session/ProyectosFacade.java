/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitectura.vota.session;

import co.edu.unipiloto.arquitectura.vota.entity.Proyectos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Michael
 */
@Stateless
public class ProyectosFacade extends AbstractFacade<Proyectos> implements ProyectosFacadeLocal {

    @PersistenceContext(unitName = "Vota-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectosFacade() {
        super(Proyectos.class);
    }
    
}
