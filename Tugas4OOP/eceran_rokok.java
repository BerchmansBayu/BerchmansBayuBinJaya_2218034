/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas4OOP;

import Tugas3OOP.*;

/**
 *
 * @author ACER
 */
public class eceran_rokok  extends Penjualan_RokoK {
    //atribut
    double pajak;
    
    //konstruktor
    public eceran_rokok() {
         this.pajak = 0.05;}
    
    //method 
   protected double TotalEceran() {
    return super.getJumlahTotal() + (super.getJumlahTotal() * pajak);
}
}

