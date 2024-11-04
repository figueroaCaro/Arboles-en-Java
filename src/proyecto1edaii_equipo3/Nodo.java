package proyecto1edaii_equipo3;

/**
 *
 * @author carol
 */
public class Nodo {
    int value;
    Nodo izq = null;
    Nodo der = null;
    Nodo father = null;
    
    /**
     * Constructor vacío para inicializar las autoreferencias en null
     */
    public Nodo(){
        izq=der=father=null;
    }

    /**
     * Constructor que le asigna el valor enviado, a un nodo
     * @param value 
     */
    public Nodo(int value) {
        this.value = value;
    }
    
    /**
     * Asigna un nodo como el hijo izquierdo de otro
     * @param izq es el nodo que se recibe para asignar
     */
    public void setIzq(Nodo izq) {
        this.izq = izq;
    }
    
    /**
     * Para obtener el nodo "hijo" izquierdo de otro
     * @return el nodo correspondiente 
     */
    public Nodo getIzq() {
        return izq;
    }
    
    public void setDer(Nodo der) {
        this.der = der;
    }

    public Nodo getDer() {
        return der;
    }

    /**
     * Para obtener el valor de un nodo
     * @return el entero correspondiente a su valor
     */
    public int getValue() {
        return value;
    }

    /**
     * Asigna el valor enviado a su atributo correspondiente de un nodo
     * @param value recibe el valor entero que se debe asignar al nodo
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Para obtener el nodo padre de otro
     * @return el nodo guardado en su atributo correspondiente
     */
    public Nodo getFather() {
        return father;
    }

    /**
     * Asigna un nodo como el atributi "padre" de otro
     * @param father recibe al nodo que se va a asignar
     */
    public void setFather(Nodo father) {
        this.father = father;
    }

    /**
     * Permite mostrar un nodo completo directamente
     * @return una cadena con todos los atributos del nodo
     */
    @Override
    public String toString() {
        return "Nodo{" + "value=" + value + ", izq=" + izq + ", der=" + der + ", father=" + father + '}';
    }
}
