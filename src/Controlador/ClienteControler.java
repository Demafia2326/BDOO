/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Cliente;
import Modelo.Proyecto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Daniel Pérez Ramírez
 */
public class ClienteControler {
    
    private static ClienteControler instance;
    private static final String TABLE_NAME = "cliente";
    private static  EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cliente.odb");
    private static EntityManager em = emf.createEntityManager();
    
    public static ClienteControler getInstance(){
        if(instance==null){
            instance=new ClienteControler();
        }
        return instance;
    }
    
    public static List<Cliente> getAll(){
        List<Cliente> list = new ArrayList<Cliente>();
        list=em.createQuery("SELECT c FROM Cliente c",Cliente.class).getResultList();
        return list;
    }
    
    /**
     *
     * @param cliente
     */
    public static void saveCliente(Cliente cliente){
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
    }
    
    /**
     *
     * @param id
     * @return wanted
     */
    public static Cliente getClienteById(int id){
        Cliente wanted=em.find(Cliente.class,id);
        return wanted;
    }
    
    public static void delete(Cliente c){
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }
    
    /**
     *
     * @param id: La id del cliente que se desea actualizar 
     * @param cliente: Un cliente con la informacion nueva
     */
    public static void update(Cliente cliente) {
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
    }
    
    public static void addProyecto(int id, List<Proyecto> proyecto){
        Cliente cliente=getClienteById(id);
        cliente.setProyectoList(proyecto);
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
    }
    
    /**
     *
     * @param idCliente
     * @param idProyecto
     * @return find: true si ha borrado el proyecto
     */
    public static boolean removeProyecto(int idCliente, int idProyecto){
        Cliente cliente=getClienteById(idCliente);
        boolean find=false;
            Proyecto proyecto=ProyectoControler.getProyectoById(idProyecto);
            for(int i=0;i<cliente.getProyectoList().size()&&!find;i++){
                if(cliente.getProyectoList().get(i).equals(proyecto)){
                    cliente.getProyectoList().remove(i);
                    find=true;
                }
            }
        return find;
    }
}

