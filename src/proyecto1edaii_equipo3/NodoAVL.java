package proyecto1edaii_equipo3;

/**
 *
 * @author Castillo Soto Jacqueline, Figueroa Ruiz Carolina, Isidro Castro Karen Cristina
 */
public class NodoAVL {
    int value;
    int nivel;
    NodoAVL izq = null;
    NodoAVL der = null;
    NodoAVL father = null;
    /**
     * Contructor que inicializa izquierda y derecha del nodo
     */    
    public NodoAVL(){
        izq=der=null;
    }
    /**
     * Constructor que inicializa el valor del nodo y la altura
     * @param data 
     */
    public NodoAVL(int data){
        this(data,1,null,null);
    }
    /**
     * Constructor que inicializa los atributos
     * @param data valor del nodo
     * @param alt altura del nodo
     * @param lt hijo izquierdo del nodo
     * @param rt hijo derecho del nodo
     */
    public NodoAVL(int data,int alt, NodoAVL lt, NodoAVL rt){
        value=data;
        nivel=alt;
        izq = lt;
        der = rt;
    }   
    /**
     * 
     * @param izq 
     */
    public void setIzq(NodoAVL izq) {
        this.izq = izq;
    }
    
    public void setDer(NodoAVL der) {
        this.der = der;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public NodoAVL getFather() {
        return father;
    }

    public void setFather(NodoAVL father) {
        this.father = father;
    }
    /**
     * Para obtener el nivel del nodo
     * @return regresa el nivel del nodo
     */
    public int getNivel() {
        return nivel;
    }
    /**
     * establece el nivel del nodo
     * @param nivel recibe el nivel del nodo 
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    
    /**
     * Muestra un nodo usando el toString 
     * @return una cadena de los atributos del nodo
     */
    @Override
    public String toString() {
        return "Nodo{" + "value=" + value + ", izq=" + izq + ", der=" + der + ", father=" + father + '}';
    }
}
