/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas10OOP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import Tugas9OOP.*;
import Tugas5OOP.*;
import Tugas4OOP.*;
import Tugas2OOP.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ACER
 */
public class gui_penjualanrokok extends javax.swing.JFrame {
 String nama1,harga1, jumlah1, total1;
    /**
     * Creates new form gui_penjualanrokok
     */
    public gui_penjualanrokok() {
        initComponents();
        tampil();
        //mengambil model data dari tabel dan menyimpannya dalam objek DefaultTableMOdel
        DefaultTableModel dataModel =(DefaultTableModel) tabel_rokokMurah.getModel();
        
        //mendapatkan jumlah baris dari yang ada dalam model data saat ini
        int rowCount = dataModel.getRowCount();
        while (rowCount>0) {
            //menghapus baris terakhir dari model data
            dataModel.removeRow(rowCount-1);
            //memperbaharui nilai reCount setelah penghapusan baris akhir
            rowCount=dataModel.getRowCount();
        }
       //mengambil nilai dari kelas ke gui
       Penjualan_RokoK rokok = new Penjualan_RokoK();
         txtHarga.setText(Integer.toString(rokok.hargaRokok));
          txtHarga.setEnabled(false);
    }
    
    
    public Connection conn;
    
    public void koneksi() throws SQLException {
        try {
            conn = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/penjualanrokok?user=root&password=");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(gui_penjualanrokok.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(gui_penjualanrokok.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception es) {
            Logger.getLogger(gui_penjualanrokok.class.getName()).log(Level.SEVERE, null, es);
        }
    }

    public void tampil() {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("Nama Rokok");
        tabelhead.addColumn("Harga Rokok");
        tabelhead.addColumn("Jumlah Beli");
        tabelhead.addColumn("Total Jumlah");
        try {
            koneksi();
            String sql = "SELECT * FROM penjualanrokok_murah";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                tabelhead.addRow(new Object[]{res.getString(2), res.getString(3), res.getString(4),});
            }
            tabel_rokokMurah.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
    }

    public void refresh() {
        new gui_penjualanrokok().setVisible(true);
        this.setVisible(false);
    }

