/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas7OOP;

import Tugas6OOP.*;
import Tugas5OOP.*;
import Tugas4OOP.*;
import Tugas3OOP.*;
import Tugas2OOP.*;

/**
 *
 * @author ACER
 */
public class Penjualan_RokoK {
    //atribut
   public String namaRokok; 
   public int hargaRokok;
   private int jumlahBeli;
   protected double JumlahTotal;
   
   //Deklarasi polimorfisme dynamic di Super Class
   public void HitTotalrokok(){
        this.JumlahTotal=getJumlahTotal();
   } 
   
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
   
  
   // set dan get untuk atribut JumlahTotal
   public double getJumlahTotal(){
        return hargaRokok * jumlahBeli;}
   public void SetJumlahTotal(double JumlahTotal){
       this.JumlahTotal=JumlahTotal;
   }
  }
 