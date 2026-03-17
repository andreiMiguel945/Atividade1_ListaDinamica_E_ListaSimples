public class Main {
    public static void main(String[] args) {
        PilhaSimples pilhaSimples = new PilhaSimples(5);

        pilhaSimples.enfileirar(1);
        pilhaSimples.enfileirar(2);
        pilhaSimples.enfileirar(3);

        pilhaSimples.exibirPilha();
        pilhaSimples.desenfirelar();
        pilhaSimples.exibirPilha();

    }


}
