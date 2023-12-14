/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas8OOP;

import Tugas7OOP.*;
import Tugas6OOP.*;
import Tugas5OOP.*;
import Tugas4OOP.*;
import Tugas3OOP.*;

/**
 *
 * @author ACER
 */
//Mendeklarasikan class grosir_rokok sebagai turunan dari class Penjualan_RokokMurah dan mengimplementasikan interface interface_grosir
public class grosir_rokok extends Penjualan_RokokMurah implements interface_grosir {

    //atribut
    double diskon;
    int hargarokok;
    double JmlhBeli;
    double grosir;
    public double totalHargagrosir;

    //Mendeklarasikan method HitTotalGrosir() sebagai override 
    @Override
    public void HitTotalGrosir() {
        JmlhBeli = (int) getjumlahBeli();
        this.grosir = JumlahTotal() - (JmlhBeli * hargaRokok) * diskon;
    }
    //set dan get untuk atribut hargarokok
    public void setHargaRokok(int hargarokok) {
        this.hargarokok = hargarokok;
    }
    public int getHargaRokok() {
        return hargarokok;
    }
    //konstruktor
    public grosir_rokok() {
        this.diskon = 0.1;
    }
    //set dan get untuk atribut totalharga
    public void setTotalHarga(double totalHarga) {
        this.totalHargagrosir = totalHarga;
    }
    public double getTotalHarga() {
        return totalHargagrosir;
    }
}
