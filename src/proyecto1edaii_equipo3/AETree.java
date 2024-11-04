package proyecto1edaii_equipo3;

import static java.lang.Double.parseDouble;
import java.util.LinkedList;
import java.util.Stack;

/**
 *  Clase que representa a un arbol de Expresión aritmetica
 * @author crist
 */
public class AETree {
    public NodoAET root;
    private final char [] operadores={'+','-','/','*'};
    private final Stack <Double> numeros = new Stack<>();
    /**
     * Crea un constructor vacío
     */
    public AETree() {
        
    }
   /**
     * Método que agregará una nueva expresión, construirá un árbol a apartir de
     * una expresión aritmetica en formato de cadena.
     * @param expresion representá a la expresión aritmetica que se desea construir.
     */
    public void addExpression(String expresion){
        LinkedList<String> exp=toArray(expresion.toCharArray());
        Stack <NodoAET> operandos = new Stack<>();
        Stack <String> operador = new Stack<>();
        for (int i = 0; i < exp.size(); i++) {
            if(")".equals(exp.get(i))) {
                operandos.push(new NodoAET(operador.pop(),operandos.pop(),operandos.pop()));
            }else{
                if (searchOp(exp.get(i))==true){
                    operador.push(exp.get(i));
                }else{
                    if (!"(".equals(exp.get(i))) {
                        operandos.push(new NodoAET(exp.get(i)));
                       // elementos+=1;
                    }
                }
            }   
        }
        root=operandos.pop();    
    }
    /**
     * Método recursivo que resolverá la expresión aritmetica representada con el árbol
     * y retornara dicho resultado, si bien el método solo toma enteros para cada operación 
     * el resultado es de tipo double.
     * Nota: Este método hace uso del método searchC para diferenciar los cracateres aceptado como operadores
     * del árbol del resto de elemntos.
     * @param r representá la raiz de cada árbol recursivo, dicho nodo es de tipo NodoAET.
     * @return devuelve un double que representa el resultado de la expresiión en el árbol.
     */
    public double resolver(NodoAET r){ 
        Double operacion ;
        if(r.izq!=null)
            numeros.add(resolver(r.izq));
        if(r.der!=null)
            numeros.add(resolver(r.der));
        if (searchOp(r.value)){ 
            Double aux1 = numeros.pop();
            Double aux2=numeros.pop();
            switch (r.value) {
                case "+" -> {
                    operacion=aux1 + aux2;
                    numeros.push(operacion);
                }
                case "-" -> {                  
                    operacion=aux1-aux2;
                    numeros.push(operacion);
                }
                case "/" -> {
                    operacion = aux1/aux2;
                    numeros.push(operacion);
                }
                case "*" -> {    
                    operacion = aux1*aux2;
                    numeros.push(operacion);
                }
                default -> throw new AssertionError();
            
            }
            
        }else{
            numeros.add(parseDouble(r.value));
        }  
        return numeros.pop();
    }
    
    /**
     * Método para mostrar un árbol,es una variación del forma para recorreer un árbol "In orden" 
     * recibe como parametro el nodo raiz de cada subarbol y la profundidad de cada nodo
     * @param raiz representa a la raiz de cada subarbol creado al momento de dividir con recursividad el árbol
     * @param profundidad representa cuantos nodos se tuvieron que recorrer para llegar al nodo que queremos imprimir 
     */
    public void mostrar(NodoAET raiz, int profundidad){
        NodoAET r=raiz;
        if (r.izq !=null) {
            mostrar(r.izq, profundidad+1);
        }
        for(int i=0; i<profundidad; i++){
            System.out.printf("   ");
        }
        System.out.println(r.getValue());
        if(r.der !=null){
            mostrar(r.der, profundidad+1);
        }
    }
    /**
     * Métdodo de tipó boolean para saber si un carácter se encuentra dentro de los operadores aceptados por el árbol 
     * devolverá true si efectivamente se encieuntra o false en caso contario
     * @param c representa al caracter
     * @return 
     */
    private boolean searchOp(String c) {
        for (char caracter : this.operadores) {
            if (String.valueOf(caracter).equals(c)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Método con el cuál se convertira una expresión arirmetica de String a una Lista ligada de String,
     * separá los operadores, de los numeros y los simbolos de agrupación, devolverá una lista con 
     * los elemntos separados
     * @param charArray
     * @return 
     */
    private LinkedList toArray(char[] charArray) {
        LinkedList<String> expresion=new LinkedList();
        String aux;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i]=='(' || charArray[i]==')' || searchOp(String.valueOf(charArray[i]))) {
                expresion.add(String.valueOf(charArray[i]));
            }else{
                aux=String.valueOf(charArray[i]);
                i++;
                while (charArray[i]=='0'|| charArray[i]=='1' || charArray[i]=='2' || charArray[i]=='3' || charArray[i]=='4' || charArray[i]=='5'|| charArray[i]=='6' || charArray[i]=='7'|| charArray[i]=='8'|| charArray[i]=='9'|| charArray[i]=='.'){
                    aux+=charArray[i];
                    i++;
                }
                i--;
                expresion.add(aux);
            }
        }
        return expresion;
    }
}
