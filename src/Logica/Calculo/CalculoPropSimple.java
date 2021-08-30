/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Calculo;

import java.util.*;
import Logica.Prop.PropSimple;

/**
 *
 * @author sebas
 */
public class CalculoPropSimple {
    
    private List<PropSimple> listaPropConTablas;
    
    public CalculoPropSimple(){
        listaPropConTablas = new ArrayList<>();
        }
    
    public void calcularTablaVerdad(List<PropSimple> listaProp){
        int numProps = listaProp.size();
        double numValores = Math.pow(2, numProps);
        listaPropConTablas = listaProp;
        
        int i = 0;
        
        for (PropSimple p : listaPropConTablas){
            
            List<Integer> listaValores = new ArrayList<>();
            double intervaloCero = Math.pow(2, i);
            double intervaloCiclo = 2*intervaloCero;
            int contadorCiclo = 0;
            
            for (int j = 0; j < numValores; j++){
                
                if(contadorCiclo == intervaloCiclo){
                    contadorCiclo = 0;
                }
                
                if(contadorCiclo < intervaloCero){
                    listaValores.add(0);
                }else if(contadorCiclo < intervaloCiclo){
                    listaValores.add(1);
                }
                
                contadorCiclo++;
            }
            
            p.setListaValores(listaValores);
            i++;
        }
    }
    
    public List<PropSimple> getListaConTablas(){
        return listaPropConTablas;
    }
}
