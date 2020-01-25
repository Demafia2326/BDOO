/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaCliente;

import Controlador.ClienteControler;
import Modelo.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ClienteTableModel extends AbstractTableModel {

    private ClienteControler clicont;
    private List<Cliente> datos = new ArrayList<>();

    public ClienteTableModel (ClienteControler clicont) {
        this.clicont = clicont;
    }

    public void updateModel() throws Exception {
        datos = clicont.getAll();
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
                n = "Telefono";
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
        Cliente p = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                o = p.getCodigo();
                break;
            case 1:
                o = p.getNum_social();
                break;
            case 2:
                o = p.getTelefono();
                break;
            default:
                o = "";
        }
        return o;
    }
}
