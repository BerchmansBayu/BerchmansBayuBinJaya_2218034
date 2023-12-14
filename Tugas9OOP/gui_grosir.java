/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas9OOP;

import Tugas5OOP.*;
import Tugas4OOP.*;
import Tugas3OOP.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ACER
 */
public class gui_grosir extends javax.swing.JFrame {

    /**
     * Creates new form gui_eceran
     */
    public gui_grosir() {
        initComponents();
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
    public void clear() {
     txtNama.setText("");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnMenghitung = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        txtDiskon = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_rokokGrosir = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Jual Rokok Grosir");

        jLabel2.setText("Nama Rokok");

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

        txtDiskon.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        tabel_rokokGrosir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Nama Rokok", "Jumlah Beli", "Harga Per Kardus", "Total harga"
            }
        ));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(60, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNama, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                    .addComponent(txtHarga)
                                    .addComponent(txtDiskon))))
                        .addGap(119, 119, 119)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSimpan)
                                .addGap(41, 41, 41)
                                .addComponent(btnHapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBatal)
                                .addGap(44, 44, 44)
                                .addComponent(btnClose))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(321, 321, 321)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(btnMenghitung)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHapus)
                    .addComponent(btnBatal)
                    .addComponent(btnClose)
                    .addComponent(btnSimpan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(btnMenghitung)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(139, 139, 139))
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
        try {
        // Mengatur data Nama menggunakan nilai dari komponen txtNama
        String namaRokok = txtNama.getText();
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
        clear();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
    }

      
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
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
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabel_rokokGrosir;
    private javax.swing.JTextField txtDiskon;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
