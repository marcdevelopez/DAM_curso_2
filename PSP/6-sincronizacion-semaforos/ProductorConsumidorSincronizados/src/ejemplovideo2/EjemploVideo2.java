/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplovideo2;

/**
 *
 * @author Francis
 */
public class EjemploVideo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int DORMIR_PRODUCTOR = 1000, DORMIR_CONSUMIDOR = 2000;
        
        Buffer almacen = new Buffer();
        Productor productor = new Productor(almacen, DORMIR_PRODUCTOR);
        Consumidor consumidor = new Consumidor(almacen, DORMIR_CONSUMIDOR);
        
        productor.start();
        consumidor.start();
    }
    
}
