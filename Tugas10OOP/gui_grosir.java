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
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

import Tugas9OOP.*;
import Tugas5OOP.*;
import Tugas4OOP.*;
import Tugas3OOP.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;

/**
 *
 * @author ACER
 */
public class gui_grosir extends javax.swing.JFrame {
String nama1,diskon1, totalHargagrosir1, hargarokok1, jumlahBeli1;
    /**
     * Creates new form gui_eceran
     */
    public gui_grosir() {
        initComponents();
         tampil();
        tampil_mhs();

        //mengambil model data dari tabel dan menyimpannya dalam objek DefaultTableMOdel
        DefaultTableModel dataModel =(DefaultTableModel) tabel_rokokGrosir.getModel();
        
        //mendapatkan jumlah baris dari yang ada dalam model data saat ini
        int rowCount = dataModel.getRowCount();
        while (rowCount>0) {
            //menghapus baris terakhir dari model data
            dataModel.removeRow(rowCount-1);
            //memperbaharui nilai reCount setelah penghapusan baris akhir
            rowCount=dataModel.getRowCount();
        }
        //mengambil nilai dari kelas grosir_rokok ke gui
        grosir_rokok grosir1 = new grosir_rokok();
        txtDiskon.setText(Double.toString(grosir1.diskon));
        txtDiskon.setEnabled(false);
    }
    public Connection conn;
    
    public void batal() {
        txtDiskon.setText("");
        txtHarga.setText("");
        txtJumlah.setText("");
        txtTotal.setText("");
    }
    public void koneksi() throws SQLException {
        try {
            conn = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/penjualanrokok?user=root&password=");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(gui_grosir.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(gui_grosir.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception es) {
            Logger.getLogger(gui_grosir.class.getName()).log(Level.SEVERE, null, es);
        }
    }

    public void tampil() {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("Nama Rokok");
        tabelhead.addColumn("Jumlah Beli");
        tabelhead.addColumn("Harga per kardus");
        tabelhead.addColumn("Diskon");
        tabelhead.addColumn("Harga Total + Diskon");
        try {
            koneksi();
            String sql = "SELECT * FROM grosir_rokok";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                tabelhead.addRow(new Object[]{res.getString(2), res.getString(3), res.getString(4), res.getString(5),});
            }
            tabel_rokokGrosir.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
    }

