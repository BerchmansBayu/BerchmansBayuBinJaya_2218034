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

/**
 *
 * @author ACER
 */
public class grosir_rokok  extends Penjualan_RokoK{
    //atribut
    double diskon; int hargarokok;
    double JmlhBeli; double grosir;
    public double totalHargagrosir;
    
    //Override polimorfisme dynamic dari Super Class ke Sub Class
    @Override
    public void HitTotalrokok() {
        JmlhBeli=(int) getjumlahBeli();
        this.grosir=getJumlahTotal() - (JmlhBeli*hargaRokok) * diskon; 
    }
    
    //set dan get untuk atribut hargarokok
    public void setHargaRokok(int hargarokok) {
        this.hargarokok = hargarokok;}
    public int getHargaRokok() {
        return hargarokok;}
    
    //konstruktor
    public grosir_rokok() {
        this.diskon = 0.1;}

    //set dan get untuk atribut totalharga
    public void setTotalHarga(double totalHarga) {
     this.totalHargagrosir = totalHarga;
    }
    public double getTotalHarga() {
     return totalHargagrosir;
    }
}
