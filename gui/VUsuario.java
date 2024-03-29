/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.TipoUsuario;
import aplicacion.Usuario;

/**
 *
 * @author alumnogreibd
 */
public class VUsuario extends javax.swing.JDialog {

    aplicacion.FachadaAplicacion fa;
    /**
     * Creates new form VUsuariop
     */
    public VUsuario(java.awt.Frame parent, boolean modal, aplicacion.FachadaAplicacion fa) {
        super(parent, modal);
        
        this.fa = fa;
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buscaId = new javax.swing.JTextField();
        etiquetaTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        btnNuevoUsuario = new javax.swing.JButton();
        btnGardar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        buscaNombre = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        usuarioId = new javax.swing.JTextField();
        usuarioNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        usuarioClave = new javax.swing.JTextField();
        usuarioEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        usuarioDirecion = new javax.swing.JTextField();
        comboTipoUsuario = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        buscaId.setToolTipText("Titulo a buscar");

        etiquetaTitulo.setText("Id:");

        tablaUsuarios.setModel(new ModeloTablaUsuarios());
        tablaUsuarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaUsuarios.getTableHeader().setReorderingAllowed(false);
        tablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaUsuarios);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnNuevoUsuario.setText("Nuevo");
        btnNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoUsuarioActionPerformed(evt);
            }
        });

        btnGardar.setText("Gardar");
        btnGardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGardarActionPerformed(evt);
            }
        });

        jLabel4.setText("Nombre:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        jLabel5.setText("Id:");

        jLabel6.setText("Nombre:");

        usuarioNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioNombreActionPerformed(evt);
            }
        });

        jLabel7.setText("Email:");

        jLabel8.setText("Clave:");

        usuarioClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioClaveActionPerformed(evt);
            }
        });

        usuarioEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioEmailActionPerformed(evt);
            }
        });

        jLabel9.setText("Tipo:");

        jLabel10.setText("Direcion:");

        comboTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Normal" }));
        comboTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etiquetaTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscaId, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnNuevoUsuario)
                        .addGap(18, 18, 18)
                        .addComponent(btnGardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnBorrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usuarioNombre))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usuarioId, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usuarioEmail))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usuarioClave, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usuarioDirecion)
                            .addComponent(comboTipoUsuario, 0, 167, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaTitulo)
                    .addComponent(jLabel4)
                    .addComponent(buscaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(usuarioId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(usuarioClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(comboTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(usuarioNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(usuarioEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(usuarioDirecion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnNuevoUsuario)
                    .addComponent(btnGardar)
                    .addComponent(btnBorrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuariosMouseClicked
        // TODO add your handling code here:
        ModeloTablaUsuarios mu;
        mu = (ModeloTablaUsuarios) tablaUsuarios.getModel();

        Usuario usuario = null;

        if(mu.getRowCount() != 0)
        {
            usuario = mu.obtenerUsuario(tablaUsuarios.getSelectedRow());
        }

        if(usuario != null)
        {
            this.usuarioClave.setText(usuario.getClave());
            this.usuarioDirecion.setText(usuario.getDireccion());
            this.usuarioEmail.setText(usuario.getEmail());
            this.usuarioId.setText(usuario.getIdUsuario());
            this.usuarioNombre.setText(usuario.getNombre());
            this.comboTipoUsuario.setSelectedItem(usuario.getTipoUsuario().toString());
        }
    }//GEN-LAST:event_tablaUsuariosMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        //Haberia que cambiar isto
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoUsuarioActionPerformed
        // TODO add your handling code here:
        this.usuarioClave.setText("");
        this.usuarioDirecion.setText("");
        this.usuarioEmail.setText("");
        this.usuarioId.setText("");
        this.usuarioNombre.setText("");
        this.comboTipoUsuario.setSelectedItem("Normal");
    }//GEN-LAST:event_btnNuevoUsuarioActionPerformed

    private void btnGardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGardarActionPerformed
        // TODO add your handling code here:
        if(fa.gardarUsuario(usuarioId.getText(), usuarioClave.getText(), usuarioNombre.getText(), usuarioDirecion.getText(), usuarioEmail.getText(), TipoUsuario.valueOf((String)comboTipoUsuario.getSelectedItem())))
        {
            //Como poderiamos non empregar isto?
            buscarUsuarios();
        }
    }//GEN-LAST:event_btnGardarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        buscarUsuarios();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // TODO add your handling code here:
        if(fa.borrarUsuario(usuarioId.getText()))
        {
            //Teriamos que cambiar isto
            buscarUsuarios();
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void usuarioNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioNombreActionPerformed

    private void usuarioClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioClaveActionPerformed

    private void usuarioEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioEmailActionPerformed

    private void comboTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGardar;
    private javax.swing.JButton btnNuevoUsuario;
    private javax.swing.JButton btnSalir;
    private javax.swing.JTextField buscaId;
    private javax.swing.JTextField buscaNombre;
    private javax.swing.JComboBox comboTipoUsuario;
    private javax.swing.JLabel etiquetaTitulo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JTextField usuarioClave;
    private javax.swing.JTextField usuarioDirecion;
    private javax.swing.JTextField usuarioEmail;
    private javax.swing.JTextField usuarioId;
    private javax.swing.JTextField usuarioNombre;
    // End of variables declaration//GEN-END:variables
    
    public void buscarUsuarios(){
        ModeloTablaUsuarios m;

        m=(ModeloTablaUsuarios)tablaUsuarios.getModel();
        m.setFilas(fa.obtenerUsuarios(buscaId.getText(), buscaNombre.getText()));
        if (m.getRowCount() > 0) {
            tablaUsuarios.setRowSelectionInterval(0, 0);
        }
    }

}
