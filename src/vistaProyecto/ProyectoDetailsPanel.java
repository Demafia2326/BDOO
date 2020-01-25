/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaProyecto;

import Modelo.Proyecto;

/**
 *
 * @author alfon
 */
public class ProyectoDetailsPanel extends javax.swing.JPanel {

    private Proyecto proyecto;
    private boolean edit;

    public ProyectoDetailsPanel() {
        initComponents();
    }

    public Proyecto getproyecto() {
        return proyecto;
    }

    public void setproyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public boolean isEdit() {
        return edit;
    }

    //El edit le afecta a todos los campos
    public void setEdit(boolean edit) {
        this.edit = edit;
        TextName.setEditable(edit);
        TextBudget.setEditable(edit);
    }
//Método para el botón editar    

    public void loadData() {
        if (proyecto != null) {
            TextName.setText(proyecto.getDescrip());
            TextBudget.setText(proyecto.getLocalizacion());
        } else {
            TextName.setText("");
            TextBudget.setText("");
        }
        TextName.requestFocus();
    }
    
    
//Método para el botón guardar     
    public void saveData() {
        if (proyecto == null) {
            proyecto = new Proyecto();
        }
        proyecto.setDescrip(TextName.getText());
        proyecto.setLocalizacion(TextBudget.getText());
        //proyecto.setCliente(cliente);
    }       
    
    
//Método que comprueba si los campos están vacíos     
    public boolean checkData() {
        boolean noEmpty = false;
        if (!TextBudget.getText().equals("") && !TextName.getText().equals("")) {
            noEmpty = true;
        }
        return noEmpty;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TextName = new javax.swing.JTextField();
        TextBudget = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("Descripción");

        jLabel2.setText("Localización");

        jLabel3.setText("Id del cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(21, 21, 21))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(15, 15, 15)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TextBudget)
                            .addComponent(TextName, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TextName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TextBudget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextBudget;
    private javax.swing.JTextField TextName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
