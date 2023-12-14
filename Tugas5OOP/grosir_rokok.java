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
public class grosir_rokok  extends Penjualan_RokoK{
    //atribut
    double diskon;
    int hargarokok;
    public double totalHargagrosir;
    
    //set dan get untuk atribut hargarokok
    public void setHargaRokok(int hargarokok) {
        this.hargarokok = hargarokok;}
    public int getHargaRokok() {
        return hargarokok;}
    
    //konstruktor
    public grosir_rokok() {
        this.diskon = 0.1;}
    
    // overrinding diambil dari method super class
    @Override
    public double HitTotalrokok(double diskon, double JmlhBeli) {
        return super.HitTotalrokok(diskon, JmlhBeli); 
    }
    
    //set dan get untuk atribut totalharga
    public void setTotalHarga(double totalHarga) {
     this.totalHargagrosir = totalHarga;
    }
    public double getTotalHarga() {
     return totalHargagrosir;
    }
}
