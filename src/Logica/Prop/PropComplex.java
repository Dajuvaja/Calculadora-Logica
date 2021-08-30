/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Prop;

import java.util.*;


public class PropComplex{
    
    /**
     * Expresion de la proposición
     */
    private String expresion;

    /**
     * Lista de valores (tabla de valores)
     */
    private List<Integer> listaValores;
    
    /**
     * Parte izquierda de la proposicion compleja
     */
    private String comp1;
    /**
     * Parte derecha de la proposicion compleja
     */
    private String comp2;
    
    private String tipo;
    /**
     * Conector que indica la operacion
     */
    private String conector;
    
    /**
     * Constructor de la proposicion compleja
     * @param expresion
     * @param comp1
     * @param comp2
     * @param conector 
     */
    public PropComplex(String expresion, 
            String comp1, 
            String comp2, 
            String conector){
        
        this.expresion = expresion;
        this.comp1 = comp1;
        this.comp2 = comp2;
        this.conector = conector;
    }
     /**
      * Devuelve el componente 1 de la proposicion
      * @return comp1
      */
    public String getComp1(){
        return comp1;
    }
    /**
     * Devuelve el componente 2 de la proposicion
     * @return comp2
     */
    public String getComp2(){
        return comp2;
    }
    
    /**
     * Devuelve el conector de la proposicion
     * @return conector
     */
    public String getConector(){
        return conector;
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
