/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp3;

import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class Principal extends javax.swing.JFrame {

    private ArrayList<MP3> data;
    DefaultTableModel modelo;
    private String cancionAEditar = "";
    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    
    public void getData() throws FileNotFoundException, IOException {
        jTable1.getTableHeader().setForeground(Color.BLACK);
        modelo = new DefaultTableModel();
        modelo.addColumn("Cancion");
        modelo.addColumn("Artista");
        modelo.addColumn("Album");
        modelo.addColumn("Genero");
        modelo.addColumn("Disquera");
        modelo.addColumn("Año");
        modelo.addColumn("Direccion");
        modelo.addColumn("Duracion");
        modelo.addColumn("URL Autor");
        modelo.addColumn("URL Disquera");
        modelo.addColumn("Biografia");
        RandomAccessFile lectura = new RandomAccessFile("canciones.data", "rw");
        short punteroIndice = lectura.readShort();
        lectura.seek(punteroIndice);
        for (int i = 0; i < lectura.length(); i++) {//Recorre el archivo para obtener los indices
            short posicionDatos = lectura.readShort();
            byte longitud = lectura.readByte();
            byte[] caracteres = new byte[longitud * 2];
            lectura.read(caracteres);
            String cancion = new String(caracteres);
            modelo.addRow(new Object[]{cancion, this.getArtista(posicionDatos), this.getAlbum(posicionDatos)});
            if (lectura.getFilePointer() == lectura.length()) {//Rompe si llega al final del archivo
                break;
            }
        }
        this.jTable1.setModel(modelo);
    }

    public String getArtista(int posicion) throws IOException {
        RandomAccessFile lectura = new RandomAccessFile("canciones.data", "rw");
        lectura.seek(posicion);
        byte longitud = lectura.readByte();
        byte[] caracteres = new byte[longitud * 2];
        lectura.read(caracteres);
        String cancion = new String(caracteres);
        return cancion;
    }

    public String getAlbum(int posicion) throws IOException {
        RandomAccessFile lectura = new RandomAccessFile("canciones.data", "rw");
        lectura.seek(posicion);
        byte longitud = lectura.readByte();
        byte[] caracteres = new byte[longitud * 2];
        lectura.read(caracteres);
        String cancion = new String(caracteres);
        byte longitud1 = lectura.readByte();
        byte[] caracteres1 = new byte[longitud1 * 2];
        lectura.read(caracteres1);
        String cancion1 = new String(caracteres1);
        return cancion1;
    }

    public void AgregarCarpetaMusica() throws IOException {
        JFileChooser jf = new JFileChooser();
        jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jf.showSaveDialog(null);
        LectorArchivos lee = new LectorArchivos(jf.getSelectedFile().getAbsolutePath());
        lee.SaveInformation();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButtonVer_Editar = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Lista De Canciones");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cancion", "Artista", "Album", "Genero", "Disquera", "Año", "Direccion", "Duracion", "URL Autor", "URL Disquera", "Biografia"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1040, 230));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Abri la carpeta de musica");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 330, -1, -1));

        jButtonVer_Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/edit.png"))); // NOI18N
        jButtonVer_Editar.setBorderPainted(false);
        jButtonVer_Editar.setContentAreaFilled(false);
        jButtonVer_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVer_EditarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVer_Editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 350, 40, -1));

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/folder.png"))); // NOI18N
        jToggleButton1.setBorderPainted(false);
        jToggleButton1.setContentAreaFilled(false);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 350, 40, 40));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ver o Editar");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 330, -1, -1));

        Fondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/17041.jpg"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        try {
            this.AgregarCarpetaMusica();
            this.getData();
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButtonVer_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVer_EditarActionPerformed
        if(cancionAEditar.equals("") == false){
            EditarDatos datos = new EditarDatos(cancionAEditar);
            try {
                datos.MostrarDatosEnFrame();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            datos.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione en la tabla la canción a editar",
                "IPORTANTE", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonVer_EditarActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton jButtonVer_Editar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}

