/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaProyecto;

import Controlador.ProyectoControler;
import Modelo.Proyecto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProyectoTableModel extends AbstractTableModel {

    private ProyectoControler proycont;
    private List<Proyecto> datos = new ArrayList<>();

    public ProyectoTableModel (ProyectoControler proycont) {
        this.proycont = proycont;
    }

    public void updateModel() throws Exception {
        datos = proycont.getAll();
    }

    //Titulo de las columnas 
    @Override
    public String getColumnName(int column) {
        String n = "";
        switch (column) {
            case 0:
                n = "ID";
                break;
            case 1:
                n = "Descripcion";
                break;
            case 2:
                n = "Localizacion";
                break;
            default:
                n = "[no]";
        }
        return n;
    }

    //El numero de registros es el numero de filas    
            
    @Override
    public int getRowCount() {
        return datos.size();
    }       

    //El numero de columnas lo metemos a fuego     
    
    @Override     
    public int getColumnCount() {         
        return 3;     
    } 
    //El valor de cada casilla     
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object o = null;
        Proyecto p = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                o = p.getCodigo();
                break;
            case 1:
                o = p.getDescrip();
                break;
            case 2:
                o = p.getLocalizacion();
                break;
            default:
                o = "";
        }
        return o;
    }
}
