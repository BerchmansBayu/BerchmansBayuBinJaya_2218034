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
public abstract class Abstrac_Rokok {

    //Mendeklarasikan atribut jumlahBeli sebagai private
    private int jumlahBeli;

    //Mendeklarasikan method JumlahTotal() sebagai abstract method.
    abstract double JumlahTotal();

    //Method get mengembalikan nilai dari variable
    public double getjumlahBeli() {
        return jumlahBeli;
    }

    //Method set digunakan untuk menetapkan nilai pada atribut
    public void SetjumlahBeli(int jumlahBeli) {
        this.jumlahBeli = jumlahBeli;
    }
}
