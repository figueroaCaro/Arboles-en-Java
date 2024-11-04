package proyecto1edaii_equipo3;


import java.util.LinkedList;
import java.util.Queue;
import proyecto1edaii_equipo3.NodoAVL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Castillo Soto Jacqueline, Figueroa Ruiz Carolina, Isidro Castro Karen Cristina
 */
public class ArbolBin {
    NodoAVL root;    
    /**
     * Contructor de arbol vacio
     */
    public ArbolBin(){
        root=null;
    }
    /**
     * Constructor de arbol inicializando el valor de su raiz
     * @param val 
     */
    public ArbolBin(int val){
        root=new NodoAVL(val);
    }
    /**
     * Constructir estableciendo el nodo raiz
     * @param root el nodo raiz del arbolAVL
     */
    public ArbolBin(NodoAVL root){ //recibe un nodo y es la raiz
        this.root=root;
    }
    /**
     * Metodo que agrega un nodo a un arbol binario
     * @param padre
     * @param hijo
     * @param lado 
     */
    public void add(NodoAVL padre, NodoAVL hijo, int lado){
	if(lado==0)
            padre.setIzq(hijo);
	else
            padre.setDer(hijo);
    }
    /**
     * Metodo que visita el valor de un nodo
     * @param n nodo a visitar
     */
    protected void visit(NodoAVL n){ //imprime un nodo
        System.out.println(n.value+" ");    
    }	
    /**
     * metodo qur imprime los nodos por medio de bfs
     */
    public void breadthFrist(){      //imprime el arbol y debe recorrerlo para eso
        NodoAVL r = root;
	Queue<NodoAVL> queue = new LinkedList();
	if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (NodoAVL)queue.poll();
		visit(r);
		if(r.izq!=null)
                    queue.add(r.izq);
		if(r.der!=null)
		queue.add(r.der);
            }
	}
    }
    /**
     * mmetodo que elimina un nodo 
     * @param eliminar recibe el nodo a eliminar
     */
    public void eliminar(NodoAVL eliminar){
        NodoAVL remp = eliminar;
        if(eliminar.value==root.value){
            if(eliminar.izq==null && eliminar.der==null){
                System.out.println("Has eliminado la raiz y el arbol");
                root=null;
            }
        }
        else if(remp.izq!=null){
            System.out.println("a");
            if(remp.izq.der!=null){                
                remp=remp.izq;
                while(remp.der.der!=null){
                    remp=remp.der;
                }
                System.out.println("Se remplaza con el nodo de valor a: "+remp.der.value);
                eliminar.value=remp.der.value;
                remp.der=remp.der.izq;
            }
            else{
                System.out.println("Se remplaza con el nodo de valor: "+remp.izq.value);
                eliminar.value=remp.izq.value;
                remp.izq=remp.izq.izq;
            }
        }
        else if(remp.der!=null){
            if(remp.der.izq!=null){                
                remp=remp.der;
                while(remp.izq.izq!=null){
                    remp=remp.izq;
                }
                System.out.println("Se remplaza con el nodo de valor a: "+remp.izq.value);
                eliminar.value=remp.izq.value;
                remp.izq=remp.izq.der;
            }
            else{
                System.out.println("Se remplaza con el nodo de valor: "+remp.der.value);
                eliminar.value=remp.der.value;
                remp.der=remp.der.der;
            }
        }
        else{
            NodoAVL r = root;
            Queue<NodoAVL> queue = new LinkedList();
            if(r!=null){
                queue.add(r);
                while(!queue.isEmpty()){
                    r = (NodoAVL)queue.poll();                
                    if(r.izq==eliminar){
                        r.izq=null; 
                        break;
                    }
                    else if(r.der==eliminar){                        
                        r.der=null;
                        break;
                    }
                    if(r.izq!=null)
                        queue.add(r.izq);
                    if(r.der!=null)
                        queue.add(r.der);
                }
            }
        }
    }
    /**
     * metodo que busca un nodo
     * @param buscar el valor del nodo a buscar
     * @return regresa true o false si es que se encuentra el nodo
     */
    public boolean buscar(Integer buscar){
        NodoAVL r = root;
	Queue<NodoAVL> queue = new LinkedList();
	if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (NodoAVL)queue.poll();                
                if(r.value==buscar)
                    return true;
		if(r.izq!=null)
                    queue.add(r.izq);
		if(r.der!=null)
		queue.add(r.der);
            }
            return false;
	}
        else
            return false;
    }
    /**
     * metodo a buscar un nodo
     * @param buscar el valor del nodo a buscar
     * @return regresa el nodo buscado
     */
    public NodoAVL buscarnodo(Integer buscar){
        NodoAVL r = root;
	Queue<NodoAVL> queue = new LinkedList();
	if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (NodoAVL)queue.poll();                
                if(r.value==buscar)
                    return r;
		if(r.izq!=null)
                    queue.add(r.izq);
		if(r.der!=null)
		queue.add(r.der);
            }
            return null;
	}
        else
            return null;
    }
    /**
     * metodo de notacion prefija
     * @param r nodo a iniciar
     */
    private void preOrdenRecur(NodoAVL r){
        System.out.println("Nodo "+r.value);
        if(r.izq!=null)
            preOrdenRecur(r.izq);
        if(r.der!=null)
            preOrdenRecur(r.der);
    }
    /**
     * metodo de notacion prefija
     */
    public void preOrden(){
        NodoAVL r = root;
        System.out.println("Recorrido en Notacion Prefija:");
        preOrdenRecur(r);
    }
    
    private void inOrdenRecur(NodoAVL r){
        if(r.izq!=null)
            inOrdenRecur(r.izq);
        System.out.println("Nodo "+r.value);
        if(r.der!=null)
            inOrdenRecur(r.der);
    }
    /**
     * metodo de notacion infija
     */
    public void inOrden(){
        NodoAVL r = root;
        System.out.println("Recorrido en Notacion Infija:");
        inOrdenRecur(r);
    }
    /**
     * metodo de notacion postfija
     * @param iniciar nodo donde iniciar
     */
    public void PostOrden(NodoAVL iniciar){
        if(iniciar!=null){
            PostOrden(iniciar.izq);
            PostOrden(iniciar.der);
            System.out.print(iniciar.value+" ");
	}
    }

}

