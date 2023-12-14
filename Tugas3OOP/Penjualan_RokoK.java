/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas3OOP;

import Tugas2OOP.*;

/**
 *
 * @author ACER
 */
public class Penjualan_RokoK {
    //atribut
     String namaRokok; int hargaRokok,jumlahBeli;

     //konstruktor
    public Penjualan_RokoK() {
this.hargaRokok = 2000;
    }
    
    //method
   String NamaRokok() {return namaRokok;}
   int HargaRokok() {return hargaRokok;}
   int JumlahBeli() {return jumlahBeli;}
 public double JumlahTotal() {return hargaRokok * jumlahBeli;}
}
 