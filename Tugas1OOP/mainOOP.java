/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas1OOP;

/**
 *
 * @author ACER
 */
public class mainOOP {
    public static void main (String[]args){ 
        // Membuat objek dari kelas Penjualan_Rokok
        Penjualan_Rokok penjualan1 = new Penjualan_Rokok();
        
        // Mengatur nilai atribut objek penjualan1
        penjualan1.namamerek ="sampoerna";
        penjualan1.harga =15000;
        penjualan1.jumlah = 2;
        
        // Mengakses metode dan atribut objek penjualan1
        System.out.println("Harga Rokok: "+penjualan1.hargajual()+"\n");
        System.out.println("Jumlah beli: "+penjualan1.jumlahbeli()+"\n");
        System.out.println("Total Harga: "+penjualan1.totaljual()+"\n");
    }
}
