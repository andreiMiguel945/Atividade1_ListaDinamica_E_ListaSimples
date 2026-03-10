public class Main {
    public static void main(String[] args) {
        ListaSimples listaSimples = new ListaSimples(5);

        listaSimples.adicionarElemento("Batata");
        listaSimples.adicionarElemento("Arroz");
        listaSimples.adicionarElemento("Pêssego");
        listaSimples.adicionarElemento("Batata");

        System.out.println(listaSimples.inserir(1,"Morango"));
        listaSimples.exibirElementos();
    }
}