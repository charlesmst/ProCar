/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms.fluxo;

import forms.ordem.*;
import components.JTableDataBinderListener;
import components.WidgetProCar;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import javax.swing.ImageIcon;
import model.fluxo.Conta;
import model.fluxo.ContaCategoria;
import model.fluxo.Parcela;
import model.ordem.Ordem;
import services.ServiceException;
import services.fluxo.ContaService;
import services.ordem.OrdemService;
import utils.Globals;
import utils.Utils;

/**
 *
 * @author charles
 */
public class WidgetVencendo extends javax.swing.JPanel implements WidgetProCar {

    private final ContaService service;

    /**
     * Creates new form WidgetAbertas
     */
    public WidgetVencendo() {
        initComponents();
        service = new ContaService();

        table.setListener(new JTableDataBinderListener<Conta>() {

            @Override
            public Collection<Conta> lista(String busca) throws ServiceException {

                List<Conta> l = service.findContas("", true, true);
                for (int i = (l.size() - 1); i >= 0; i--) {
                    String status = service.statusParcela(l.get(i));
                    if (status.equals("EM DIA") || status.equals("FINALIZADA")) {
                        l.remove(i);
                    }
                }
                l.sort((c1, c2) -> {
                    Optional<Parcela> p = service.proximaParcela(c1);
                    Optional<Parcela> p2 = service.proximaParcela(c2);
                    //De traz pra frente
                    return p.get().getDataLancamento().compareTo(p2.get().getDataLancamento())  * -1;
                });
                return l;
            }

            @Override
            public Object[] addRow(Conta dado) {

                Object[] obj = new Object[5];
                obj[0] = dado.getId();
                obj[1] = dado.getCategoria().toString();
                obj[2] = dado.getPessoa().getNome();
                obj[3] = service.statusParcela(dado);

                obj[4] = dado.getCategoria().getTipo() == ContaCategoria.TipoCategoria.entrada ? "R" : "P";


                return obj;

            }
        });
    }

    @Override
    public void atualizar() {
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new components.JTableDataBinder();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Situação de contas para hoje");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Categoria", "Pessoa", "Situação", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMaxWidth(50);
            table.getColumnModel().getColumn(1).setMaxWidth(90);
            table.getColumnModel().getColumn(4).setMaxWidth(30);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(335, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked

        int id = table.getSelectedId();
        if (id > 0) {
            new FrmContaCadastro(id).setVisible(true);
            atualizar();
        }
    }//GEN-LAST:event_tableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private components.JTableDataBinder table;
    // End of variables declaration//GEN-END:variables

}
