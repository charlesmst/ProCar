/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.awt.event.ActionEvent;
import components.JPanelControleButtons;
import components.JValidadorDeCampos;
import components.ValidacoesTipos;
import components.WidgetProCar;
import java.awt.Component;
import javax.swing.JOptionPane;
import utils.AlertaTipos;

/**
 *
 * @author Charles
 */
public class frmBemVindo extends JPanelControleButtons {

    JValidadorDeCampos validador = new JValidadorDeCampos();

    public frmBemVindo() {
        initComponents();
        setBtnAtualizarEnable(true);
       // validador.validarObrigatorio(jTextField1);
        //validador.validar(jTextField1, ValidacoesTipos.numero);

//        validador.validarDeBanco(jTextField1, new MarcaRepository());
    }

    private void atualizar(){
    
        for (Component component : getComponents()) {
            if(component instanceof WidgetProCar)
                ((WidgetProCar)component).atualizar();
        }
    }
    @Override
    public void OnShow() {
        atualizar();
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
        jLabel5 = new javax.swing.JLabel();
        widgetAbertas1 = new forms.ordem.WidgetAbertas();
        widgetVencendo1 = new forms.fluxo.WidgetVencendo();

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 30)); // NOI18N
        jLabel1.setText("Bem vindo ao Sistema");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/title_procar.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(widgetAbertas1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(widgetVencendo1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(widgetAbertas1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                    .addComponent(widgetVencendo1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private forms.ordem.WidgetAbertas widgetAbertas1;
    private forms.fluxo.WidgetVencendo widgetVencendo1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void btnAddActionPerformed(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnAlterarActionPerformed(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnExcluirActionPerformed(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnAtualizarActionPerformed(ActionEvent evt) {
        atualizar();
    }
}
