/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplovideo1;

/**
 * Esta clase representa el almacén, es decir, el recurso que se produce y se consume (Versión no sincronizada)
 * @author Francisco Jesús Delgado Almirón
 */
public class Buffer 
{
    private int contenido;
    
    /**
     * Obtiene el contenido del buffer
     * @return Contenido del buffer
     */
    public int get() 
    {
        return contenido;
    }
    
    /**
     * Inserta un valor dentro del buffer
     * @param value Valor para insertar
     */
    public void put(int value) 
    {
        contenido = value;
    }   
}

