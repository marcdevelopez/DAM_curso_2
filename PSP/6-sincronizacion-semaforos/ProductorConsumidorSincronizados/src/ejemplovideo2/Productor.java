/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplovideo2;

/**
 * Esta clase representa el productor
 * @author Francisco Jesús Delgado Almirón
 */
public class Productor extends Thread 
{
    private Buffer almacen;
    private int dormir;
    
    /**
     * Constructor del productor
     * @param almacen Buffer donde se producirán los recursos
     * @param dormir Tiempo que dormirá el productor
     */
    public Productor(Buffer almacen, int dormir) 
    {
        this.almacen = almacen;
        this.dormir = dormir;
    }
    
    public void run() 
    {
        for (int i = 0; i < 10; i++) 
        {
            almacen.put(i);
            System.out.println("Productor pone: " + i);
            try 
            {
                sleep(dormir);
            } 
            catch (InterruptedException e) 
            {
                System.err.println("Error en el productor: " + e.toString());
            }
        }
    }
}
