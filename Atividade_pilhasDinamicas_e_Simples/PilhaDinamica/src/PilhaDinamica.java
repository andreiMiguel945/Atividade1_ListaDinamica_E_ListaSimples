public class PilhaDinamica {
    NoInteiro inicio;

    public PilhaDinamica() {
        this.inicio = new NoInteiro(null);
    }

    private boolean estaVazio(){
        if(this.inicio.getConteudo() == null) {
            System.out.println("A Fila está vazia.");
            return true;
        } else {
            return false;
        }
    }

    public void exibirPilha(){
        if(!estaVazio()) {
            NoInteiro aux = this.inicio;
            while(aux != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getProx();
            }
        }
    }
    public void enfileirar(int numero){
        if(estaVazio()){
            System.out.println("Número " + numero + " adicionado a Fila.");
            this.inicio.setConteudo(numero);
        }else{
            NoInteiro novoNo = new NoInteiro(numero);
            NoInteiro aux = this.inicio;

            while(aux != null){
                if(aux.getProx() == null){
                    System.out.println("Número " + numero + " adicionado na lista.");
                    aux.setProx(novoNo);
                    return;
                }
                aux = aux.getProx();
            }
        }
    }

    public void desenfirelar(){
        NoInteiro aux = this.inicio;
        if(!estaVazio()){
            if(this.inicio.getProx() == null) {
                this.inicio.setConteudo(null);
            } else {
               do{
                   if(aux.getProx().getProx() == null){
                       aux.setProx(aux.getProx().getProx());
                       return;
                   }
                   aux = aux.getProx();
               }while(aux != null);
            }
        }
    }

}
