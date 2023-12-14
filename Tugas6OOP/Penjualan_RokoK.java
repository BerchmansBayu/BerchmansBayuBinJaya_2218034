/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas6OOP;

import Tugas5OOP.*;
import Tugas4OOP.*;
import Tugas3OOP.*;
import Tugas2OOP.*;

/**
 *
 * @author ACER
 */
public abstract class Penjualan_RokoK {
    //atribut
   public String namaRokok; 
   public int hargaRokok;
   private int jumlahBeli;
   protected double JumlahTotal;
   
   //abstract method
   abstract double HitTotalEceran();
   
     //konstruktor
    public Penjualan_RokoK() {
    this.hargaRokok = 2000;
    }
      
     //Method get mengembalikan nilai dari variable
    public double getjumlahBeli(){
        return jumlahBeli;}
    //Method set digunakan untuk menetapkan nilai pada atribut
   public void SetjumlahBeli(int jumlahBeli){
       this.jumlahBeli=jumlahBeli;}
   
   //method overloding
   public double HitTotalrokok(){
        return JumlahTotal=getJumlahTotal();
   } 
   public double HitTotalrokok(double diskon,double JmlhBeli){
        JmlhBeli=(int) getjumlahBeli();
    return JumlahTotal=getJumlahTotal() - (JmlhBeli*hargaRokok) * diskon;
     }
   
   // set dan get untuk atribut JumlahTotal
   public double getJumlahTotal(){
        return hargaRokok * jumlahBeli;}
   public void SetJumlahTotal(double JumlahTotal){
       this.JumlahTotal=JumlahTotal;
   }
  }
 