    public void insert() {
        DefaultTableModel dataModel = (DefaultTableModel) tabel_rokokMurah.getModel();
        // Inisialisasi sebuah ArrayList bernama 'list'
        List list = new ArrayList<>();
        // Mengatur tabel untuk membuat kolom dari model secara otomatis

        tabel_rokokMurah.setAutoCreateColumnsFromModel(true);
        // Membuat instance dari kelas eceran_rokok
        Penjualan_RokoK murah = new Penjualan_RokoK();
        // Mengatur data Nama menggunakan nilai dari komponen txtNama
        murah.setNamaRokok(txtNama.getText());
        // Mengatur data Jumlah Beli menggunakan nilai dari komponen txtJumlah
        int Jumlah = Integer.parseInt(txtJumlah.getText());
        murah.SetjumlahBeli(Jumlah);
// Mengatur data Total Harga menggunakan nilai dari komponen txtTotal
        double Total = Double.parseDouble(txtTotal.getText());
        murah.SetJumlahTotal(Total);

// Menambahkan data-data dari objek Mahasiswa ke dalam ArrayList 'list'
        list.add(murah.getNamaRokok());
        list.add(murah.hargaRokok);
        list.add(murah.getjumlahBeli());
        list.add(murah.getJumlahTotal());

        // Menambahkan baris baru ke model tabel menggunakan data dari ArrayList 'list'
        dataModel.addRow(list.toArray());
        // Memanggil fungsi 'clear' untuk membersihkan nilai dari komponen

        String namaRokok = txtNama.getText();
        int hargaRokok = Integer.parseInt(txtHarga.getText());
        double jumlahTotal = Double.parseDouble(txtTotal.getText());
        int jumlahBeli = Integer.parseInt(txtJumlah.getText());
        try {
            koneksi();
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO penjualanrokok_murah (namaRokok, hargaRokok, jumlahBeli, jumlahTotal)"
                    + "VALUES('" + namaRokok + "','" + hargaRokok + "','" + jumlahBeli + "','" + jumlahTotal + "')");

            statement.close();
            JOptionPane.showMessageDialog(null, "Berhasil Memasukan Data Penjualan!" + "\n" + namaRokok);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!");
        }
    }
    
  


    public void update() {
        String namaRokok = txtNama.getText();
        int hargaRokok = Integer.parseInt(txtHarga.getText());
        double jumlahTotal = Double.parseDouble(txtTotal.getText());
        int jumlahBeli = Integer.parseInt(txtJumlah.getText());
        String namaLama = nama1;
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE penjualanrokok_murah SET namaRokok='" + namaRokok + "'," + "hargaRokok='" + hargaRokok + "',"
                    + "jumlahBeli='" + jumlahBeli + "'" + ",jumlahTotal='" + jumlahTotal + "' WHERE  namaRokok = '" + namaLama + "'");
            statement.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Update Data Penjualan rokok Murah Berhasil!");
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

    public void delete() {
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan menghapus data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            try {
                String sql = "DELETE FROM penjualanrokok_murah WHERE namaRokok='" + txtNama.getText() + "'";
                java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil di hapus");
                delete();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data gagal di hapus");
            }
        }
    }

    public void cari() {
        try {
            try (Statement statement = conn.createStatement()) {
                String sql = "SELECT * FROM penjualanrokok_murah WHERE `namaRokok`  LIKE '%" + txtSearch.getText() + "%'";
                ResultSet rs = statement.executeQuery(sql); //menampilkan data dari sql query
                if (rs.next()) // .next() = scanner method
                {
                    txtNama.setText(rs.getString(2));
                } else {
                    JOptionPane.showMessageDialog(null, "Data yang Anda cari tidak ada");
                }
            }
        } catch (Exception ex) {
            System.out.println("Error." + ex);
        }
    }

    public void itempilih() {
        txtNama.setText(nama1);
        txtHarga.setText(harga1);
        txtJumlah.setText(jumlah1);
        txtTotal.setText(total1);
    }

    
    public void clear() {
     txtNama.setText("");
     txtJumlah.setText("");
     txtHarga.setText("");
     txtTotal.setText("");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        btnMenghitung = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_rokokMurah = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnForm = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Jualan Rokok Murah");

        jLabel2.setText("Nama Rokok");

        jLabel3.setText("Harga Rokok");

        jLabel4.setText("Jumlah Beli");

        btnMenghitung.setText("Menghitung");
        btnMenghitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenghitungActionPerformed(evt);
            }
        });

        jLabel5.setText("Total Jumlah");

        tabel_rokokMurah.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Nama Rokok", "Jumlah Beli", "Total", "Harga rokok"
            }
        ));
        tabel_rokokMurah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_rokokMurahMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_rokokMurah);

        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setText("BATAL");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnClose.setText("CLOSE");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnForm.setText("Form Grosir");
        btnForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormActionPerformed(evt);
            }
        });

        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(41, 41, 41)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(38, 38, 38)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGap(35, 35, 35)
                                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(70, 70, 70)
                                    .addComponent(btnMenghitung)))
                            .addGap(160, 160, 160)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnSimpan)
                                    .addGap(33, 33, 33)
                                    .addComponent(btnHapus)
                                    .addGap(37, 37, 37)
                                    .addComponent(btnBatal)
                                    .addGap(35, 35, 35)
                                    .addComponent(btnClose)
                                    .addGap(36, 36, 36)
                                    .addComponent(btnUpdate))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnForm)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnSearch))))))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(jLabel3)
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(36, 36, 36)
                        .addComponent(btnMenghitung, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSearch)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnHapus)
                    .addComponent(btnBatal)
                    .addComponent(btnClose)
                    .addComponent(jLabel5)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnForm)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenghitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenghitungActionPerformed
        // TODO add your handling code here:
        //Membuat objek baru dari kelas
      Penjualan_RokoK eceran1 = new Penjualan_RokoK();
        eceran1.hargaRokok = Integer.parseInt(txtHarga.getText());
        eceran1.SetjumlahBeli(Integer.parseInt(txtJumlah.getText()));
        txtTotal.setText(Double.toString(eceran1.HitTotalrokok()));
    }//GEN-LAST:event_btnMenghitungActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        // Menampilkan pesan dialog bahwa data telah ditambahkan ke tabel
      
        insert();
        
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
         delete();
        DefaultTableModel dataModel = (DefaultTableModel) 
tabel_rokokMurah.getModel();
 int rowCount = dataModel.getRowCount();
 while (rowCount > 0){
 dataModel.removeRow(rowCount - 1);
 rowCount = dataModel.getRowCount();
 }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
         dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
         cari();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormActionPerformed
        // TODO add your handling code here:
        new gui_grosir().setVisible(true);
    }//GEN-LAST:event_btnFormActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tabel_rokokMurahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_rokokMurahMouseClicked
        // TODO add your handling code here:
        int tabel = tabel_rokokMurah.getSelectedRow();
        nama1 = tabel_rokokMurah.getValueAt(tabel, 0).toString();
        jumlah1 = tabel_rokokMurah.getValueAt(tabel, 1).toString();
        total1 = tabel_rokokMurah.getValueAt(tabel, 2).toString();
        harga1 = tabel_rokokMurah.getValueAt(tabel, 3).toString();      
        itempilih();

    }//GEN-LAST:event_tabel_rokokMurahMouseClicked

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
            java.util.logging.Logger.getLogger(gui_penjualanrokok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui_penjualanrokok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui_penjualanrokok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui_penjualanrokok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui_penjualanrokok().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnForm;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnMenghitung;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabel_rokokMurah;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
