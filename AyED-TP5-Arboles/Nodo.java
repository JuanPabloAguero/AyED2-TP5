public class Nodo {
    
    protected int dato;
    protected Nodo izdo;
    protected Nodo dcho;

    public Nodo(int valor) {
        this.dato = valor;
        this.izdo = null;
        this.dcho = null;
    }

    public Nodo(Nodo ramaIzdo, int valor, Nodo ramaDcho) {
        this.dato = valor;
        this.izdo = ramaIzdo;
        this.dcho = ramaDcho;
    }

    // Imlplementar el método visitar()
    public void visitar() {
        System.out.print(dato + " ");
    }
}
