public class Main {
    public static void main(String[] args) {
        PilhaDinamica pilhaDinamica = new PilhaDinamica();
        pilhaDinamica.enfileirar(1);
        pilhaDinamica.enfileirar(2);
        pilhaDinamica.enfileirar(3);
        pilhaDinamica.exibirPilha();
        pilhaDinamica.desenfirelar();
        pilhaDinamica.exibirPilha();
    }
}
