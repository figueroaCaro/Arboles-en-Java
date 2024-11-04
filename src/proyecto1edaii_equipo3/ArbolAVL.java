
package proyecto1edaii_equipo3;

import static java.lang.Integer.max;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import proyecto1edaii_equipo3.ArbolBin;
import proyecto1edaii_equipo3.NodoAVL;

/**
 *
 * @author Castillo Soto Jacqueline, Figueroa Ruiz Carolina, Isidro Castro Karen Cristina
 */
public class ArbolAVL extends ArbolBin{
    /**
     * Crea un constructor vacio
     */
    public ArbolAVL() {
    }
    /**
     * Constructor que inicializa el valor de la raiz
     * @param val valor de tipo entero para inicializar la raiz
     */
    public ArbolAVL(int val) {
        super(val);
    }
    /**
     * Constructor que establece el nodo raiz
     * @param root es el nodo raiz del ArbolAVL 
     */
    public ArbolAVL(NodoAVL root) {
        super(root);
    }
    /**
     * Metodo que evita errores al establecer la altura de un nodo si llega a ser nulo
     * @param r Nodo que se quiere averiguar su altura
     * @return la altura correspondiende del nodo
     */
    public int altura(NodoAVL r){
        if(r==null)
            return 0;
        else
            return r.getNivel();
    }
    /**
     * metodo que rota el arbolAVL hacia la derecha
     * @param r Nodo que simboliza la raiz del subarbol que sera rotado a la derecha 
     * @return regresa el subarbol rotado
     */
    public NodoAVL rotationder(NodoAVL r){
        NodoAVL newr=r.izq;
        NodoAVL aux=newr.der;
        newr.der=r;
        r.izq=aux;
        r.nivel=max(altura(r.izq),altura(r.der))+1;
        newr.nivel=max(altura(newr.izq),altura(newr.der))+1;
        return newr;
    }
    /**
     * metodo que rota el arbolAVL hacia la izquierda
     * @param r Nodo que simboliza la raiz del subarbol que sera rotado a la izquierda
     * @return regresa el subarbol rotado
     */
    public NodoAVL rotationizq(NodoAVL r){
        NodoAVL newr=r.der;
        NodoAVL aux=newr.izq;
        newr.izq=r;
        r.der=aux;
        r.nivel=max(altura(r.izq),altura(r.der))+1;
        newr.nivel=max(altura(newr.izq),altura(newr.der))+1;
        return newr;
    }
    /**
     * Metodo que inserta un nodo al arbolAVL
     * @param value recibe valor a insertar
     * @param raiz recibe la raiz del arbol o al ser recursiva subarboles 
     * @return regresa los nodos y sus hijos o subarboles balanceados
     */
    public NodoAVL add(int value, NodoAVL raiz){
        NodoAVL r=raiz;
        NodoAVL auxiliar=new NodoAVL(value);
        if (r == null) {
            return auxiliar;
        }
        if (value < r.value) {
            r.izq = add(value,r.izq);
        }
        else if (value> r.value) {
            r.der = add(value,r.der);
        }
        r.nivel=1+max(altura(r.izq),altura(r.der));
        int fe=Fe(r);
        if (fe > 1 && value > r.der.value) {
            return rotationizq(r);
        }
        if(fe<-1 && value<r.izq.value){
            return rotationder(r);
        }
        if(fe>1 && value<r.der.value){
          r.der=rotationder(r.der);
          return rotationizq(r);
          
        }
        if(fe<-1 && value>r.izq.value){
          r.izq=rotationizq(r.izq);
          return rotationder(r);
        }
        return r;
    }
    /**
     * obtiene el factor de equilibrio
     * @param r recibe el nodo que se calculara su factor de equilibrio
     * @return regresa el factor de equilibro correpsondiente
     */
    private int Fe(NodoAVL r) {
        if (r == null) {
            return 0;
        }
        return altura(r.der)- altura(r.izq);
    }
    /**
     * metodo de busqueda binaria para encontrar un nodo en el arbolAVL
     * @param buscar el valor del nodo a buscar
     * @param r recibe el nodo donde comenzar a buscar
     */
    public void buscarn(int buscar, NodoAVL r){
        if(r.value==buscar){
            System.out.println("SI existe un nodo con value de "+buscar+" en el arbol binario de busqueda");
        }
        else if (r.value>buscar){
            if(r.izq!=null)
                buscarn(buscar, r.izq);
            else
                System.out.println("No existe un nodo en el arbol binario de busqueda con valor de "+buscar);
        }
        else{
            if(r.der!=null)
                buscarn(buscar, r.der);
            else
                System.out.println("No existe un nodo en el arbol binario de busqueda con valor de "+buscar);
        }
    }
    /**
     * metodo que busca el padre de un nodo
     * @param buscar valor del nodo hijo
     * @return regresa el nodo padre
     */
    public NodoAVL buscarp(Integer buscar){
       NodoAVL r = root;
	Queue<NodoAVL> queue = new LinkedList();
	if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (NodoAVL)queue.poll(); 
                if(r.izq!= null){
                    if(r.izq.value==buscar)
                        return r;
                }  
                if(r.der!= null){
                    if(r.der.value==buscar)
                        return r;
                } 
		if(r.izq!=null)
                    queue.add(r.izq);
		if(r.der!=null)
                    queue.add(r.der);
            }
	}
        return null;
    }
    public NodoAVL balance(int value, NodoAVL raiz){
        NodoAVL r=raiz;
        if (r == null) {
        }
        else if (value < r.value) {
            balance(value,r.izq);
        }
        else if (value> r.value) {
            balance(value,r.der);
        }
        System.out.println(r.value);
        r.nivel=1+max(altura(r.izq),altura(r.der));
        int fe=Fe(r);
        if (fe > 1 && Fe(r.izq)>=0) {
            System.out.println("a");
            return rotationizq(r);
        }
        else if(fe<-1 && Fe(r.der)<=0){
            System.out.println("b");
            return rotationder(r);
        }
        if(fe>1 && Fe(r.der)<0){
            System.out.println("c");
          r.der=rotationder(r.der);
          return rotationizq(r);
          
        }
        if(fe<-1 && Fe(r.der)>0){
            System.out.println("d");
          r.izq=rotationizq(r.izq);
          return rotationder(r);
        }
        return r;
    }
    @Override
    public void eliminar(NodoAVL eliminar) {
        super.eliminar(eliminar);
        root=balance(eliminar.value,root);
        if(eliminar.value>root.value){
            NodoAVL temp=root;
            while(temp.izq!=null){
                temp=temp.izq;
            }
            root=balance(temp.value,root);
        }
            
    }
    public void mostrar(){ 
        NodoAVL r = root;
        NodoAVL n = new NodoAVL(-1);
	Queue<NodoAVL> queue = new LinkedList();
        int cont=1, sal=2,niv=max(altura(r.izq),altura(r.der))+1;
        int basta=(int) Math.pow(niv, 2);
	if(r!=null){
            queue.add(r);
            while(cont!=basta){
                r = (NodoAVL)queue.poll();
                if(r.value!=-1)
                    System.out.print(" "+r.value+" ");
                else
                    System.out.print(" / ");
                cont++;
                if(cont==sal){
                    System.out.println("");
                    sal*=2;
                    niv=niv+1;
                }
		if(r.izq!=null)
                    queue.add(r.izq);
                else
                    queue.add(n);
		if(r.der!=null)
                    queue.add(r.der);
                else
                    queue.add(n);
            }
	}
    }
    
}
