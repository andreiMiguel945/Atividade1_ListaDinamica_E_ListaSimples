public class FilaSimples {
    Integer [] fila;

    public FilaSimples(int tamanho) {
        this.fila = new Integer [tamanho];
    }

    public void enfileirar(int numero) {
        if(!estaCheia()){
            for(int i = 0; i < this.fila.length;i++){
                if(this.fila[i] == null){
                    this.fila[i] = numero;
                    System.out.println("O número " + numero + " inserido com sucesso.");
                    return;
                }
            }
        }
    }

    private boolean estaCheia(){
        if(this.fila[this.fila.length-1] != null){
            System.out.println("A fila está cheia.");
            return true;
        }else{
            return false;
        }
    }
    private boolean estaVazio(){
        if(this.fila[0] == null){
            return true;
        }else{
            System.out.println("A fila está vazia");
            return false;
        }
    }
    public void exbirFila(){
        for(int i = 0; i < this.fila.length;i++){
            System.out.println(this.fila[i]);
        }
    }

    public void desenfileirar(){
        if(!estaVazio()) if (!estaVazio()) {
            for (int i = 0; i < this.fila.length - 1; i++) {
                if (this.fila[i] != null) {
                    this.fila[i] = this.fila[i + 1];
                } else {
                    return;
                }
            }
            this.fila[this.fila.length - 1] = null;
        }
    }
}


