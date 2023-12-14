/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas4OOP;

import Tugas3OOP.*;
import Tugas2OOP.*;

/**
 *
 * @author ACER
 */
public class Penjualan_RokoK {
    //atribut
    public String namaRokok; 
    public int hargaRokok,jumlahBeli;
    private double JumlahTotal;

     //konstruktor
    public Penjualan_RokoK() {
this.hargaRokok = 2000;
    }
    
    //method
   public String NamaRokok() {return namaRokok;}
   public int HargaRokok() {return hargaRokok;}
   public int JumlahBeli() {return jumlahBeli;}
   
     //Method get mengembalikan nilai dari variable
    public double getJumlahTotal(){
        return hargaRokok * jumlahBeli;
    }
  
    //Method set digunakan untuk menetapkan nilai pada atribut
   public void SetJumlahTotal(double JumlahTotal){
       this.JumlahTotal=JumlahTotal;
   }
}
 