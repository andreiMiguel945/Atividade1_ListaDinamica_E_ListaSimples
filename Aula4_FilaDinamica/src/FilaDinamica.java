public class FilaDinamica {
    NoInteiro inicio;

    public  FilaDinamica(){
        this.inicio = new NoInteiro(null);
    }

    public void enfileirar(int numero){
        if(estaVazio()){
            this.inicio.setConteudo(numero);
        }else{
            NoInteiro novoNo = new NoInteiro((numero));
            NoInteiro aux = this.inicio;
            while(aux != null){
                aux = aux.getProx();
                if(aux.getProx() == null){
                    aux.setProx(novoNo);
                    return;
                }
                aux.getProx();
            }
        }
    }

    public void exibir(){
        if(!estaVazio()){
            NoInteiro aux;
            while(aux != null){
                this.getConteudo();
                aux = aux.getProx();
            }
        }
    }

    private boolean estaVazio(){
        if(this.inicio.getConteudo() == null){
            System.out.println("A fila está vazia.");
            return true;
        }else{
            return false;
        }
    }

    public void desenfileirar(){
        if(!estaVazio()){
             if(this.inicio.getProx() == null){
                 this.inicio.setConteudo(null);
             }else{
                 this.inicio = this.inicio.getProx();
             }
        }
    }
}
