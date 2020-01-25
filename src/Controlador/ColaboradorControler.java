/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.ProyectoControler.getEm;
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
public class ColaboradorControler {
    
    private static ColaboradorControler instance;
    private static  EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/colaborador.odb");
    private static EntityManager em = emf.createEntityManager();
    
    public ColaboradorControler(){
        
    }
    
    public static ColaboradorControler getInstance(){
        if(instance==null){
            instance=new ColaboradorControler();
        }
        return instance;
    }
    
    public static List<Colaborador> getAll(){
        List<Colaborador> list = new ArrayList<Colaborador>();
        list=em.createQuery("SELECT c FROM Colaborador c").getResultList();
        return list;
    }
    
    /**
     *
     * @param colaborador
     */
    public static void saveColaborador(Colaborador colaborador){
        em.getTransaction().begin();
        em.persist(colaborador);
        em.getTransaction().commit();
    }
    
    /**
     *
     * @param id
     * @return wanted
     */
    public static Colaborador getColaboradorById(int id){
        Colaborador wanted=em.find(Colaborador.class,id);
        return wanted;
    }
    
    public static void delete(Colaborador c){
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }
    
    /**
     *
     * @param id: La id del colaborador que se desea actualizar 
     * @param colaborador: Un colaborador con la informacion nueva
     */
    public static void update(Colaborador colaborador) {
        em.getTransaction().begin();
        em.persist(colaborador);
        em.getTransaction().commit();
    }
    
    public static void addProyecto(int id, List<Proyecto> proyecto){
        Colaborador colaborador=getColaboradorById(id);
        colaborador.setProyectoList(proyecto);
        em.getTransaction().begin();
        em.persist(colaborador);
        em.getTransaction().commit();
    }
    
    /**
     *
     * @param idColaborador
     * @param idProyecto
     * @return find: true si ha borrado el proyecto
     */
    public static boolean removeProyecto(int idColaborador, int idProyecto){
        Colaborador colaborador=getColaboradorById(idColaborador);
        boolean find=false;
        /*
            Proyecto proyecto=ProyectoControler.getInstance().getProyectoById();
            for(int i=0;i<colaborador.getProyectoList().size()&&!find;i++){
                if(colaborador.getProyectoList().get(i).equals(proyecto)){
                    colaborador.getProyectoList().remove(i);
                    find=true;
                }
            }
        */
        return find;
    }
}
