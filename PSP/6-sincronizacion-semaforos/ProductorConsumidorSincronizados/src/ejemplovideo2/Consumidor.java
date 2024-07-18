/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplovideo2;

/**
 * Esta clase representa al productor
 * @author Francisco Jesús Delgado Almirón
 */
public class Consumidor extends Thread 
{
    private Buffer almacen;
    private int dormir;
    
    /**
     * Constructor del consumidor
     * @param almacen Buffer de donde se obtendrán los recursos
     * @param dormir Tiempo que dormirá el consumidor
     */
    public Consumidor(Buffer almacen, int dormir) 
    {
        this.almacen = almacen;
        this.dormir = dormir;
    }
    
    public void run() 
    {
        int valor = 0;
        for (int i = 0; i < 10; i++) 
        {
            valor = almacen.get();
            System.out.println("Consumidor saca: "+ valor);
            try 
            {
                sleep(dormir);
            }
            catch (InterruptedException e) 
            {
                System.err.println("Error en el consumidor: " + e.toString());
            }
        }
    }
}
