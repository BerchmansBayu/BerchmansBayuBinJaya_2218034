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
public class grosir_rokok  extends Penjualan_RokoK{
    //atribut
    double diskon;

    //konstruktor
    public grosir_rokok() {
        this.diskon = 0.1;}
    
    //method
    protected double TotalGrosir() {
        return super.getJumlahTotal()- (super.getJumlahTotal()* diskon);}
}
