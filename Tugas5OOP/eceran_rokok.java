/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas5OOP;

import Tugas4OOP.*;
import Tugas3OOP.*;

/**
 *
 * @author ACER
 */
public class eceran_rokok  extends Penjualan_RokoK {
    //atribut
    double pajak;
    int hargarokok;
   public double totalHargaeceran;
    
  //set dan get untuk atribut hargarokok
    public void setHargaRokok(int hargarokok) {
        this.hargarokok = hargarokok;}
    public int getHargaRokok() {
        return hargarokok;}
    
    //konstruktor
    public eceran_rokok() {
         this.pajak = 0.05;}

    
  // overrinding diambil dari method super class
     @Override
    public double HitTotalrokok(double pajak) {
           totalHargaeceran = super.HitTotalrokok(pajak);
           return totalHargaeceran;
    }
  //set dan get untuk atribut totalharga
    public void setTotalHarga(double totalHarga) {
     this.totalHargaeceran = totalHarga;
    }
    public double getTotalHarga() {
     return totalHargaeceran;
    }
 }  

  
    



