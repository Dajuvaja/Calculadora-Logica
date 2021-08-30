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
public class DivisionPropComplex{

    private List<PropComplex> listaProp;
    
    public DivisionPropComplex(){
        listaProp = new ArrayList<>();
    }
    
    public void dividirProp(String expresionProp) {
        List<Character> posibleProps = new ArrayList<>();
        
        for (int i=0; i<expresionProp.length() ; i++){
            posibleProps.add(expresionProp.charAt(i));
        }
        
        posibleProps = removerParentesis(posibleProps);
        expresionProp = convertListToString(posibleProps);
        
        int contParentesis = 0;
        
        
        if (expresionProp.length() >=2){
            
            boolean propComplexEncontrada = false;
            boolean yaExiste = false;
            char posibleConector = 0;
            int indexConector = 0;
            int i = 0;
            int valueJerarquia = 0;
            
            for (Character c : posibleProps){
                    
                if(c.equals('(')){
                    contParentesis++;
                }
                if(c.equals(')')){
                    contParentesis--;
                } 
                if(contParentesis == 0){
                    
                    switch(c){
                        case '¬':
                            if(valueJerarquia <1){
                                propComplexEncontrada = true;
                                posibleConector = c;
                                indexConector = i;   
                                valueJerarquia = 1;
                            }
                            break;
                        case '∧':
                            if(valueJerarquia <2){
                                propComplexEncontrada = true;
                                posibleConector = c;
                                indexConector = i;
                                valueJerarquia = 2;
                            }
                            break;
                        case '∨':
                            if(valueJerarquia <3){
                                propComplexEncontrada = true;
                                posibleConector = c;
                                indexConector = i;
                                valueJerarquia = 3;
                            }
                            break;
                        case '→':
                            if(valueJerarquia <4){
                                propComplexEncontrada = true;
                                posibleConector = c;
                                indexConector = i;
                                valueJerarquia = 4;
                            }
                            break;
                        case '↔':
                            if(valueJerarquia <5){
                                propComplexEncontrada = true;
                                posibleConector = c;
                                indexConector = i;
                                valueJerarquia = 5;
                            }
                            break;
                        default:
                            break;
                    }                
                }
                
                i++;
            }
            
            if(propComplexEncontrada){
    
                for(PropComplex p : listaProp){
                    if(p.getExpresion().equals(expresionProp)){
                        yaExiste = true;
                    }      
                }
                            
                if(!yaExiste){
                    
                    String conector = String.valueOf(posibleConector);
                    List<Character> comp1 = new ArrayList<>(posibleProps.subList(0, indexConector));
                    List<Character> comp2 = new ArrayList<>(posibleProps.subList(indexConector+1, posibleProps.size()));
                    
                    String comp1Str = "";
                    String comp2Str = "";
                    
                    if(!comp1.isEmpty()){
                        comp1 = removerParentesis(comp1);
                        comp1Str = convertListToString(comp1);
                        dividirProp(comp1Str);
                    }
                    if(!comp2.isEmpty()){
                        comp2 = removerParentesis(comp2);
                        comp2Str = convertListToString(comp2);
                        dividirProp(comp2Str);
                    }   
                    
                    PropComplex propComplex = new PropComplex(expresionProp, 
                            comp1Str, 
                            comp2Str, 
                            conector);
                
                    listaProp.add(propComplex);
                }
            }   
        }
    }
    
    public List<PropComplex> getListaProp(){
        return listaProp;
    }
    
    public String convertListToString(List<Character> lista){
        StringBuilder nuevoString = new StringBuilder(lista.size());
        
        for(Character c : lista){
            nuevoString.append(c);
        }
        
        return nuevoString.toString();
    }
    
    public List<Character> removerParentesis(List<Character> lista){
        
        int contParentesis = 0;
        int cantidadCadenas = 0;
        
        if (lista.get(0).equals('(') 
                && lista.get(lista.size()-1).equals(')')){
            
            for (Character c : lista) {
                if(c.equals('(')){
                   contParentesis++;
                }
                if(c.equals(')')){
                    contParentesis--;
                    if(contParentesis == 0){
                        cantidadCadenas++;
                    }
                } 
            }
        }
        
        if(cantidadCadenas == 1){
            lista.remove(0);
            lista.remove(lista.size()-1); 
            lista=removerParentesis(lista);
        }
        
        return lista; 
    }
    
}
