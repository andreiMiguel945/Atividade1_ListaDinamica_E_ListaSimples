import java.util.Scanner;
public class ListaDinamica implements ListaOperacoesDinamica {

    No inicio;

    public ListaDinamica(No inicio) {
        this.inicio = inicio;
        System.out.println("Lista Dinâmica criada com sucesso!");
    }

    public void adicionarElemento(String conteudo) {
        if (!this.existeInicio()) {
            this.inicio.setConteudo(conteudo);
        } else {
            No novoNo = new No(conteudo);
            No aux = this.inicio;
            while (aux.getProx() != null) {
                aux = aux.getProx();
            }
            aux.setProx(novoNo);
        }
    }

    private boolean existeInicio() {

        if (this.inicio.getConteudo() == null) {
            return false;
        } else {
            return true;
        }
    }

    public void exibirElementos() {
        if (existeInicio()) {
            No aux = this.inicio;
            do {
                if (aux.getProx() == null) {
                    System.out.println(aux.getConteudo());
                    break;
                }
                System.out.println(aux.getConteudo());
                aux = aux.getProx();

            } while (true);


        } else {
            System.out.println("Não existem elementos na Lista Dinâmica!");
        }
    }

    public void removerElemento(String elemento) {
        if (existeInicio()) {
            if (buscarElemento(elemento)) {
                //removendo primeiro
                if (this.inicio.getConteudo().equals(elemento)) {
                    this.inicio.setConteudo(null);
                } else if (this.inicio.getProx() != null) {
                    No aux = this.inicio;
                    do {
                        if (aux.getProx().getConteudo().equals(elemento)) {
                            aux.setProx(aux.getProx().getProx());
                            return;
                        }
                        aux = aux.getProx();
                    } while (aux != null);
                } else {
                    this.inicio.setConteudo(null);
                }

                //removendo intermediário
                //método de busca
            }

        } else {
            System.out.println("Não existem elementos na lista.");
        }
    }

    public boolean buscarElemento(String elemento) {
        No aux = this.inicio;

        do {
            if (aux.getConteudo().equals(elemento)) {
                System.out.println("Elemento " + elemento + " encontrado.");
                return true;
            }
            aux = aux.getProx();
        } while (aux != null);
        System.out.println("Elemento " + elemento + " não encontrado!");
        return false;
    }

    public void trocarConteudo(String elemento) {
        Scanner sc = new Scanner(System.in);
        try {
            if (!this.existeInicio()) {
                System.out.println("Lista vazia!");
                return;
            }
            No aux = this.inicio;
            boolean alterado = false;
            sc.nextLine();
            System.out.print("Insira o elemento que deseja colocar no lugar de " + elemento + ": ");
            String novoElemento = sc.nextLine();

            while (aux != null) {
                if (aux.getConteudo().equals(elemento)) {
                    aux.setConteudo(novoElemento);
                    alterado = true;
                    break;
                }
                aux = aux.getProx();
            }
            if (alterado) {
                System.out.println("Alterado com sucesso!");
            } else {
                System.out.println("Valor não encontrado.");
            }

        } catch (Exception e) {
            System.out.println("Erro! Cancelando o auxilio!");
        }
    }

    @Override
    public int removerTodas(String elemento) {
        int contagem = 0;
        if(!existeInicio()){
            return 0;
        }
       if(buscarElemento(elemento)){
          //Removendo o primeiro
           if(this.inicio != null && this.inicio.getConteudo().equalsIgnoreCase(elemento)){
               this.inicio.setConteudo(null);
               contagem++;
           }
           No aux = this.inicio;

           while (aux != null && aux.getProx() != null){
               if(aux.getProx().getConteudo().equalsIgnoreCase(elemento)){
                   contagem++;
                   aux.setProx(aux.getProx().getProx());
               }else{
                   aux = aux.getProx();
               }
           }
           assert aux != null;
           if(aux.getConteudo().equalsIgnoreCase(elemento)){
               aux.setConteudo(null);
           }
       }
        return contagem;
    }

