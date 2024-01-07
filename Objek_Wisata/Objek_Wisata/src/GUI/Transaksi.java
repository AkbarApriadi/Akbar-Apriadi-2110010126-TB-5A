/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author ariff
 */
public class Transaksi extends javax.swing.JFrame {

    /**
     * Creates new form Transaksi
     */
    public Transaksi() {
        initComponents();
        load_data();
        IDOtomatis();
        loadComboBoxData();
    }
    
    public void load_data() {
        try {
            Connection kon = koneksi.koneksiDb();
            Object header[] = {"ID TRANSAKSI", "ID OBJEK WISATA", "ID JENIS WISATA", "TANGGAL", "JUMLAH ORANG"};
            DefaultTableModel data = new DefaultTableModel(null, header);
            jTable1.setModel(data);
            String sql_data = "SELECT * FROM transaksi";

            Statement st = kon.createStatement();
            ResultSet rs = st.executeQuery(sql_data);
            while (rs.next()) {
                String d1 = rs.getString(1);
                String d2 = rs.getString(2);
                String d3 = rs.getString(3);
                String d4 = rs.getString(4);
                String d5 = rs.getString(5);

                String d[] = {d1, d2, d3, d4, d5};
                data.addRow(d);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void IDOtomatis() {
        try {
            Connection kon = koneksi.koneksiDb();
            Statement st = kon.createStatement();
            String sql_id = "SELECT * FROM transaksi ORDER BY id_transaksi DESC LIMIT 1";
            ResultSet rs = st.executeQuery(sql_id);
            if (rs.next()) {
                String id_transaksi = rs.getString("id_transaksi");
                int counter = Integer.parseInt(id_transaksi.replaceAll("[^0-9]", "")) + 1;
                String AN = String.format("%05d", counter); // Format ID dengan 5 digit angka
                jTextField1.setText("T" + AN);
            } else {
                jTextField1.setText("T00001");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void loadComboBoxData() {
        try {
        Connection kon = koneksi.koneksiDb();
        String sql_objek_wisata = "SELECT id_objek_wisata FROM objek_wisata";
        String sql_jenis_wisata = "SELECT id_jenis_wisata FROM jenis_wisata";

        Statement st1 = kon.createStatement();
        Statement st2 = kon.createStatement();
        ResultSet rsObjekWisata = st1.executeQuery(sql_objek_wisata);
        ResultSet rsJenisWisata = st2.executeQuery(sql_jenis_wisata);

        while (rsObjekWisata.next()) {
            jComboBox1.addItem(rsObjekWisata.getString("id_objek_wisata"));
        }

        while (rsJenisWisata.next()) {
            jComboBox2.addItem(rsJenisWisata.getString("id_jenis_wisata"));
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
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

        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnTampil = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnKeluar = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Wisata Alam.png"))); // NOI18N
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 650));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTambah.setText("Tambah Data");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jPanel1.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, 174, 52));

        btnTampil.setText("Tampilkan Data");
        btnTampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTampilActionPerformed(evt);
            }
        });
        jPanel1.add(btnTampil, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 110, 174, 52));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("ID Transaksi");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("ID Objek Wisata");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("ID Jenis Wisata");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 190, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 200, -1));

        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 200, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Tanggal");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Jumlah Orang");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, -1, -1));

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 190, -1));
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 190, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Tampil Atas.png"))); // NOI18N
        jLabel5.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 210));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 710, 400));

        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });
        jPanel2.add(btnKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 190, 174, 52));

        btnHapus.setText("Hapus Data");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel2.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 110, 174, 52));

        btnUpdate.setText("Update Data");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, 174, 52));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1180, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        String id_transaksi = jTextField1.getText();
        String id_objek_wisata = jComboBox1.getSelectedItem().toString();
        String id_jenis_wisata = jComboBox2.getSelectedItem().toString();
        String tanggal = jTextField4.getText();
        String jumlah_orang = jTextField5.getText();

    try {
        Connection kon = koneksi.koneksiDb();
        Statement st = kon.createStatement();
        String sql = "INSERT INTO transaksi (id_transaksi, id_objek_wisata, id_jenis_wisata, tanggal, jumlah_orang) VALUES ('" + id_transaksi + "', '" + id_objek_wisata + "', '" + id_jenis_wisata + "', '" + tanggal + "', '" + jumlah_orang + "')";
        st.executeUpdate(sql);
        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
        load_data(); // Setelah menambah data, muat ulang tabel
        IDOtomatis(); // Perbarui ID otomatis
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnTampilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTampilActionPerformed
        // TODO add your handling code here:
        try {
            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("Transaksi.jasper"), null, koneksi.getConnection());
            JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_btnTampilActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String id_transaksi = jTextField1.getText();
        String id_objek_wisata = jComboBox1.getSelectedItem().toString();
        String id_jenis_wisata = jComboBox2.getSelectedItem().toString();
        String tanggal = jTextField4.getText();
        String jumlah_orang = jTextField5.getText();

        try {
            Connection kon = koneksi.koneksiDb();
            Statement st = kon.createStatement();
            String sql = "UPDATE transaksi SET id_objek_wisata='" + id_objek_wisata + "', id_jenis_wisata='" + id_jenis_wisata + "', tanggal='" + tanggal + "', jumlah_orang='" + jumlah_orang + "' WHERE id_transaksi='" + id_transaksi + "'";
            int rowsAffected = st.executeUpdate(sql);

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
                load_data(); // Muat ulang tabel setelah pembaruan
                btnUpdate.setEnabled(false); // Matikan kembali tombol Update setelah perubahan selesai
                clearFields(); // Panggil method clearFields untuk membersihkan JTextField
            } else {
                JOptionPane.showMessageDialog(null, "Gagal mengupdate data. Pastikan ID Transaksi yang dipilih benar.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        }

        private void clearFields() {
            jTextField1.setText(""); // Kosongkan ID Transaksi
            jComboBox1.setSelectedIndex(0); // Atur indeks pilihan ke 0 pada JComboBox ID Objek Wisata
            jComboBox2.setSelectedIndex(0); // Atur indeks pilihan ke 0 pada JComboBox ID Jenis Wisata
            jTextField4.setText(""); // Kosongkan tanggal
            jTextField5.setText(""); // Kosongkan jumlah_orang
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int selectedRowIndex = jTable1.getSelectedRow();

        if (selectedRowIndex != -1) {
            String id_transaksi = model.getValueAt(selectedRowIndex, 0).toString(); // Ambil ID dari baris yang dipilih
            try {
                Connection kon = koneksi.koneksiDb();
                Statement st = kon.createStatement();
                String sql = "DELETE FROM transaksi WHERE id_transaksi='" + id_transaksi + "'";
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                load_data(); // Setelah menghapus data, muat ulang tabel
                IDOtomatis(); // Perbarui ID otomatis
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih baris yang ingin dihapus");
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int selectedRowIndex = jTable1.getSelectedRow();

        // Cek jika baris telah dipilih
        if (selectedRowIndex >= 0) {
            // Aktifkan tombol Update jika baris dipilih
            btnUpdate.setEnabled(true);

            // Ambil data dari baris yang dipilih
            String id_transaksi = model.getValueAt(selectedRowIndex, 0).toString();
            String id_objek_wisata = model.getValueAt(selectedRowIndex, 1).toString();
            String id_jenis_wisata = model.getValueAt(selectedRowIndex, 2).toString();
            String tanggal = model.getValueAt(selectedRowIndex, 3).toString();
            String jumlah_orang = model.getValueAt(selectedRowIndex, 4).toString();

            // Masukkan data ke dalam JTextField
            jTextField1.setText(id_transaksi);
            // Atur nilai terpilih pada JComboBox
            jComboBox1.setSelectedItem(id_objek_wisata);
            jComboBox2.setSelectedItem(id_jenis_wisata);
            jTextField4.setText(tanggal);
            jTextField5.setText(jumlah_orang);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // Kembali ke HalamanUtama
        HalamanAwal HalamanAwal = new HalamanAwal();
        HalamanAwal.setVisible(true);
        dispose(); // Menutup JFrame ObjekWisata saat ini
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

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
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTampil;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
