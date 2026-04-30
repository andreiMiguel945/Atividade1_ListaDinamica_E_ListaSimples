public class PilhaSimples {
    Integer [] pilha;

    public PilhaSimples(int tamanho){
        this.pilha = new Integer[tamanho];
    }

    private boolean estaCheia(){
        if(this.pilha[this.pilha.length - 1] != null){
            System.out.println("A pilha está cheia");
            return true;
        }
        return false;
    }
    private boolean estaVazia(){
        if(this.pilha[0] == null){
            System.out.println("A pilha está vazia");
           return true;
        }
        return false;
    }

    public void enfileirar(int numero){
        if(!estaCheia()){
            for(int i = 0; i < this.pilha.length;i++) {
               if(this.pilha[i] == null){
                   this.pilha[i] = numero;
                   System.out.println("O número " + numero + " Inserido com sucesso.");
                   break;
               }
            }
        }
    }
    public void exibirPilha(){
        if(estaVazia()){
            System.out.println("Lista vazia!");
            return;
        }
        for(int i = 0; i < this.pilha.length; i++){
            System.out.println("Pilha [" + i + "] -> " + this.pilha[i]);
        }
    }
    public void desenfirelar(){
        if(estaVazia()){
            System.out.println("Lista Vazia");
            return;
        }
        for(int i = this.pilha.length - 1;i >= 0 ;i--){
            if(this.pilha[i] != null){
                this.pilha[i] = null;
                break;
            }
        }
    }
}

