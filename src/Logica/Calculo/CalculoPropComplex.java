/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Calculo;

import Logica.Prop.*;
import java.util.*;

/**
 *
 * @author sebas
 */
public class CalculoPropComplex {
    
    private List<PropComplex> listaPropConTablas;
    
    public CalculoPropComplex(){
        listaPropConTablas = new ArrayList<>();
    }
    
    public void calcularTablaVerdad(
            List<PropSimple> listaPropSimple, 
            List<PropComplex> listaPropComplex){
        
        listaPropConTablas = listaPropComplex;
        
        for (PropComplex pC : listaPropConTablas){
            
            String conector = pC.getConector();
            
            String comp2 = pC.getComp2();
            List<Integer> valoresComp2 = new ArrayList<>();
            boolean comp2Encontrado = false;
            
            String comp1 = pC.getComp1();
            List<Integer> valoresComp1 = new ArrayList<>();
            
            for(PropSimple p : listaPropSimple){
                if(p.getExpresion().equals(comp2)){
                    valoresComp2.addAll(p.getListaValores());
                    comp2Encontrado = true;
                    break;
                }
            }
            
            if(!comp2Encontrado){
                for(PropComplex pCx : listaPropConTablas){
                    if(pCx.getExpresion().equals(comp2)){
                        valoresComp2.addAll(pCx.getListaValores());
                        break;
                    }
                }
            }
            
            if(!conector.equals("¬")){
   
                boolean comp1Encontrado = false;
                
                for(PropSimple p : listaPropSimple){
                    if(p.getExpresion().equals(comp1)){
                        valoresComp1.addAll(p.getListaValores());
                        comp1Encontrado = true;
                        break;
                    }
                }
            
                if(!comp1Encontrado){
                    for(PropComplex pCx : listaPropConTablas){
                        if(pCx.getExpresion().equals(comp1)){
                            valoresComp1.addAll(pCx.getListaValores());
                            break;
                        }
                    }
                }
                
                //System.out.println("Lista de comp1: " + valoresComp1.toString());
            }
            
            //System.out.println("Lista de comp2: " + valoresComp2.toString());
            
            double numValores = Math.pow(2, listaPropSimple.size());
            List<Integer> valoresPropComplex = new ArrayList<>();
            
            for(int i = 0; i < numValores; i++){
                
                int valorComp2 = valoresComp2.get(i);
                
                if(conector.equals("¬")){
                    valoresPropComplex.add(negar(valorComp2));
                }else{
                    
                    int valorComp1 = valoresComp1.get(i);
                    
                    switch(conector){
                        case "∧":
                            valoresPropComplex.add(operarAnd(
                                    valorComp1, 
                                    valorComp2)
                            );
                            break;
                        case "∨":
                            valoresPropComplex.add(operarOr(
                                    valorComp1, 
                                    valorComp2)
                            );
                            break;
                        case "→":
                            valoresPropComplex.add(operarIfElse(
                                    valorComp1, 
                                    valorComp2)
                            );
                            break;
                        case "↔":
                            valoresPropComplex.add(operarIff(
                                    valorComp1, 
                                    valorComp2)
                            );
                            break;
                        default:
                            break;
                    }
                }  
            }
            
            pC.setListaValores(valoresPropComplex);
        }
    }
    
    public int negar(int num){
        if(num==1){
            return 0;
        }else{
            return 1;
        }
    }
    
    public int operarOr(int num1, int num2){
        if(num1 == 1 || num2 == 1){
            return 1;
        }else{
            return 0;
        }
    }
    
    public int operarAnd(int num1, int num2){
        if(num1 == 1 && num2 == 1){
            return 1;
        }else{
            return 0;
        }
    }
    
    public int operarIfElse(int num1, int num2){
        if(num1 == 1 && num2 == 0){
            return 0;
        }else{
            return 1;
        }
    }
    
    public int operarIff(int num1, int num2){
        if(num1 == num2){
            return 1;
        }else{
            return 0;
        }
    }
    
    public List<PropComplex> getListaConTablas(){
        return listaPropConTablas;
    }
    
}
