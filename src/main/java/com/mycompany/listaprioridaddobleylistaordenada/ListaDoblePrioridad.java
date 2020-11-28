/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.listaprioridaddobleylistaordenada;

/**
 *
 * @author REAL
 */
public class ListaDoblePrioridad {
    protected Nodo ini=null;
    protected Nodo fin=null;
  
    public boolean push(char x,int y){
        
        Nodo temp=new Nodo(x,y);
        
        if(temp==null){
            return false;
        }
        
        if(ini==null && fin== null){
            ini=fin=temp;
            return true;
        }
     
        if(temp.prio>ini.prio){
                ini.ant=temp;
                temp.sig=ini;
                ini=temp;   
                return true;
            }
        
        if(temp.prio<=fin.prio){
            fin.sig=temp;
                temp.ant=fin;
                fin=temp; 
                return true;
        }
        
        Nodo temp2=null;
        
        for(temp2=fin.ant;temp.prio>temp2.prio;temp2=temp2.ant){ }
            
        temp2.sig.ant=temp;
        temp.sig=temp2.sig;
        temp.ant=temp2;
        temp2.sig=temp;
        return true;
    }
    
    public boolean pop(char x,int y){
        
        Nodo temp=new Nodo(x,y);
        
        if(ini==null && fin== null){
            return false;
        }

        if(ini==fin && ini!=null ){
            if(ini.valor==x && ini.prio==y){
                fin=ini=null;
                return true;
            }
            return false;
        }

        if(ini.valor==x && ini.prio==y){
            temp=ini.sig;
            temp.ant=null;
            ini.sig=null;
            ini=temp;
            return true;
        }

        if(fin.valor==x && fin.prio==y){           
            temp=fin.ant;
            temp.sig=null;
            fin.ant=null;
            fin=temp;
            return true;  
        }

        for(temp=ini.sig; temp!=fin; temp=temp.sig ){
            
            if(temp.valor==x && temp.prio==y){
                
                temp.ant.sig=temp.sig;
                temp.sig.ant=temp.ant;
                temp.ant=null;
                temp.sig=null;
                return true; 
            }
        } 
        return false;  
    }
    
    public String mostrar(){
        if(ini==null && fin==null){
            return "LISTA VACIA";
        }
        return mostrar(ini);
    }
    
    private String mostrar(Nodo temp){
        if(temp==null){
            return"";
        }
        return temp.valor+"* "+temp.prio+" - "+mostrar(temp.sig);
                
    }
    
}
