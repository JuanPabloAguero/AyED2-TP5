public class ArbolBinario {
    
    protected Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public ArbolBinario(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo raizArbol() {
        return raiz;
    }

    // Implementar el método esVacio()
    boolean esVacio() {
        return raiz == null;
    }

    public static Nodo nuevoArbol(Nodo ramaIzqda, int dato, Nodo ramaDrcha) {
        return new Nodo(ramaIzqda, dato, ramaDrcha);
    }

    // Método recursivo para insertar un valor en el árbol
    private Nodo insertarRecursivo(Nodo nodo, int valor) throws Exception {
        if (nodo == null) {
            return new Nodo(valor);
        }
        if (valor < nodo.dato) {
            nodo.izdo = insertarRecursivo(nodo.izdo, valor);
        } else if (valor > nodo.dato) {
            nodo.dcho = insertarRecursivo(nodo.dcho, valor);
        } else {
            throw new Exception("El valor " + valor + " ya existe en el árbol.");
        }
        return nodo;
    }

    // Método para insertar un valor en el árbol, manejando excepciones
    public void insertar(int valor) throws Exception {
        try {
            raiz = insertarRecursivo(raiz, valor);
        } catch (Exception e) {
            throw new Exception("Error al insertar el valor: " + valor, e);
        }
    }

    // Recorrido de un árbol binario en preorden
    public static void preorden(Nodo nodo) {
        if (nodo != null) {
            nodo.visitar();
            preorden(nodo.izdo);
            preorden(nodo.dcho);
        }
    }
    
    // Recorrido de un árbol binario en inorden
    public static void inorden(Nodo nodo) {
        if (nodo != null) {
            inorden(nodo.izdo);
            nodo.visitar();
            inorden(nodo.dcho);
        }
    }

    // Recorrido de un árbol binario en postorden
    public static void postorden(Nodo nodo) {
        if (nodo != null) {
            postorden(nodo.izdo);
            postorden(nodo.dcho);
            nodo.visitar();
        }
    }

    // Método recursivo para buscar un valor en el árbol
    private Nodo buscarRecursivo(Nodo nodo, int valor) {
        if (nodo == null || nodo.dato == valor) {
            return nodo;
        }
        if (valor < nodo.dato) {
            return buscarRecursivo(nodo.izdo, valor);
        } else {
            return buscarRecursivo(nodo.dcho, valor);
        }
    }

    // Método para buscar un valor en el árbol
    public Nodo buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    // Método para encontrar el nodo con el valor mínimo en un subárbol
    private Nodo encontrarMinimo(Nodo nodo) {
        while (nodo.izdo != null) {
            nodo = nodo.izdo;
        }
        return nodo;
    }

    // Método recursivo para eliminar un valor del árbol
    private Nodo eliminarRecursivo(Nodo nodo, int valor) throws Exception {
        if (nodo == null) {
            throw new Exception("El valor " + valor + " no se encuentra en el árbol.");
        }
        if (valor < nodo.dato) {
            nodo.izdo = eliminarRecursivo(nodo.izdo, valor);
        } else if (valor > nodo.dato) {
            nodo.dcho = eliminarRecursivo(nodo.dcho, valor);
        } else {
            // Nodo con un solo hijo o sin hijos
            if (nodo.izdo == null) {
                return nodo.dcho;
            } else if (nodo.dcho == null) {
                return nodo.izdo;
            }
            // Nodo con dos hijos: obtener el sucesor inorden
            Nodo sucesor = encontrarMinimo(nodo.dcho);
            nodo.dato = sucesor.dato;
            nodo.dcho = eliminarRecursivo(nodo.dcho, sucesor.dato);
        }
        return nodo;
    }

    // Método para eliminar un valor del árbol, manejando excepciones
    public void eliminar(int valor) throws Exception {
        try {
            raiz = eliminarRecursivo(raiz, valor);
        } catch (Exception e) {
            throw new Exception("Error al eliminar el valor: " + valor, e);
        }
    }
}
