/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VPrincipal.java
 *
 * Created on 27-ene-2011, 10:31:24
 */

package gui;

import aplicacion.Categoria;
import aplicacion.TipoUsuario;
import aplicacion.Usuario;


/**
 *
 * @author basesdatos
 */
public class VCategoria extends javax.swing.JFrame {
  
    aplicacion.FachadaAplicacion fa;
    java.util.List<String> nomesCategorias;
    
    /** Creates new form VPrincipal */
    public VCategoria(aplicacion.FachadaAplicacion fa, java.util.List<String> nomesCategorias) {
        this.fa=fa;
        this.nomesCategorias = nomesCategorias;
        
        initComponents();
        
        ModeloListaStrings modeloListaCategorias = (ModeloListaStrings) this.listaCategorias.getModel();
        modeloListaCategorias.setElementos(nomesCategorias);
        if(modeloListaCategorias.getSize() > 0)
        {
            this.listaCategorias.setSelectedIndex(0);
            this.btnBorrar.setEnabled(true);
        }
        else
        {
            this.btnBorrar.setEnabled(false);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        etiquetaTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nombreCategoria = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnEngadir = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaCategorias = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        descripcionCategoria = new javax.swing.JTextPane();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Xestión de Categorías");
        setName("vPrincipal"); // NOI18N
        setResizable(false);

        etiquetaTitulo.setText("Categorías");

        jLabel1.setText("Nombre:");

        nombreCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreCategoriaActionPerformed(evt);
            }
        });

        jLabel2.setText("Descripción");

        btnEngadir.setText("Engadir");
        btnEngadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEngadirActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        listaCategorias.setModel(new ModeloListaStrings());
        listaCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaCategoriasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaCategorias);

        jScrollPane2.setViewportView(descripcionCategoria);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetaTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEngadir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBorrar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(34, 34, 34)
                                .addComponent(nombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiquetaTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEngadir)
                            .addComponent(btnBorrar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                        .addComponent(btnSalir))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Biblioteca Informática");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreCategoriaActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // TODO add your handling code here:
        ModeloListaStrings ml;
        ml = (ModeloListaStrings) listaCategorias.getModel();
        
        /*
        String nomeCategoria = null;
        
        Categoria categoria = null;
        
        
        if(ml.getSize() != 0)
        {
            nomeCategoria = ml.getElementAt(listaCategorias.getSelectedIndex());
        }
        
        if(nomeCategoria != null)
        {
            if(fa.borrarCategoria(nomeCategoria))
            {
                this.actualizarCategorias();
            }
        }
        */
        
        String nomeCategoria = ml.getElementAt(listaCategorias.getSelectedIndex());
        
        if(fa.borrarCategoria(nomeCategoria))
        {
            this.actualizarCategorias();
            
            ModeloListaStrings modeloListaCategorias = (ModeloListaStrings) this.listaCategorias.getModel();

            if(modeloListaCategorias.getSize() > 0)
            {
                this.listaCategorias.setSelectedIndex(0);
                this.btnBorrar.setEnabled(true);
            }
            else
            {
                this.btnBorrar.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void listaCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaCategoriasMouseClicked
        // TODO add your handling code here:
        ModeloListaStrings ml;
        ml = (ModeloListaStrings) listaCategorias.getModel();
        
        /*
        String nomeCategoria = null;
        
        Categoria categoria = null;
        
        if(ml.getSize() != 0)
        {
            nomeCategoria = ml.getElementAt(listaCategorias.getSelectedIndex());
        }
        
        if(nomeCategoria != null)
        {
            categoria = fa.obterCategoria(nomeCategoria);
            
            if(categoria != null)
            {
                this.descripcionCategoria.setText(categoria.getDescripcion());
            }
        }
        */
        
        String nomeCategoria = ml.getElementAt(listaCategorias.getSelectedIndex());
        Categoria categoria = fa.obterCategoria(nomeCategoria);
        
        if(categoria != null)
        {
            this.descripcionCategoria.setText(categoria.getDescripcion());
        }
    }//GEN-LAST:event_listaCategoriasMouseClicked

    private void btnEngadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEngadirActionPerformed
        // TODO add your handling code here:
        if(fa.gardarCategoria(nombreCategoria.getText(), descripcionCategoria.getText()))
        {
            this.actualizarCategorias();
        }
    }//GEN-LAST:event_btnEngadirActionPerformed

    private void actualizarCategorias()
    {
        this.nomesCategorias = this.fa.actualizarCategorias();
        
        ModeloListaStrings modeloListaCategorias = (ModeloListaStrings) this.listaCategorias.getModel();
        modeloListaCategorias.setElementos(nomesCategorias);
    }
    /**
    * @param args the command line arguments
    */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnEngadir;
    private javax.swing.JButton btnSalir;
    private javax.swing.JTextPane descripcionCategoria;
    private javax.swing.JLabel etiquetaTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listaCategorias;
    private javax.swing.JTextField nombreCategoria;
    // End of variables declaration//GEN-END:variables

}