    @Override
    public int contar() {
        if (!this.existeInicio()) {
            System.out.println("Lista Vazia");
            return 0;
        }
        int contagem = 0;
        No aux = this.inicio;

        do {
            contagem++;
            if (aux.getProx() == null) {
                break;
            }
            aux = aux.getProx();
        } while (true);

        return contagem;
    }

    @Override
    public int adicionarVarios(String[] elementos) {
        int itensAdicionados = 0;

        for (String elemento : elementos) {
            itensAdicionados++;
            if (!existeInicio()) {
                this.inicio.setConteudo(elemento);
            } else {
                No novoNo = new No(elemento);
                No aux = this.inicio;
                while (aux.getProx() != null) {
                    aux = aux.getProx();
                }
                aux.setProx(novoNo);
            }
        }
        return itensAdicionados;
    }

    @Override
    public String obter(int indice) {
        if(!existeInicio()){
            return "Lista vazia!";
        }
        No aux = this.inicio;
        int i = 0;

        while(aux != null){
            if(i == indice){
                 return aux.getConteudo();
            }
            aux = aux.getProx();
            i++;
        }
        return "Índice não existe.";
    }

    @Override
    public boolean inserir(int indice, String elemento) {
        if(!existeInicio()){
            return false;
        }
        No novoNo = new No(elemento);
        if(indice == 0){
            novoNo.setProx(this.inicio);
            this.inicio = novoNo;
            return true;
        }
        No aux = this.inicio;
        int i = 0;

        while(aux != null && i < indice - 1){
            aux = aux.getProx();
            i++;
        }
        if(aux == null){
            return false;
        }
        novoNo.setProx(aux.getProx());
        aux.setProx(novoNo);
        return true;
    }

    @Override
    public String removerPorIndice(int indice) {
        if (!existeInicio()) {
          return "Lista vazia.";
        }
        String elementoRemovido;
        if(indice == 0){
            elementoRemovido = this.inicio.getConteudo();
            this.inicio.setConteudo(null);
            return elementoRemovido;
        }
        No aux = this.inicio;
        int i = 0;
        while(aux != null && i < indice - 1){
              aux = aux.getProx();
              i++;
        }
        if(aux == null){
            return "índice inválido";
        }
        elementoRemovido = aux.getProx().getConteudo();
        aux.setProx(aux.getProx().getProx());

        return elementoRemovido;
    }

    @Override
    public void limpar() {
        if (this.inicio == null) {
            return;
        }
        this.inicio.setConteudo(null);
        this.inicio.setProx(null);
    }

    @Override
    public int ultimoIndiceDe(String elemento) {
        if(!existeInicio() || !buscarElemento(elemento)){
            return -1;
        }
        int ultimoIndice = 0;
        int i = 0;
        No aux = this.inicio;
           while(aux != null) {
               if (aux.getConteudo().equals(elemento)) {
                   ultimoIndice = i;
               }
               aux = aux.getProx();
               i++;
           }
            return ultimoIndice;
    }

    @Override
    public int contarOcorrencias(String elemento) {
        int ocorrencias = 0;

        if(this.existeInicio()){
            No aux = this.inicio;
            while(aux != null){
                if(aux.getConteudo().equals(elemento)){
                    ocorrencias++;
                }
                aux = aux.getProx();
            }
        }
        return ocorrencias;
    }

    @Override
    public int substituir(String antigo, String novo) {
        int contagemSubstituicoes = 0;
            if (!this.existeInicio()) {
                System.out.println("Lista vazia!");
                return 0;
            }

            if(buscarElemento(antigo)) {
                No aux = this.inicio;

                while (aux != null) {
                    if (aux.getConteudo() != null && aux.getConteudo().equals(antigo)) {
                        contagemSubstituicoes++;
                        aux.setConteudo(novo);
                    }
                    aux = aux.getProx();
                }
                return contagemSubstituicoes;
            }
            System.out.println("Elemento não encontrado.");
            return 0;
    }
}

