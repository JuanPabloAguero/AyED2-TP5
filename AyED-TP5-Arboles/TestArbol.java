public class TestArbol {
    public static void main(String[] args) {
        
        System.out.println("Arbol binario de busqueda de números enteros\n");
        ArbolBinario arbolBinario = new ArbolBinario();

        try {
            arbolBinario.insertar(10);
            arbolBinario.insertar(15);
            arbolBinario.insertar(7);
            arbolBinario.insertar(3);
            arbolBinario.insertar(9);
            arbolBinario.insertar(1);
            arbolBinario.buscar(15);
            arbolBinario.eliminar(15);
            System.out.println("\npre orden");
            ArbolBinario.preorden(arbolBinario.raizArbol());
            System.out.println("\nin orden");
            ArbolBinario.inorden(arbolBinario.raizArbol());
            System.out.println("\npost orden");
            ArbolBinario.postorden(arbolBinario.raizArbol());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
