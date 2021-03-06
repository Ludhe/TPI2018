package sv.edu.uesocc.tpi135_2018.mantenimiento.ui;

import java.awt.Color;
import java.io.IOException;
import java.net.URI;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import sv.edu.uesocc.tpi135_2018.mantenimiento.fileprocessormaven.ProcesadorArchivo;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;
import sv.edu.uesocc.tpi135_2018.mantenimiento.fileprocessormaven.crearJSON;
import sv.edu.uesocc.tpi135_2018.mantenimiento.restutils.EnvioRest;

public class PantallaInicial extends javax.swing.JFrame {

    ProcesadorArchivo procesadorArchivo;

    DefaultListModel<String> modeloListaIzquierda;
//   private JTable jTable1;
    DefaultTableModel modelo;

    public PantallaInicial() {
        initComponents();
        toggleActivation(false);
        procesadorArchivo = new ProcesadorArchivo();
        modeloListaIzquierda = new DefaultListModel<>();
        listaIzquierda.setModel(modeloListaIzquierda);
        modelo = (DefaultTableModel) jTable2.getModel();
        jTable2.setModel(modelo);
//        jTable2.sizeColumnsToFit(0);
        btnAceptar.setEnabled(false);
        setLocationRelativeTo(null);

    }

    private void toggleActivation(boolean a) {
        jTable2.setEnabled(a);
        listaIzquierda.setEnabled(a);
        btnAgregar.setEnabled(a);
        btnAgregarTodos.setEnabled(a);
        btnQuitar.setEnabled(a);
        btnQuitarTodos.setEnabled(a);

    }

    private void toggleButton() {
        if (jTable2.getRowCount() > 0) {
            btnAceptar.setEnabled(true);
        } else {
            btnAceptar.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRuta = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaIzquierda = new javax.swing.JList<>();
        btnAgregar = new javax.swing.JButton();
        btnAgregarTodos = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        btnQuitarTodos = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnAceptar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PARSER DE ARCHIVOS");
        setBackground(new java.awt.Color(254, 254, 254));
        setResizable(false);

        lblRuta.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        lblRuta.setText("No seleccionado");

        btnSeleccionar.setBackground(new java.awt.Color(101, 147, 193));
        btnSeleccionar.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        btnSeleccionar.setText("Seleccionar carpeta");
        btnSeleccionar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccione los archivos a enviar"));

        jScrollPane1.setViewportView(listaIzquierda);

        btnAgregar.setText(">");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnAgregarTodos.setText(">>");
        btnAgregarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTodosActionPerformed(evt);
            }
        });

        btnQuitar.setText("<");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        btnQuitarTodos.setText("<<");
        btnQuitarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarTodosActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Archivo", "Histórico", "Separador"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(385);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuitarTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(69, 69, 69)
                            .addComponent(btnAgregar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnAgregarTodos)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnQuitar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnQuitarTodos))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAceptar.setBackground(new java.awt.Color(101, 147, 193));
        btnAceptar.setText("Continuar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel1.setText("Ruta:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblRuta)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lblRuta))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAceptar)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        JFileChooser selector = new JFileChooser();
        selector.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int result = selector.showOpenDialog(this);
        if (result != JFileChooser.CANCEL_OPTION) {
            if (selector.getSelectedFile().canRead()) {
                String fileName = selector.getSelectedFile().getPath(); //getAbsolutePath
                try {
                    List<Object> lista = procesadorArchivo.hasRequiredExtensions(fileName);
                    lblRuta.setText(fileName);
                    for (int i = 0; i < lista.size(); i++) {
                        modeloListaIzquierda.addElement(lista.get(i).toString());
                    }
                    if (lista.size() > 0) {
                        toggleActivation(true);
                    } else {
                        toggleActivation(false);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(PantallaInicial.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Error al abrir el directorio\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El archivo no se puede leer", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        String seleccionado = listaIzquierda.getSelectedValue();
        if (seleccionado != null) {
            modelo.addRow(new Object[]{seleccionado, true, ","});
            modeloListaIzquierda.remove(listaIzquierda.getSelectedIndex());
        }
        toggleButton();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnAgregarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTodosActionPerformed

        for (int i = 0; i < modeloListaIzquierda.size(); i++) {
            modelo.addRow(new Object[]{modeloListaIzquierda.getElementAt(i), true, ","});
        }
        modeloListaIzquierda.removeAllElements();
        toggleButton();
    }//GEN-LAST:event_btnAgregarTodosActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        if (jTable2.getSelectedRow() != -1) {
            modeloListaIzquierda.addElement(jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString());
            modelo.removeRow(jTable2.getSelectedRow());
        }
        toggleButton();
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnQuitarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarTodosActionPerformed

        for (int i = 0; i < jTable2.getRowCount(); i++) {
            modeloListaIzquierda.addElement(jTable2.getValueAt(i, 0).toString());
        }
        modelo.setRowCount(0);
        toggleButton();
    }//GEN-LAST:event_btnQuitarTodosActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        boolean[] historicos = new boolean[jTable2.getRowCount()];
        for (int k = 0; k < jTable2.getRowCount(); k++) {
            historicos[k] = Boolean.parseBoolean(jTable2.getValueAt(k, 1).toString());
        }
        for (boolean b : historicos) {
            System.out.println(b);
        }

        List<List<List<Object>>> listaDeObjects = new ArrayList<>();
        List<List<Object>> listaDeEntidades = new ArrayList<>();

        int i = 0;

        try {
            for (i = 0; i < jTable2.getRowCount(); i++) {
                listaDeObjects.add(procesadorArchivo.parser(Boolean.parseBoolean(jTable2.getValueAt(i, 1).toString()), jTable2.getValueAt(i, 0).toString(), jTable2.getValueAt(i, 2).toString()));
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al convertir el archivo: " + jTable2.getValueAt(i, 0)+ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(PantallaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }

        crearJSON cj = new crearJSON();

        try {
            listaDeEntidades = cj.convertirAEntidades(listaDeObjects, historicos);
            System.out.println(cj.generarJSON(listaDeEntidades, historicos));
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Error al convertir una fecha..." + e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al convertir archivos..." + ex.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        
        try {
            JSONObject jo = cj.generarJSON(listaDeEntidades, historicos);
            JTextArea hoja = new JTextArea();
            hoja.setText(jo.toString(2));
            JOptionPane.showMessageDialog(this,hoja);
            EnvioRest er = new EnvioRest();
        
            URI uri = er.Envio(jo, "/servidor");
            if(uri==null){
                JOptionPane.showMessageDialog(this, "Error al enviar el JSON\n", "ERROR", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this, "El JSON fue recibido exitosamente. Puede acceder al contenido en: "+uri);
            }
        
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al generar JSON\n"+ex.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(PantallaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al enviar el JSON\n"+e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(PantallaInicial.class.getName()).log(Level.SEVERE, null, e);
        }
        
        

    }//GEN-LAST:event_btnAceptarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new PantallaInicial().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarTodos;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnQuitarTodos;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblRuta;
    private javax.swing.JList<String> listaIzquierda;
    // End of variables declaration//GEN-END:variables
}
