import java.util.Arrays;

public class ListaSimples implements ListaOperacoes{
    String[] lista;

    public ListaSimples(int tamanho) {
        this.lista = new String[tamanho];
    }

    public void exibirElementos() {
        for (int i = 0; i < this.lista.length; i++) {
            System.out.println("Lista[" + i + "] = " + this.lista[i]);
        }
    }

    public void adicionarElemento(String elemento) {
        if (!estaCheia()) {
            this.lista[encontrarPosicaoVazia()] = elemento;
            System.out.println("Elemento " + elemento + " adicionado com sucesso!");
        }
    }


    private boolean estaCheia() {
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] == null) {
                return false;
            }
        }
        System.out.println("A lista está cheia!");
        return true;
    }

    private boolean estaVazio() {
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != null) {
                return false;
            }
        }
        System.out.println("A lista está vazia!");
        return true;
    }

    private int encontrarPosicaoVazia() {
        int i;
        for (i = 0; i < this.lista.length; i++) {
            if (this.lista[i] == null) {
                return i;
            }
        }
        return i;
    }

    public void removerElemento(String elemento) {
        if (!estaVazio()) {
            if (this.buscarElemento(elemento) >= 0) {
                this.lista[this.buscarElemento(elemento)] = null;
                System.out.println("Elemento " + elemento + " removido com sucesso!");
            }
        }
    }

    public int buscarElemento(String elemento){
        int i;
        if (!estaVazio()) {
            for (i = 0; i < this.lista.length; i++) {
                if (this.lista[i].equals(elemento)) {
                    return i;
                }
            }
        }
        System.out.println("Elemento não encontrado na lista.");
        return -1;
    }

    public void alterarElemento(String elementoASerAlterado, String alteracao) {
        if(buscarElemento(elementoASerAlterado) >= 0) {
            this.lista[buscarElemento(elementoASerAlterado)] = alteracao;
            System.out.println("Elemento " + elementoASerAlterado + " alterado com sucesso para " + alteracao);
        }
    }

    public void quantidadeElementos() {
        int cont = 0;
        if(!estaVazio()) {
            for (int i = 0; i < this.lista.length; i++) {
                if(this.lista[i] != null) {
                    cont++;
                }
            }
        }
        System.out.println("A lista possui " + cont + " elementos!");
    }
    @Override
    public int removerTodas(String elemento){
        int remocoes = 0;
        if(!estaVazio()) {
            for(int i = 0; i < this.lista.length; i++){
                if(this.lista[i].equals(elemento)){
                    this.lista[i] = null;
                    remocoes++;
                }
            }
        }else{
            System.out.println("Lista vazia!");
        }
        return remocoes;
    }

    @Override
    public int contar() {
          int contagem = 0;
        if(!estaVazio()){
              for(String valores : lista){
                  if(valores != null){
                      contagem++;
                  }
              }
          }

        return contagem;
    }

    @Override
    public int adicionarVarios(String[] elementos) {
        int adicionados = 0;
        if(estaCheia()) {
            System.out.println("Lista está cheia.");
            return 0;
        }
            for (String item : elementos) {
                if(estaCheia()){
                    System.out.println("Lista está cheia.");
                    return adicionados;
                }
                this.lista[encontrarPosicaoVazia()] = item;
                System.out.println("O elemento " + item + " Adicionado com sucesso!");
                adicionados++;
            }

        return adicionados;
    }

    @Override
    public String obter(int indice) {
        if(indice < 0 || indice >= this.lista.length){
            System.out.println("índice inválido.");
            return null;
        }
        return lista[indice];
    }

    @Override
    public boolean inserir(int indice, String elemento) {
        if (estaCheia() || indice < 0 || indice >= this.lista.length) {
            return false;
        }

        for (int i = this.lista.length - 1; i > indice; i--) {
            lista[i] = lista[i - 1];
        }

        lista[indice] = elemento;
        return true;
    }


    @Override
    public String removerPorIndice(int indice) {

            if (estaVazio() || indice < 0 || indice >= this.lista.length) {
                return null;
            }
            String elementoRemovido = this.lista[indice];

            for (int i = indice; i < this.lista.length-1; i++) {
                    this.lista[i] = this.lista[i + 1];
            }
            this.lista[this.lista.length - 1] = null;
            System.out.println("Elemento " + elementoRemovido + " removido do índice [" + (indice + 1) + "]");

            return elementoRemovido;
    }

    @Override
    public void limpar() {
        Arrays.fill(this.lista, null);
    }

    @Override
    public int ultimoIndiceDe(String elemento) {
        if(estaVazio()){
            return -1;
        }
        int ultimoIndice = -1;
        for(int i = 0; i < this.lista.length;i++){
            if(this.lista[i] != null && this.lista[i].equals(elemento)){
                ultimoIndice = i;
            }
        }

        return ultimoIndice;
    }

    @Override
    public int contarOcorrencias(String elemento) {
        int contagem = 0;
        for (String objeto : this.lista) {
            if ( objeto != null) {
                if (objeto.equalsIgnoreCase(elemento)) {
                    contagem++;
                }
            }
        }
        return contagem;
    }

    @Override
    public int substituir(String antigo, String novo) {
        int substituicoes = 0;
        if(!estaVazio()){
            for(int i = 0; i < this.lista.length;i++){
                if(this.lista[i] != null){
                    if(this.lista[i].equals(antigo)){
                        this.lista[i] = novo;
                        substituicoes++;
                    }
                }
            }
            return substituicoes;
        }
         return substituicoes;
    }
}