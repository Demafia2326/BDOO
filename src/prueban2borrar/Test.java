/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueban2borrar;


import Vista.View;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Daniel Pérez Ramírez
 */
public class Test {
    
    public static View vista ;

    public static void main(String[] args) {
        vista= new View();
        vista.setVisible(true);
    }
        /*
        public static void menuVista() throws InputMismatchException{
            System.out.println("Conexion satisfactoria");
            
            

                Scanner scan = new Scanner(System.in);
                int opcion = 0;

                do {
                    System.out.println("1.- Opciones de Proyecto");
                    System.out.println("2.- Opciones de Cliente");
                    System.out.println("3.- Opciones de Colaborador");
                    System.out.println("0.- Salir");
                    opcion=scan.nextInt();

                    switch(opcion){
                        case 1:
                            menuProyecto();
                            break;
                        case 2:
                            menuCliente();
                            break;
                        case 3:
                            //menuColaborador();
                            break;
                        
                    }               

                } while (opcion > 0 && opcion < 3);
            
            
            //}
    }
    */
        
}