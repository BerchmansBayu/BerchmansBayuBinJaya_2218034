/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas8OOP;

import Tugas6OOP.*;
import Tugas5OOP.*;
import Tugas4OOP.*;
import Tugas3OOP.*;

/**
 *
 * @author ACER
 */
//Mendeklarasikan class eceran_rokok sebagai turunan dari class Penjualan_RokokMurah dan mengimplementasikan interface interface_eceran
public class eceran_rokok extends Penjualan_RokokMurah implements interface_eceran {

    //atribut
    double pajak;
    int hargarokok;

    //override dari  HitTotalEceran
    @Override
    public double HitTotalEceran() {
        return JumlahTotal = JumlahTotal() + JumlahTotal() * pajak;
    }

    //set dan get untuk atribut hargarokok
    public void setHargaRokok(int hargarokok) {
        this.hargarokok = hargarokok;
    }

    public int getHargaRokok() {
        return hargarokok;
    }

    //konstruktor
    public eceran_rokok() {
        this.pajak = 0.05;
    }
}

  
    



