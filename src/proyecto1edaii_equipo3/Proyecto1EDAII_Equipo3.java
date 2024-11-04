
package proyecto1edaii_equipo3;

import java.util.Scanner;

/**
 *
 * @author carol
 */
public class Proyecto1EDAII_Equipo3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean out=false, out2;
        Scanner guardar = new Scanner (System.in);
        int opc, opc2;                        
        ArbolAVL arbolavl= new ArbolAVL();
        System.out.println("\tBIENVENIDO/A AL PROGRAMA PARA ARBOLES");
        while(!out){
            System.out.println("Elige la opcion con la que desea trabajar\n1)Arbol AVL\n2)Heaps\n3)Arbol de Expresion Aritmetica\n4)Salir");
            opc=guardar.nextInt();
            switch (opc) {
                case 1:
                    out2=false;
                    arbolavl.root=null;
                    System.out.println("Elegiste Arbol AVL");
                    while (!out2) {
                        System.out.println("Elige la opcion que desea:\n1)Crear Arbol AVL\n2)Agregar clave\n3)Buscar un valor\n4)Eliminar clave\n5)Mostrar arbol\n6)Salir");
                        opc2=guardar.nextInt();
                        switch (opc2) {
                            case 1:
                                int raiz;
                                if(arbolavl.root==null){                                    
                                    System.out.println("Escribe el valor de la raiz");
                                    raiz=guardar.nextInt();
                                    NodoAVL nr=new NodoAVL(raiz);
                                    arbolavl.root=nr;
                                }
                                else 
                                    System.out.println("El arbol ya fue creado");
                            break;
                            case 2:
                                int val;
                                if(arbolavl.root!=null){
                                    do{
                                        System.out.println("Escribe el valor del nodo");
                                        val=guardar.nextInt();
                                        if(arbolavl.buscar(val))
                                            System.out.println("Ese valor ya se encuentra en el arbol");
                                    }while(arbolavl.buscar(val));
                                    arbolavl.root=arbolavl.add(val,arbolavl.root);
                                    NodoAVL nodoa= arbolavl.buscarnodo(val);
                                    NodoAVL p=arbolavl.buscarp(val);
                                    nodoa.father=p;
                                    
                                }
                                else
                                   System.out.println("Aun no has creado el arbol");
                                
                            break;
                            case 3:
                                if(arbolavl.root!=null){
                                   System.out.println("Escribe el valor del nodo a buscar");
                                   int nod=guardar.nextInt();
                                   arbolavl.buscarn(nod,arbolavl.root);
                                }
                                else
                                   System.out.println("Aun no has creado el arbol");
                            break;
                            case 4:
                                if(arbolavl.root!=null){
                                   System.out.println("Escribe el valor del nodo a eliminar");
                                   int nod=guardar.nextInt();
                                   NodoAVL elim=arbolavl.buscarnodo(nod);
                                   arbolavl.eliminar(elim);
                                }
                                else
                                   System.out.println("Aun no has creado el arbol");
                            break;
                            case 5:
                                if(arbolavl.root!=null){
                                    arbolavl.mostrar();
                                    System.out.println("");
                                }
                                else
                                    System.out.println("Aun no has creado el arbol");
                            break;
                            case 6:
                                out2=true;
                            break;
                            default:
                                System.out.println("Opcion no valida");
                        }
                    }
                break;
                case 2:
                    Heap heap1=new Heap();
                    out2=false;
                    System.out.println("Elegiste Heap");
                    while (!out2) {
                        System.out.println("Elige la opcion que desea:\n1)Crear un heap\n2)Agregar clave\n3)Eliminar raiz\n4)Mostrar heap\n5)Salir");
                        opc2=guardar.nextInt();
                        switch (opc2) {
                            case 1:
                                if (heap1.root==null) {
                                    System.out.println("Ingrese el valor que desea para la raiz del heap: ");
                                    int raiz=guardar.nextInt();
                                    Nodo nr=new Nodo(raiz);
                                    heap1.root=nr;
                                }
                                else
                                    System.out.println("Ya hay un heap en existencia");
                            break;
                            case 2:
                                if (heap1.root!=null) {
                                    Nodo n;
                                    int nodos;
                                    System.out.println("Cuantos nodos desea agregar al heap? ");
                                    nodos=guardar.nextInt();
                                    for (int i = 0; i < nodos; i++) {
                                        System.out.println("Ingrese el valor del nodo "+(i+1)+": ");
                                        n=new Nodo(guardar.nextInt());
                                        heap1.addNodoH(n);
                                    }
                                    System.out.println("Sus nodos fueron agregados correctamente");
                                }
                                else
                                    System.out.println("Aun no ha sido creado un heap para trabajar");
                            break;
                            case 3:
                                if (heap1.root!=null) {
                                    System.out.println("Eliminando la raiz con valor de "+heap1.root.value+" ...");
                                    heap1.eliminarH();
                                    heap1.mostrarH();
                                }
                                else
                                    System.out.println("Aun no ha sido creado un heap para trabajar");
                            break;
                            case 4:
                                heap1.mostrarH();
                            break;
                            case 5:
                                out2=true;
                            break;
                            default:
                                System.out.println("Opcion no valida");
                        }
                    }
                break;
                case 3:
                    out2=false;
                    System.out.println("\nElegiste Arbol de expresion aritmetica");
                    System.out.println("Las operaciones permitidas por este árbol son\n 1) Suma (+)\t2) Resta (-)\t3)Multiplicacion(*)\t4)division(/)");
                    AETree arbol = new AETree();
                    while (!out2) {
                        System.out.println("\nElige la opcion que deses:\n 1)Ingresar expresion aritmetica\n 2)Mostrar arbol\n 3)Resolver\n 4)Salir");
                        opc2=guardar.nextInt();
                        switch (opc2) {
                            case 1 -> {
                                try {
                                    System.out.println("  Dar la expresión colocando parentesis al iniciar y finalizar cada operación ");
                                    System.out.println("  Ejemplos:\n (3+2)\t\t((3+2)/9)\t(((9+8)*5)-(3+2))");                                
                                    System.out.println("Ingresa la expresion");
                                    arbol.addExpression(guardar.next());
                                    System.out.println("Felicidades tu árbol fue creado: ");
                                    arbol.mostrar(arbol.root, 0);
                                } catch (Exception e) {
                                    System.out.println("Es posible que hayas omitido algun parentesis,por favor intentalo de nuevo");
                                }
                    }
                            case 2 -> {
                                if (arbol.root!=null) {
                                    System.out.println("El arbol en vista vertical es: ");
                                    arbol.mostrar(arbol.root,0);
                                    System.out.println("Fin del árbol");
                                }else{
                                    System.out.println("No existe un árbol para imprimir, porfavor ingresa uno");
                                }
                    }
                            case 3 -> {
                                if (arbol.root!=null) {
                                    System.out.println("El resultado de la operacón es:");
                                    System.out.println(arbol.resolver(arbol.root));
                                }else{
                                    System.out.println("No existe una expresion ha resolver, porfavor ingresa una");
                                }
                    }
                            case 4 -> out2=true;
                            default -> System.out.println("Opcion no valida");
                        }
                    }
                break;
                case 4:
                    out=true;
                break;
                default:
                    System.out.println("Opcion no valida");
            }
        }
    }
    
}
