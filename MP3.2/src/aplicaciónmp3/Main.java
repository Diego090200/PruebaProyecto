/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicaciónmp3;

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
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import aplicaciónmp3.EditarDatos;
import aplicaciónmp3.Imagen;
import aplicaciónmp3.LectorArchivos;
import aplicaciónmp3.MP3;

/**
 *
 * @author Daniel
 */
public class Main extends javax.swing.JFrame {

    private ArrayList<MP3> data;
    DefaultTableModel modelo;
    private String cancionAEditar = "";
    /**
     * Creates new form Main
     */
    public Main() throws FileNotFoundException, IOException {
        initComponents();
        jTable1.setDefaultEditor(Object.class, null);
        setResizable(false);
        setLocationRelativeTo(null);
        LectorArchivos Datos = new LectorArchivos();
        Imagen fondo = new Imagen("/Imagenes/images.jpg", jPanel1.getWidth(), jPanel1.getHeight() + 10);
        jPanel1.add(fondo);
        jPanel1.repaint();
        if (Datos.VerificarDatos() == false) {
            this.AgregarCarpetaMusica();
        }
        this.getData();
    }

    public void getData() throws FileNotFoundException, IOException {
        jTable1.getTableHeader().setFont(new Font("Arial", 1, 13));
        // cambia el fondo del encabezado de la tabla
        jTable1.getTableHeader().setBackground(Color.WHITE);
        // cambia el color de la letra del encabezado de la tabla
        jTable1.getTableHeader().setForeground(Color.BLACK);
        modelo = new DefaultTableModel();
        modelo.addColumn("Cancion");
        modelo.addColumn("Artista");
        modelo.addColumn("Album");
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

//        for (int i = 0; i < tabla.getListaArreglo(); i++) {
//            }
//            
//            datos[0]=String.valueOf(i);
//            datos[1]=anuncio;
//            datos[2]=lista;
//            modelo.addRow(datos);
//        
//        }
        this.jTable1.setModel(modelo);
//        tablita.getColumnModel().getColumn(0).setCellRenderer(tcr);
//        ColorFila color= new ColorFila(1);
//        tablita.getColumnModel().getColumn(1).setCellRenderer(color);
//        ColorFila color2=new ColorFila(2);
//        tablita.getColumnModel().getColumn(2).setCellRenderer(color2);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setEditingColumn(1);
        jTable1.setEditingRow(1);
        jTable1.setSelectionBackground(new java.awt.Color(51, 51, 255));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MI LISTA DE CANCIONES");

        jToggleButton1.setBackground(new java.awt.Color(153, 255, 0));
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AgregarMusica.jpg"))); // NOI18N
        jToggleButton1.setText("<html>Abrir nueva carpeta de música</html>");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ver.jpg"))); // NOI18N
        jButton1.setText("Ver o Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(301, 301, 301))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        try {
            this.AgregarCarpetaMusica();
            this.getData();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        JTable source = (JTable) evt.getSource();
        //            //int row = source.rowAtPoint( evt.getPoint() );
        //            int column = source.columnAtPoint( evt.getPoint() );
        //            String s=source.getModel().getValueAt(column, 1)+"";
        int index = jTable1.getSelectedRow();
        String s = source.getModel().getValueAt(index, 0).toString();//jala el primero elemento seleccionado
        this.cancionAEditar = s;
        final ImageIcon icon = new ImageIcon("src/Imagenes/D.png");       
        EditarDatos datos = new EditarDatos(s);
        try {
            datos.getData();
            data = datos.getListaEditar();
            s = "Canción: " + s + "\nAlbum: " + data.get(data.size() - 1).getNombre_album()
            + "\nArtista: " + data.get(data.size() - 1).getNombre_artista()
            + "\nFecha de álbum: " + data.get(data.size() - 1).getFecha_album()
            + "\nGenero: " + data.get(data.size() - 1).getGenero()
            + "\nDirección de la canción: " + data.get(data.size() - 1).getDireccion_pista()
            + "\nSi desea ver todos los datos de la canción presione en el boton ver de abajo "; 
            JOptionPane.showMessageDialog(null, s, "Información acerca de la canción", JOptionPane.INFORMATION_MESSAGE, icon);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(cancionAEditar.equals("") == false){
            EditarDatos datos = new EditarDatos(cancionAEditar);
            try {
                datos.MostrarDatosEnFrame();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            datos.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione en la tabla la canción a editar",
                    "IPORTANTE", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Main().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
