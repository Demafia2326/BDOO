/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.Colaborador;
import Modelo.Proyecto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Daniel Pérez Ramírez
 */
public class ProyectoControler {
    private static final String TABLE_NAME = "proyecto";
    private static  EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/proyecto.odb");	
    private static EntityManager em = emf.createEntityManager();
    public static List<Proyecto> getAll(){
        List<Proyecto> list = new ArrayList<Proyecto>();
       
	    
       
            Query q1 = getEm().createQuery("select * from Proyecto ", Proyecto.class);
           // d = new Departamentos();
       
        return list;
    }
    
  
    
    
    public static Proyecto get(int id){
       
        Proyecto d = null;
            		
	   
       
            Query q1 = getEm().createQuery("select * from Proyecto codigo = "+id, Proyecto.class);
            d = new Proyecto();
            d.setCodigo(id);
            
        return d;
       
    }
    
    public static void almacenarNuevo(Proyecto d) {

                
		
                Cliente e= null;
                Colaborador p=null;
		
		getEm().getTransaction().begin();
		Proyecto D = new Proyecto(d.getCodigo(), d.getDescrip(),d.getLocalizacion());
              
		D.setLocalizacion(d.getLocalizacion());
                getEm().persist(D);
		getEm().getTransaction().commit();
                getEm().close();
		
		
              

    }
    
     public static void almacenarModificado(Proyecto d){
        	Proyecto D = new Proyecto();
                D = getEm().find(Proyecto.class, d.getCodigo());
                getEm().getTransaction().begin();
                D.setDescrip(d.getDescrip());
                D.setLocalizacion(d.getLocalizacion());
                getEm().getTransaction().commit();
                getEm().close();
    }
     
     
    public static void listar(){
        
    }
     
     public static void eliminar(Proyecto d){
         Proyecto D = new Proyecto();
         D = getEm().find(Proyecto.class, d.getCodigo());
         getEm().getTransaction().begin();
         getEm().remove(D);
         getEm().getTransaction().commit();
         getEm().close();
    }

    /**
     * @return the emf
     */
    public static EntityManagerFactory getEmf() {
        return emf;
    }

    /**
     * @return the em
     */
    public static EntityManager getEm() {
        return em;
    }
    
    
    
}