    public void tampil_mhs() {
        try {
            koneksi();
            String sql = "SELECT namaRokok FROM penjualanrokok_murah order by namaRokok asc";
            Statement stt = conn.createStatement();
            ResultSet res = stt.executeQuery(sql);
            while (res.next()) {
                Object[] ob = new Object[3];
                ob[0] = res.getString(1);
                cmbNama.addItem((String) ob[0]);
            }
            res.close();
            stt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

   public void refresh() {
        new gui_grosir().setVisible(true);
        this.setVisible(false);
    }

    public void insert() {
        String namaRokok = (String) cmbNama.getSelectedItem();
        double diskon = Double.parseDouble(txtDiskon.getText());
        int hargarokok = Integer.parseInt(txtHarga.getText());
        double totalHargagrosir = Double.parseDouble(txtTotal.getText());
        int jumlahBeli = Integer.parseInt(txtJumlah.getText());

        try {
            koneksi();
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO grosir_rokok (namaRokok , diskon, hargarokok, totalHargagrosir,jumlahBeli)"
                    + "VALUES('" + namaRokok + "','" + diskon + "','" + hargarokok + "','" + totalHargagrosir + "','" + jumlahBeli + "')");
            statement.close();
            JOptionPane.showMessageDialog(null, "Berhasil Memasukan Data Nilai!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!");
        }
    }

    public void update() {
        String namaRokok = (String) cmbNama.getSelectedItem();
        double diskon = Double.parseDouble(txtDiskon.getText());
        int hargarokok = Integer.parseInt(txtHarga.getText());
        double totalHargagrosir = Double.parseDouble(txtTotal.getText());
        int jumlahBeli = Integer.parseInt(txtJumlah.getText());

        String namaRokok_lama = nama1;
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE grosir_rokok SET namaRokok='" + namaRokok + "'," + " diskon='" + diskon + "'"
                    + ",hargarokok ='" + hargarokok + "'totalHargagrosir ='" + totalHargagrosir + "', jumlahBeli='" + jumlahBeli + "' WHERE Nim ='" + namaRokok_lama + "'");
            statement.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Update Data Penjualan Grosir!");
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

    public void delete() {
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan menghapus data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            try {
                String sql = "DELETE FROM grosir_rokok WHERE namaRokok='" + cmbNama.getSelectedItem() + "'";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil di hapus");
                batal();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data gagal di hapus");
            }
        }
    }


public void cari() {
        try {
            try ( Statement statement = conn.createStatement()) {
                String sql = "SELECT * FROM grosir_rokok WHERE `namaRokok` LIKE '%" + txtSearch.getText() + "%'";
                ResultSet rs = statement.executeQuery(sql);
                //menampilkan data dari sql query
                if (rs.next()) // .next() = scanner method
                {
                    cmbNama.setSelectedItem(rs.getString(2));                                      

                } else {
                    JOptionPane.showMessageDialog(null, "Data yang Anda cari tidak ada");
                }
            }
        } catch (Exception ex) {
            System.out.println("Error." + ex);
        }
    }

void itempilih() {
        cmbNama.setSelectedItem(nama1);       
        txtDiskon.setText(diskon1);
        txtHarga.setText(hargarokok1);
        txtJumlah.setText(jumlahBeli1);
        txtTotal.setText(totalHargagrosir1);
        
    }

    
    
    
    public void clear() {
     txtJumlah.setText("");
     txtHarga.setText("");
     txtDiskon.setText("");
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnMenghitung = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        txtDiskon = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_rokokGrosir = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        cmbNama = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtUpdate = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Jual Rokok Grosir");

        jLabel3.setText("Jumlah Beli");

        jLabel4.setText("Harga per kardus");

        jLabel5.setText("Diskon");

        btnMenghitung.setText("Menghitung");
        btnMenghitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenghitungActionPerformed(evt);
            }
        });

        jLabel6.setText("Harga Total + Diskon");

        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        txtDiskon.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        tabel_rokokGrosir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Nama Rokok", "Jumlah Beli", "Harga Per Kardus", "Total harga"
            }
        ));
        tabel_rokokGrosir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_rokokGrosirMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_rokokGrosir);

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

        cmbNama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Rokok" }));
        cmbNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNamaActionPerformed(evt);
            }
        });

        jLabel7.setText("Nama ");

        txtUpdate.setText("UPDATE");
        txtUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUpdateActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(11, 11, 11)
                                            .addComponent(jLabel7))
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                    .addGap(36, 36, 36)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbNama, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(btnMenghitung)
                                    .addGap(30, 30, 30)
                                    .addComponent(txtTotal)))
                            .addComponent(jLabel6))
                        .addGap(182, 182, 182)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSimpan)
                                .addGap(30, 30, 30)
                                .addComponent(btnHapus)
                                .addGap(34, 34, 34)
                                .addComponent(btnBatal)
                                .addGap(29, 29, 29)
                                .addComponent(btnClose)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addComponent(txtUpdate))
                            .addComponent(jScrollPane2))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch)
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(jLabel6))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMenghitung)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSimpan)
                    .addComponent(btnHapus)
                    .addComponent(btnBatal)
                    .addComponent(btnClose)
                    .addComponent(txtUpdate))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenghitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenghitungActionPerformed
        // TODO add your handling code here:
        grosir_rokok grosir1 = new grosir_rokok();
        double dskn = Double.parseDouble(txtDiskon.getText());
        double jmlh = Double.parseDouble(txtJumlah.getText());
        grosir1.hargaRokok = Integer.parseInt(txtHarga.getText());
        grosir1.SetjumlahBeli(Integer.parseInt(txtJumlah.getText()));
        txtTotal.setText(Double.toString(grosir1.HitTotalrokok(dskn, jmlh)));
    }//GEN-LAST:event_btnMenghitungActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        // Menampilkan pesan dialog bahwa data telah ditambahkan ke tabel
         insert();
        try {
        // Mengatur data Nama menggunakan nilai dari komponen txtNama
         String namaRokok = (String) cmbNama.getSelectedItem();
  
        if (namaRokok.isEmpty()) {
            throw new Exception("Data Nama harus diisi");
        }
        if (!namaRokok.matches("[a-zA-Z]+")) {
            throw new Exception("Data Nama harus berupa huruf");
        }
        
        // Mengatur data Jumlah Beli menggunakan nilai dari komponen txtJumlah
        int jumlahBeli = 0;
        try {
            jumlahBeli = Integer.parseInt(txtJumlah.getText());
        } catch (NumberFormatException e) {
            throw new Exception("Data Jumlah Beli harus berupa angka");
        }
        
        // Mengatur data Harga menggunakan nilai dari komponen txtHarga
        String hargaRokokStr = txtHarga.getText();
        if (hargaRokokStr.isEmpty()) {
            throw new Exception("Data Harga harus diisi");
        }
        int hargaRokok = 0;
        try {
            hargaRokok = Integer.parseInt(hargaRokokStr);
        } catch (NumberFormatException e) {
            throw new Exception("Data Harga harus berupa angka");
        }
        
        // Mengatur data Total Harga menggunakan nilai dari komponen txtTotal
        double totalHarga = 0;
        try {
            totalHarga = Double.parseDouble(txtTotal.getText());
        } catch (NumberFormatException e) {
            throw new Exception("Data Total Harga harus berupa angka");
        }
        
        // Membuat instance dari kelas grosir_rokok
        grosir_rokok grosir = new grosir_rokok();
        grosir.setNamaRokok(namaRokok);
        grosir.SetjumlahBeli(jumlahBeli);
        grosir.setHargaRokok(hargaRokok);
        grosir.setTotalHarga(totalHarga);

        // Menambahkan data-data dari objek grosir_rokok ke dalam ArrayList 'list'
        List<Object> list = new ArrayList<>();
        list.add(grosir.getNamaRokok());
        list.add(grosir.getjumlahBeli());
        list.add(grosir.getHargaRokok());
        list.add(grosir.getTotalHarga());

        // Menambahkan baris baru ke model tabel menggunakan data dari ArrayList 'list'
        DefaultTableModel dataModel = (DefaultTableModel) tabel_rokokGrosir.getModel();
        dataModel.addRow(list.toArray());

        // Menampilkan pesan dialog bahwa data telah ditambahkan ke tabel
        JOptionPane.showMessageDialog(null, "Data Anda Ditambahkan ke Tabel");

        // Memanggil fungsi 'clear' untuk membersihkan nilai dari komponen
      
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
    }  
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        delete();
         DefaultTableModel dataModel = (DefaultTableModel) 
