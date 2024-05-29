import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Adicionar nó");
            System.out.println("2 - Remover nó");
            System.out.println("3 - Mostrar organização da árvore");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.print("Digite o valor do nó a ser adicionado: ");
                    int valorAdicionar = scanner.nextInt();
                    arvore.adicionarNo(valorAdicionar);
                    break;
                case 2:
                    System.out.print("Digite o valor do nó a ser removido: ");
                    int valorRemover = scanner.nextInt();
                    arvore.removerNo(valorRemover);
                    break;
                case 3:
                    System.out.println("Organização da árvore:");
                    arvore.exibirArvore();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (escolha != 0);

        scanner.close();
    }
}
