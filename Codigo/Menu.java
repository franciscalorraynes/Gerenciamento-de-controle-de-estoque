package Codigo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class Menu {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean sair = false;
        int opAnterior = 0; // inicia em zero porque inicialmente não possui opção anterior
        List<Produtos> listaProdutos = new ArrayList<>(); // Lista para armazenar produtos

        while (!sair) {
            // opções do menu principal
            System.out.println("--------------------");
            System.out.println("Menu Principal\n");
            System.out.println("1. Cadastro de Produtos");
            System.out.println("2. Lista de Produtos");
            System.out.println("3. Excluir Produtos");
            System.out.println("4. Buscar Produtos");
            System.out.println("5. Voltar");
            System.out.println("6. Sair");

            if (opAnterior > 0) {
                System.out.println("8. Voltar à tela anterior");
            }

            System.out.println("--------------------");
            System.out.println("Digite uma opção: ");
            int opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                while (true) {
                    System.out.println("--------------------\n");
                    Produtos produto = new Produtos();
                    produto.cadastraProduto(entrada);
                    listaProdutos.add(produto);
                    System.out.println("Produto cadastrado com sucesso!\n");
                    System.out.println("Deseja cadastrar outro produto? (S/N)");
                    String resposta = entrada.next().trim().toUpperCase();
                    if (!resposta.equals("S")) {
                        break;
                        }
                }
                    opAnterior = opcao;
                    break;
                case 2:
                    List<Produtos> produtosDoArquivo = Produtos.lerListaProdutosDeTxt("dados_produto.txt");
                    Produtos.imprimeListaProdutos(produtosDoArquivo);
                    opAnterior = opcao;
                    break;
                case 3:
                    System.out.println("Excluir Produtos");
                    // Implemente a funcionalidade de busca aqui, se necessário
                    break;
                case 4:
                    System.out.println("Buscar Produtos");
                    // Implemente a funcionalidade de voltar aqui, se necessário
                    break;
                case 5:
                    if (opAnterior == 0) {
                        System.out.println("Nenhuma opção anterior para voltar.");
                    } else {
                        // volta para a tela de menu inicial
                        System.out.println("Voltando à tela anterior.");
                        int temp = opcao;
                        opcao = opAnterior;
                        opAnterior = temp;
                    }
                    break;
                    case 6:
                    System.out.println("Saindo do programa.");
                    sair = true;
                    break;
                default:
                    // mensagem de erro caso a op seja inválida
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
        entrada.close();
    }
}
