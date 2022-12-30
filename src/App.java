import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import pasta1.Produto;

public class App {    
    private static Produto produto;
    private static boolean bool;
    private int i;
    private Scanner scanner;{   
        int opcao;        
        Scanner in = new Scanner(System.in);        
        ArrayList<Produto> produtos = new ArrayList<>();
      

        do {
            System.out.println("\n********\nMENU PRINCIPAL\n********\n");
            System.out.println("1 - Incluir produto");
            System.out.println("2 - Consultar Produtos");
            System.out.println("3 - Listagem de Produtos");
            System.out.println("4 - Vendas por período - Detalhado");
            System.out.println("5 - Realizar venda");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine();

            if (opcao == 1) {
                
                if (opcao == 1) {
                    Produto p = new Produto(in);
                    System.out.println("Digite o codigo do produto");
                    p.setCodigo(in.nextInt());
                    in.nextLine();
                    System.out.println("Nome do produto: ");
                    p.setNome(in.nextLine());
                    System.out.println("Quantidade em estoque: ");
                    p.setQuantidadeEstoque(in.nextInt());
                    in.nextLine();                    
                    System.out.println("Preço do produto: ");
                    in.nextLine();                   
                    produtos.add(p);
                    try {
                        voltarMenu(in);
                    } catch (InterruptedException | IOException e) {                       
                        e.printStackTrace();
                    }
                    continue;
                }
                
                try {
                    voltarMenu(in);
                } catch (InterruptedException | IOException e) {                   
                    e.printStackTrace();
                }


            } else if (opcao == 2) {
                
                if (produtos.size() == 0){
                    System.out.println("Não Existem Produtos Cadastrados.");
                    try {
                        voltarMenu(in);
                    } catch (InterruptedException | IOException e) {                        
                        e.printStackTrace();
                    }
                    continue;
                }

                System.out.println("Digite o codigo do produto ");
                int escolha = in.nextInt();
                in.nextLine();

                for (Produto produto : produtos) {
                    if(escolha == produto.getCodigo()){
                        System.out.println("\nProduto encontrado");
                        System.out.println("\n**************************************************");
                        System.out.println(produto);
                        try {
                            voltarMenu(in);
                        } catch (InterruptedException | IOException e) {                           
                            e.printStackTrace();
                        }
                        continue;
                    }
                }
               
                try {
                    voltarMenu(in);
                } catch (InterruptedException | IOException e) {                    
                    e.printStackTrace();
                }
            
            } else if (opcao == 3) {                

                if (produtos.size() == 0){
                    System.out.println("Não existem produtos a serem listados.");
                    try {
                        voltarMenu(in);
                    } catch (InterruptedException | IOException e) {                        
                        e.printStackTrace();
                    }
                    continue;
                }
                
                produtos.forEach(System.out::println);
               
                try {
                    voltarMenu(in);
                } catch (InterruptedException e) {                   
                    e.printStackTrace();
                } catch (IOException e) {                    
                    e.printStackTrace();
                }

            } else if (opcao == 4) {
                
            }
            else if (opcao == 5){               
               
                try{
                System.out.print("Cdo produto (ou um caractere nnumpara sair): ");
                i = paramScanner(i);
                }catch (Exception exception){        
                scanner.nextLine();
                produto = new Produto(in);                

            if  (produto == null) {
                System.out.print("\nProduto não encontrado.\nPressione ENTER para tentar novamente...");
                scanner.nextLine();
                bool = false;
            }    else {
                System.out.printf("\nProduto localizado: [%s]. Confirma (\"S\" ou ENTER confirma; outro caractere volta a busca)? ", new Object[] { produto.getNome() });
                String str1 = scanner.nextLine();

             if ("".equals(str1) || str1.equalsIgnoreCase("s")) {

             if (produto.getQuantidadeEstoque() == 0) {
            System.out.println("\nProduto com estoque zerado, a venda npode ser feita.\nPressione ENTER para reiniciar o processo...");
            scanner.nextLine();
            bool = false;
            } 
        }    else {
              bool = false;
             if (bool)
                break; 
        } 
             System.out.print("Data [dd/mm/aaaa] (ENTER para a data de hoje): ");
             String str2 = scanner.nextLine();
            if (!"".equals(str2))
            try {
          } catch (DateTimeParseException dateTimeParseException) {
            System.out.println("\nData inv\nPressione ENTER para reiniciar o processo...");
            scanner.nextLine();
            bool = false;
          }  
             System.out.print("Quantidade: ");
              i = scanner.nextInt();
             scanner.nextLine();
      
             if (produto.getQuantidadeEstoque() < i) {
          System.out.printf("\nProduto com estoque insuficiente (%d) para antender esta venda. Nposscontinuar.\nPressione ENTER para reiniciar o processo...", new Object[] { Integer.valueOf(produto.getQuantidadeEstoque()) });
          scanner.nextLine();
          bool = false;
        } 
      } 
               if (bool)
               break; 
    } 
           
}                     
                
            
          else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Programa Finalizado com sucesso! ");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();       
        
    }   

    private int paramScanner(int i2) {
        return 0;
    }
}