
package proyecto1edaii_equipo3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author carol
 */
public class Heap {
    Nodo root;

    /**
     * Crea un constructor vacío para anicializar en null
     */
    public Heap() {
        root=null;
    }

    /**
     * Constructor crea el nodo raíz y le asigna un valor
     * @param val 
     */
    public Heap(int val) {
        root = new Nodo(val);
    }
    
    /**
     * Constructor que inicializa (asigna) la raíz del heap
     * @param root 
     */
    public Heap(Nodo root){
        this.root=root;
    }
    
    /**
     * Método que va a recibir un nodo y lo va a agregar al heap en la primera posición libre
     * que encuentre (de izquierda a derecha), y además va a verificar (e intercambiar si es
     * necesario) que se cumpla el MAX-HEAP.
     * @param agregar recibe un nodo llamado "agregar" que corresponde al nuevo que vamos a colocar
     */
    public void addNodoH(Nodo agregar){
        int aux;
        Nodo r = root;
        Queue<Nodo> queue = new LinkedList();
        queue.add(r);
        while(!queue.isEmpty()){
            r = (Nodo)queue.poll();
            if(r.izq==null){
                r.izq=agregar;
                agregar.father=r;
                break;
            }
            else
                queue.add(r.izq);
            if(r.der==null){
                r.der=agregar;
                agregar.father=r;
                break;
            }
            else
                queue.add(r.der);
        }
        while (agregar.father!=null && agregar.value>agregar.father.value) { //puede haber valores repetidos?
            aux=agregar.value;
            agregar.value=agregar.father.value;
            agregar.father.value=aux;
            agregar=agregar.father;
        }
    }
    
    /**
     * Método que no recibe ni retona nada, pero se va a encargar de la operación para eliminar
     * la raíz del heap, primero encontrando al último nodo en el arbol, intercambiando su valor
     * con el de la raíz, eliminando este último nodo (y sus conexiones) e invocando otro método.
     */
    public void eliminarH(){
        Nodo r = root;
        Queue<Nodo> queue = new LinkedList();
        queue.add(r);
        while(!queue.isEmpty()){
            r = (Nodo)queue.poll();
            if(r.izq!=null)
                queue.add(r.izq);
            if(r.der!=null)
                queue.add(r.der);
        }
        //System.out.println(r.value);     para comprobar que al finalizar el while, r es el ultimo nodo
        if(r==root){
            root=null;
            System.out.println("La raiz era el unico nodo, al eliminarse se elimino el heap tambien");
        }
        else{
            System.out.println("La raiz se intercambia con el ultimo nodo del heap que es "+r.value);
            root.value=r.value;
            if(r.father.izq.value==r.value)          //Eliminando la conexión con su padre
                r.father.izq=null;                
            else
                r.father.der=null;
            eliminarRecursiv(root);
        }
    }
    
    /**
     * Método recursivo que se invoca en "eliminarH()" y lo que hace es verificar desde la raíz
     * que se cumpla el MAX-HEAP, de no ser así, intercambia con su hijo de mayor valor y realiza más
     * llamadas recursivas hacia abajo hasta no tener más nodos.
     * @param r Recibe el nodo "raíz" que va a verificar
     */
    private void eliminarRecursiv(Nodo r){
        int aux;
        if(r.izq!=null){     //se evalua si existe un izq porque no hay derecho sin izq
            if(r.der!=null && r.value<r.der.value){     //si hay un derecho y es mayor a la raiz, debemos evaluarlo, sino no
                if(r.der.value>=r.izq.value){           //comparamos cual hijo es el mayor para intercambiar
                    aux=r.der.value;
                    r.der.value=r.value;
                    r.value=aux;
                    eliminarRecursiv(r.der);
                }
                else{
                    aux=r.izq.value;
                    r.izq.value=r.value;
                    r.value=aux;
                    eliminarRecursiv(r.izq);
                }
            }
            else{
                if(r.value<r.izq.value){  //si no hay derecho (o es menor a la raiz) comparamos directamente a izq para intercambiar o no
                    aux=r.izq.value;
                    r.izq.value=r.value;
                    r.value=aux;
                    eliminarRecursiv(r.izq);
                }
            }
        }
    }
    
    /**
     * Método para mostrar al heap por niveles, primero lo recorre, metiendo todos los valores de
     * los nodos (en orden) a un arreglo, y después los va mostrando en pantalla.
     */
    public void mostrarH(){
        Nodo r = root;
        if(r!=null){
            Queue<Nodo> queue = new LinkedList();
            queue.add(r);
            ArrayList<Integer> lista = new ArrayList();
            System.out.println("Heap (Por niveles, de izq->der):");
            while(!queue.isEmpty()){
                r = (Nodo)queue.poll();
                lista.add(r.value);
                if(r.izq!=null)
                    queue.add(r.izq);
                if(r.der!=null)
                    queue.add(r.der);
            }
            System.out.println("\t  "+lista.get(0));
            int i=1, a=2;
            boolean s=false;
            while(!s){
                if(i<lista.size()){
                    System.out.print("\t  "+lista.get(i));
                    if(i==a){
                        System.out.print("\n");
                        a=(a*2)+2;
                    }
                    i++;
                }
                else
                    s=true;
            }
            System.out.println("\n");
        }
        else
            System.out.println("No existe un heap para mostrar");
    }
  }

