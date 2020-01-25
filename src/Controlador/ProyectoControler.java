/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.Colaborador;
import Modelo.Proyecto;
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
    
    private static ProyectoControler instance;
    private static final String TABLE_NAME = "proyecto";
    private static  EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/proyecto.odb");
    private static EntityManager em = emf.createEntityManager();
    
    public ProyectoControler(){
        
    }
    
    public static ProyectoControler getInstance(){
        if(instance==null){
            instance=new ProyectoControler();
        }
        return instance;
    }
    
    public static List<Proyecto> getAll(){
        List<Proyecto> list = new ArrayList<Proyecto>();
        list=em.createQuery("SELECT c FROM Proyecto c",Proyecto.class).getResultList();
        return list;
    }
    
    /**
     *
     * @param proyecto
     */
    public static void saveProyecto(Proyecto proyecto){
        em.getTransaction().begin();
        em.persist(proyecto);
        em.getTransaction().commit();
    }
    
    /**
     *
     * @param id
     * @return wanted
     */
    public static Proyecto getProyectoById(int id){
        Proyecto wanted=em.find(Proyecto.class,id);
        return wanted;
    }
    
    public static void delete(Proyecto c){
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }
    
    /**
     *
     * @param id: La id del proyecto que se desea actualizar 
     * @param proyecto: Un proyecto con la informacion nueva
     */
    public static void update(Proyecto proyecto) {
        em.getTransaction().begin();
        em.persist(proyecto);
        em.getTransaction().commit();
    }
    
    public static void addColaborador(int id, List<Colaborador> colaborador){
        Proyecto proyecto=getProyectoById(id);
        proyecto.setColaboradorList(colaborador);
        em.getTransaction().begin();
        em.persist(proyecto);
        em.getTransaction().commit();
    }
    
    /**
     *
     * @param idProyecto
     * @param idProyecto
     * @return find: true si ha borrado el proyecto
     */
    public static boolean removeProyecto(int idProyecto, int idColaborador){
        Proyecto proyecto=getProyectoById(idProyecto);
        boolean find=false;
        
            Colaborador colaborador=ColaboradorControler.getInstance().getColaboradorById(idColaborador);
            for(int i=0;i<proyecto.getColaboradorList().size()&&!find;i++){
                if(proyecto.getColaboradorList().get(i).equals(proyecto)){
                    proyecto.getColaboradorList().remove(i);
                    find=true;
                }
            }
        
        return find;
    }
}