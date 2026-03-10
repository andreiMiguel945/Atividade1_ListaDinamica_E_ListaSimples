
import java.util.Scanner;
public class MainListaDinamica {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int op;
        do {
            try {
                System.out.println("1- Criar a lista dinâmica");
                System.out.println("2-Sair");
                op = sc.nextInt();
                if (op == 1) {
                    ProgramaDaLista();
                    break;
                } else if (op == 2) {
                    break;
                } else {
                    System.out.println("Opção inválida! Insira novamente.");
                }
            }catch(Exception e){
                System.out.println(e + " -> Insira um valor inteiro");
                sc.nextLine();
            }
        } while (true);
        System.out.println("Finalizando o programa!");
        sc.close();
    }

        //Acessando o programa após criar a lista
        public static void ProgramaDaLista () {
            ListaDinamica listaDinamica = new ListaDinamica(new No(null));
            int opMenu;
            String produto;
            do{
                try{
                    System.out.println("-----MENU-----");
                    System.out.println("1- adicionar produto");
                    System.out.println("2- Remover um produto da lista");
                    System.out.println("3- Exibir a lista");
                    System.out.println("4-Trocar um conteúdo");
                    System.out.println("5- Sair e exibir a lista final");
                    opMenu = sc.nextInt();
                    if(opMenu == 1){
                        sc.nextLine();
                        System.out.print("Insira o nome do produto: ");
                        produto = sc.nextLine();

                        listaDinamica.adicionarElemento(produto);
                        System.out.println("/----------------------/");

                    }else if(opMenu == 2){
                        sc.nextLine();
                        System.out.print("Insira o nome do produto que deseja remover: ");
                        produto = sc.nextLine();

                        listaDinamica.removerElemento(produto);
                        System.out.println("/----------------------");

                    }else if(opMenu == 3){
                        System.out.println("\n---Exibindo a lista---");
                        listaDinamica.exibirElementos();
                        System.out.println("/---------------------/");

                    }else if(opMenu == 4){
                        sc.nextLine();
                        System.out.print("Insira o nome do produto que deseja trocar: ");
                        produto = sc.nextLine();

                        listaDinamica.trocarConteudo(produto);
                        System.out.println("/---------------------/");

                    }else if(opMenu == 5){

                        System.out.println("\n---Exibindo a lista final---");
                        listaDinamica.exibirElementos();
                        System.out.println("/---------------------------------/");
                        break;
                    }else{
                        System.out.println("Opção inválida! Insira novamente");
                        System.out.println(listaDinamica.substituir("a","x"));
                    }

                }catch(Exception e){
                    System.out.println(e + " -> Insira um valor inteiro");
                    sc.nextLine();
                }
            }while(true);
        }
}