tabel_rokokGrosir.getModel();
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

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUpdateActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_txtUpdateActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
         cari();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void cmbNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbNamaActionPerformed
        // TODO add your handling code here:
        new gui_penjualanrokok().setVisible(false);
    }//GEN-LAST:event_cmbNamaActionPerformed

    private void tabel_rokokGrosirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_rokokGrosirMouseClicked
        // TODO add your handling code here:
        int tabel = tabel_rokokGrosir.getSelectedRow(); //0
        nama1 = tabel_rokokGrosir.getValueAt(tabel, 0).toString();       
        jumlahBeli1 = tabel_rokokGrosir.getValueAt(tabel, 1).toString();
        hargarokok1 = tabel_rokokGrosir.getValueAt(tabel, 2).toString();
        totalHargagrosir1 = tabel_rokokGrosir.getValueAt(tabel, 3).toString();
        diskon1 = tabel_rokokGrosir.getValueAt(tabel, 4).toString();
        itempilih();

    }//GEN-LAST:event_tabel_rokokGrosirMouseClicked

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
            java.util.logging.Logger.getLogger(gui_grosir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui_grosir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui_grosir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui_grosir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new gui_grosir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnMenghitung;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cmbNama;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabel_rokokGrosir;
    private javax.swing.JTextField txtDiskon;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JButton txtUpdate;
    // End of variables declaration//GEN-END:variables
}
