public class MainFilaSimples {
    public static void main(String[] args) {
        FilaSimples filaSimples = new FilaSimples(10);
        filaSimples.enfileirar(20);
        filaSimples.enfileirar(30);
        filaSimples.enfileirar(40);
        filaSimples.enfileirar(50);


        filaSimples.desenfileirar();
        filaSimples.exbirFila();


    }
}
