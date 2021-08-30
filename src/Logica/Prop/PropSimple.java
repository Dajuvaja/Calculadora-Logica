/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Prop;

import java.util.*;

/**
 *
 * @author sebas
 */
public class PropSimple{
    
    /**
     * Expresion de la proposición
     */
    private String expresion;

    /**
     * Lista de valores (tabla de valores)
     */
    private List<Integer> listaValores;
    
    private String tipo;
    
    /**
     * Constructor
     * @param expresion 
     */
    public PropSimple(String expresion){
        this.expresion = expresion;
    }
    
    /**
     *Regresa la expresion de la proposicion
     * @return expresion
     */
    public String getExpresion(){
        return expresion;
    }
    
    /**
     *Regresa la lista de valores
     * @return listaValores
     */
    public List getListaValores(){
        return listaValores;
    }
    
    /**
     *Establece los valores de la proposicion
     * @param listaValores
     */
    public void setListaValores(List<Integer> listaValores){
        this.listaValores = listaValores;
    }
    
    public String getTipo (){
        boolean hayUno = false;
        boolean hayCero = false;
        for (int num : listaValores) {
            if(num == 1){
                hayUno = true;
            }else{
                hayCero = true;
            }
        }
        
        if (hayUno == true && hayCero == true){
            tipo = "Contingencia";
        }else if (hayUno == true && hayCero == false){
            tipo = "Tautologia";
        }else{
            tipo = "Contradiccion";
        }
        
        return tipo;
    }
}
