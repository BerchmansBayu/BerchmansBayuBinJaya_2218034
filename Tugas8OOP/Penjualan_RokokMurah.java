/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas8OOP;

/**
 *
 * @author ACER
 */
//Mendeklarasikan class Penjualan_RokokMurah sebagai turunan dari class Abstrac_Rokok
public class Penjualan_RokokMurah extends Abstrac_Rokok {

    //Mendeklarasikan atribut 
    public String namaRokok;
    public int hargaRokok;
    double JumlahTotal;

    //Mendeklarasikan method JumlahTotal() sebagai override method JumlahTotal() dari class Abstrac_Rokok
    @Override
    double JumlahTotal() {
        return hargaRokok * getjumlahBeli();
    }

    //konstruktor tanpa parameter
    public Penjualan_RokokMurah() {
        this.hargaRokok = 2000;
    }

}
