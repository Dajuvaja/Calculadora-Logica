/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Calculo;

import java.util.*;
import Logica.Prop.*;

/**
 *
 * @author sebas
 */
public class DivisionPropSimple{
    
    private List<PropSimple> listaProp;
    
    public DivisionPropSimple(){
        listaProp = new ArrayList<>();
    }
    
    public void dividirProp(String expresionProp) {
        for(int i = 0 ; i < expresionProp.length() ; i++){
            
            char charProp = expresionProp.charAt(i);
            
            if( charProp == 'p' || charProp == 'q' || charProp == 'r' ){                               
                
                boolean yaExiste = false;
                
                for(PropSimple p : listaProp){
                    if(p.getExpresion().equals(String.valueOf(charProp))){
                        yaExiste = true;
                    }
                }
                
                if(!yaExiste){
                    PropSimple propSimple = new PropSimple(String.valueOf(charProp));
                    listaProp.add(propSimple);
                }
            }
        }
    }
    
    public List<PropSimple> getListaProp(){
        return listaProp;
    }
    
    
}
