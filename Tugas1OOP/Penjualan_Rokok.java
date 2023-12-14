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
public class Penjualan_Rokok {
    // atribut
   String namamerek; // Nama merek rokok
   int harga; // Harga jual per bungkus rokok
   int jumlah; // Jumlah rokok yang dibeli
    
    //method
      int hargajual(){
        return harga;
    }
       int jumlahbeli(){
       return jumlah;
    }
      int totaljual(){
        return harga*jumlah;
    } 
    String datamerekrokok(){
        return namamerek;
    }
}
