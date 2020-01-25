/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaColaborador;

import Controlador.ColaboradorControler;
import Modelo.Colaborador;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ColaboradorTableModel extends AbstractTableModel {

    private ColaboradorControler colcont;
    private List<Colaborador> datos = new ArrayList<>();

    public ColaboradorTableModel (ColaboradorControler colcont) {
        this.colcont = colcont;
    }

    public void updateModel() throws Exception {
        datos = colcont.getAll();
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
                n = "DNI";
                break;
            case 2:
                n = "Nombre";
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
        Colaborador p = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                o = p.getCodigo();
                break;
            case 1:
                o = p.getNif();
                break;
            case 2:
                o = p.getNombre();
                break;
            default:
                o = "";
        }
        return o;
    }
}
