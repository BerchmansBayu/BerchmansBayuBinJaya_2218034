/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas2OOP;

/**
 *
 * @author ACER
 */
public class Penjualan_RokoK {
  // atribut
   String namamerek; // Nama merek rokok
   int harga; // Harga jual per bungkus rokok
   int jumlah; // Jumlah rokok yang dibeli
 
   //menginisialisasi nilai harga dengan construktor
   public Penjualan_RokoK(){
       this.harga=20000;
   }
   
    //method 
      int hargajual(){
        return harga;
    }
       int jumlahbeli(){
       return jumlah;
    }
        String datamerekrokok(){
        return namamerek;
    }
       //method hitung total jual 
        public double jumlahtotal (){
       double jumlahtl=harga*jumlah;
        return jumlahtl;       
    } 
}  
