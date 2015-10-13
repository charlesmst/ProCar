/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import components.JCampoBusca;
import java.awt.event.ActionEvent;
import components.JPanelControleButtons;

import components.JTableDataBinder;
import components.JTableDataBinderListener;
import java.util.ArrayList;
import java.util.Collection;
import model.Usuario;
import services.UsuarioService;
import utils.AlertaTipos;

/**
 *
 * @author Charles
 */
public class frmUsuarios extends JPanelControleButtons {

    private final UsuarioService service;
    JTableDataBinder table;

    public frmUsuarios() {
        initComponents();
        setBtnAddEnable(true);

        service = new UsuarioService();

        new JCampoBusca(txtBuscar, () -> table.atualizar());

        ((JTableDataBinder) jtbDados).setListener(new JTableDataBinderListener<Usuario>() {

            @Override
            public Collection<Usuario> lista(String busca) {
                try {
                    return service.findByMultipleColumns(busca, "id_pessoa", "usuario");
                } catch (Exception e) {
                    utils.Forms.mensagem(e.getMessage(), AlertaTipos.erro);
                }
                return new ArrayList<Usuario>();
            }

            @Override
            public Object[] addRow(Usuario dado) {
                return new Object[]{dado.getId_pessoa(), dado.getUsuario(), dado.getUsuario(), dado.isAtivo() ? "S" : "N"};

            }
        });

        table = ((JTableDataBinder) jtbDados);

        table.setBusca(txtBuscar);
        table.atualizar();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtbDados = new JTableDataBinder();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();

        jtbDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{
                {null,null,null,null},
                {null,null,null,null},{null,null,null,null},{null,null,null,null}

            }
            ,
            new String [] {
                "ID", "Nome", "Usuário", "Ativo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class

                , java.lang.String.class

                , java.lang.String.class

                , java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtbDados);

        jLabel2.setText("Buscar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbDados;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    @Override
    public void btnAddActionPerformed(ActionEvent evt) {
//        model.createNew();

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
