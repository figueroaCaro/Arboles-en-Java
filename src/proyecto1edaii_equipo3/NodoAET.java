/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1edaii_equipo3;

/**
 * Clase que representá a un nodo especial para los arboles de expresión arirmetica
 * cuyo valor es un string
 * @author crist
 */

public class NodoAET {
    String value;
    NodoAET izq = null;
    NodoAET der = null;
    /**
     * Constructor que inicializa los nodos derecho e izquierdo del nodo con null
     */
    public NodoAET(){
        izq=der=null;
    }
    /**
     * Constructor que inicializa (asigna valor) el atrubuto value de un NodoAET, 
     * sin embargo mantendrá a los nodos derecho e izquierdo como null
     * @param data 
     */
    public NodoAET(String data){
        this(data,null,null);
    }
    /**
     * Constructor que asigna un valor al atributo value de un NodoAET,
     * además asigna un nodo a los atributos a los nodos derecho e izquierdo de un nodo AET
     * @param data representá el valor que tendrá cada nodo
     * @param lt representa al nodo izquierdo de un NodoAET
     * @param rt representa al nodo derecho de un NodoAET
     */
    public NodoAET(String data, NodoAET lt, NodoAET rt){
        value=data;
        izq = lt;
        der = rt;
    }
    /**
     * Obtinene y retorná el valor del atributo value de un NodoAET.
     * @return value, que es un string que representa el valor del atributo value.
     */
    public String getValue() {
        return value;
    }
    /**
     * Método que modifica el valor del atributo value de un NodoAET 
     * @param value 
     */
    public void setValue(String value) {
        this.value = value;
    }
}
