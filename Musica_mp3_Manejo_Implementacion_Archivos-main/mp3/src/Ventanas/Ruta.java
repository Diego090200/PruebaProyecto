/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import mp3.*;
import java.io.File;
import java.io.IOException;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class Ruta extends javax.swing.JInternalFrame  {
    //Se inicializa la jList
    DefaultListModel listModel;
    ArrayList<Canciones> nueva;
    public Ruta() throws IOException {
        initComponents();
        listModel = new DefaultListModel();
        jList1.setModel(listModel);
        String fullPath=new String();
        Scanner entrada = null;
        JFileChooser chooser = new JFileChooser();    
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        int valor = chooser.showOpenDialog(chooser);
        if (valor == JFileChooser.APPROVE_OPTION) {
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 

            File file = chooser.getSelectedFile(); 
            fullPath = file.getAbsolutePath(); 
            jTextFieldRuta.setText(fullPath);
        } else {
            System.out.println(" ");
        }
        Buscar prueba = new Buscar();
        File folder = new File(fullPath);
        prueba.listarFicherosPorCarpeta(folder);
        nueva = prueba.getListaCanciones();
        //Habiendo traido la lista desde la clase guardar, se los datos obtenidos en la
        //jlist para mostrar los archivos añadidos.
        for(int i=0; i<nueva.size(); i++){
            listModel.add(i, nueva.get(i).getNombreC());
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelRuta = new javax.swing.JLabel();
        jTextFieldRuta = new javax.swing.JTextField();
        jLabelArchivosImportados = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabelDisquera = new javax.swing.JLabel();
        jTextFieldDisquera = new javax.swing.JTextField();
        jLabelArtista = new javax.swing.JLabel();
        jTextFieldArtista = new javax.swing.JTextField();
        jLabelAlbum = new javax.swing.JLabel();
        jTextFieldAlbum = new javax.swing.JTextField();
        jLabelAño = new javax.swing.JLabel();
        jTextFieldAño = new javax.swing.JTextField();
        jLabelGenero = new javax.swing.JLabel();
        jTextFieldGenero = new javax.swing.JTextField();
        jLabelDireccion = new javax.swing.JLabel();
        jTextFieldDireccion = new javax.swing.JTextField();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabelRuta1 = new javax.swing.JLabel();
        jTextFieldRuta1 = new javax.swing.JTextField();
        jLabelArchivosImportados1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabelDisquera1 = new javax.swing.JLabel();
        jTextFieldDisquera1 = new javax.swing.JTextField();
        jLabelArtista1 = new javax.swing.JLabel();
        jTextFieldArtista1 = new javax.swing.JTextField();
        jLabelAlbum1 = new javax.swing.JLabel();
        jTextFieldAlbum1 = new javax.swing.JTextField();
        jLabelAño1 = new javax.swing.JLabel();
        jTextFieldAño1 = new javax.swing.JTextField();
        jLabelGenero1 = new javax.swing.JLabel();
        jTextFieldGenero1 = new javax.swing.JTextField();
        jLabelDireccion1 = new javax.swing.JLabel();
        jTextFieldArtista3 = new javax.swing.JTextField();
        jLabelURL_Autor = new javax.swing.JLabel();
        jTextFieldURL_Autor = new javax.swing.JTextField();
        jLabelURL_Disquera = new javax.swing.JLabel();
        jTextFieldURL_Disquera = new javax.swing.JTextField();
        jLabelBio_Comen = new javax.swing.JLabel();
        jTextFieldBio_Comen = new javax.swing.JTextField();

        setFocusable(false);
        setPreferredSize(new java.awt.Dimension(1036, 1000));

        jLabelRuta.setBackground(new java.awt.Color(255, 255, 255));
        jLabelRuta.setText("Ruta :");

        jLabelArchivosImportados.setText("Achivos Importados:");

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        jLabelDisquera.setText("Disquera:");

        jLabelArtista.setText("Artista:");

        jLabelAlbum.setText("Album:");

        jLabelAño.setText("Año:");

        jLabelGenero.setText("Genero:");

        jLabelDireccion.setText("Direccion:");

        jInternalFrame1.setFocusable(false);
        jInternalFrame1.setPreferredSize(new java.awt.Dimension(1036, 1000));

        jLabelRuta1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelRuta1.setText("Ruta :");

        jLabelArchivosImportados1.setText("Achivos Importados:");

        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jList2);

        jLabelDisquera1.setText("Disquera:");

        jLabelArtista1.setText("Artista:");

        jLabelAlbum1.setText("Album:");

        jLabelAño1.setText("Año:");

        jLabelGenero1.setText("Genero:");

        jLabelDireccion1.setText("Direccion:");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelArchivosImportados1)
                    .addComponent(jLabelRuta1)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDisquera1)
                            .addComponent(jTextFieldDisquera1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelArtista1)
                            .addComponent(jTextFieldArtista1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelAlbum1)
                            .addComponent(jTextFieldAlbum1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelAño1)
                            .addComponent(jTextFieldAño1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelGenero1)
                            .addComponent(jTextFieldGenero1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDireccion1)
                            .addComponent(jTextFieldArtista3, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTextFieldRuta1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelRuta1)
                .addGap(6, 6, 6)
                .addComponent(jTextFieldRuta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelArchivosImportados1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(402, 402, 402))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jLabelDisquera1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDisquera1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelArtista1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldArtista1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelAlbum1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldAlbum1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelAño1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldAño1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelGenero1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldGenero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelDireccion1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldArtista3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jLabelURL_Autor.setText("URL Autor:");

        jLabelURL_Disquera.setText("URL Disquera:");

        jLabelBio_Comen.setText("Biografia/Comentario:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelRuta)
                    .addComponent(jTextFieldRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelArchivosImportados)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDisquera)
                            .addComponent(jTextFieldDisquera, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelArtista)
                            .addComponent(jTextFieldArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelAlbum)
                            .addComponent(jTextFieldAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelAño)
                            .addComponent(jTextFieldAño, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelGenero)
                            .addComponent(jTextFieldGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(242, 242, 242)
                                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelDireccion)
                            .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelURL_Autor)
                            .addComponent(jTextFieldURL_Autor, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelURL_Disquera)
                            .addComponent(jTextFieldURL_Disquera, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelBio_Comen)
                            .addComponent(jTextFieldBio_Comen, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelRuta)
                .addGap(6, 6, 6)
                .addComponent(jTextFieldRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabelArchivosImportados)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelDisquera)
                        .addGap(6, 6, 6)
                        .addComponent(jTextFieldDisquera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabelArtista)
                        .addGap(6, 6, 6)
                        .addComponent(jTextFieldArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabelAlbum)
                        .addGap(6, 6, 6)
                        .addComponent(jTextFieldAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabelAño)
                        .addGap(6, 6, 6)
                        .addComponent(jTextFieldAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabelGenero)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addComponent(jLabelDireccion)
                        .addGap(6, 6, 6)
                        .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabelURL_Autor)
                        .addGap(6, 6, 6)
                        .addComponent(jTextFieldURL_Autor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabelURL_Disquera)
                        .addGap(6, 6, 6)
                        .addComponent(jTextFieldURL_Disquera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabelBio_Comen)
                        .addGap(6, 6, 6)
                        .addComponent(jTextFieldBio_Comen, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        //Se selecciona un nombre en la lista y ese se compara con los valores de nombre ingresados
        //En el array para poder así hallar los datos que le correspeden
        String selected = jList1.getSelectedValue();
        for(int i = 0; i<nueva.size(); i++){
            if (nueva.get(i).getNombreC() == null ? selected == null : nueva.get(i).getNombreC().equals(selected)){
                jTextFieldDisquera.setText(nueva.get(i).getDisquera());
                jTextFieldArtista.setText(nueva.get(i).getArtista());
                jTextFieldAlbum.setText(nueva.get(i).getAlbum());
                jTextFieldAño.setText(nueva.get(i).getAño());
                jTextFieldGenero.setText(nueva.get(i).getGenero());
                jTextFieldDireccion.setText(nueva.get(i).getDireccionC());
                jTextFieldURL_Autor.setText(nueva.get(i).getUrlAutor());
                jTextFieldURL_Disquera.setText(nueva.get(i).getUrlDisquera());
                jTextFieldBio_Comen.setText(nueva.get(i).getBiografia());
            }
        }
    }//GEN-LAST:event_jList1MouseClicked

    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jList2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabelAlbum;
    private javax.swing.JLabel jLabelAlbum1;
    private javax.swing.JLabel jLabelArchivosImportados;
    private javax.swing.JLabel jLabelArchivosImportados1;
    private javax.swing.JLabel jLabelArtista;
    private javax.swing.JLabel jLabelArtista1;
    private javax.swing.JLabel jLabelAño;
    private javax.swing.JLabel jLabelAño1;
    private javax.swing.JLabel jLabelBio_Comen;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelDireccion1;
    private javax.swing.JLabel jLabelDisquera;
    private javax.swing.JLabel jLabelDisquera1;
    private javax.swing.JLabel jLabelGenero;
    private javax.swing.JLabel jLabelGenero1;
    private javax.swing.JLabel jLabelRuta;
    private javax.swing.JLabel jLabelRuta1;
    private javax.swing.JLabel jLabelURL_Autor;
    private javax.swing.JLabel jLabelURL_Disquera;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextFieldAlbum;
    private javax.swing.JTextField jTextFieldAlbum1;
    private javax.swing.JTextField jTextFieldArtista;
    private javax.swing.JTextField jTextFieldArtista1;
    private javax.swing.JTextField jTextFieldArtista3;
    private javax.swing.JTextField jTextFieldAño;
    private javax.swing.JTextField jTextFieldAño1;
    private javax.swing.JTextField jTextFieldBio_Comen;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldDisquera;
    private javax.swing.JTextField jTextFieldDisquera1;
    private javax.swing.JTextField jTextFieldGenero;
    private javax.swing.JTextField jTextFieldGenero1;
    private javax.swing.JTextField jTextFieldRuta;
    private javax.swing.JTextField jTextFieldRuta1;
    private javax.swing.JTextField jTextFieldURL_Autor;
    private javax.swing.JTextField jTextFieldURL_Disquera;
    // End of variables declaration//GEN-END:variables
}
