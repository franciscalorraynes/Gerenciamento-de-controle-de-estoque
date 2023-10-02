package Codigo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Produtos {
    String nomeProduto;
    String dataDoCadastro;
    int codigoProduto;
    double precoProduto;
    String dataFabricacao;
    String tipoProduto;
    String validadeDoProduto;

    public Produtos() {
        // Este é um construtor padrão vazio
    }
    
    public Produtos(int codigoProduto, double precoProduto, String dataFabricacao, String tipoProduto, String validadeDoProduto, String dataDoCadastro) {
        this.codigoProduto = codigoProduto;
        this.precoProduto = precoProduto;
        this.dataFabricacao = dataFabricacao;
        this.tipoProduto = tipoProduto;
        this.validadeDoProduto = validadeDoProduto;
        this.dataDoCadastro = dataDoCadastro;
    }
    

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDataDoCadastro() {
        return dataDoCadastro;
    }

    public void setDataDoCadastro(String dataDoCadastro) {
        this.dataDoCadastro = dataDoCadastro;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public String getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(String dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public String getValidadeDoProduto() {
        return validadeDoProduto;
    }

    public void setValidadeDoProduto(String validadeDoProduto) {
        this.validadeDoProduto = validadeDoProduto;
    }

    public void cadastraProduto(Scanner entrada) {
        System.out.println("Digite a data de Cadastro deste Produto:");
        dataDoCadastro = entrada.next();

        System.out.println("Digite o Código do produto: ");
        codigoProduto = entrada.nextInt();

        System.out.println("Digite o nome do Produto: ");
        nomeProduto = entrada.next();

        entrada.nextLine(); // Consumir a quebra de linha pendente

        System.out.println("Digite o preço do Produto: ");
        precoProduto = entrada.nextDouble();

        entrada.nextLine(); // Consumir a quebra de linha pendente

        System.out.println("Data de fabricação (dd/MM/yyyy): ");
        dataFabricacao = entrada.nextLine();

        System.out.println("Digite o tipo do produto: ");
        tipoProduto = entrada.nextLine();

        System.out.println("Digite a validade do produto (dd/MM/yyyy): ");
        validadeDoProduto = entrada.nextLine();

        salvarDadosEmTxt();
    }

     private void salvarDadosEmTxt() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dados_produto.txt", true))) {

            writer.write("Data do cadastro: " + dataDoCadastro + "\n");
            writer.write("Código do produto: " + codigoProduto + "\n");
            writer.write("Nome do Produto: " + nomeProduto + "\n");
            writer.write("Preço do produto: " + precoProduto + "\n");
            writer.write("Data de fabricação: " + dataFabricacao + "\n");
            writer.write("Tipo do produto: " + tipoProduto + "\n");
            writer.write("Data de validade: " + validadeDoProduto + "\n");
            writer.write("------------------------------\n");

            System.out.println("Dados do produto salvos em 'dados_produto.txt'.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados do produto em um arquivo.");
        }
    }
    public static void imprimeListaProdutos(List<Produtos> listaProduto) {
        System.out.println("Imprimindo a Lista de Produtos do Estoque");
    
        for (int i = 0; i < listaProduto.size(); i++) {
            Produtos produto = listaProduto.get(i); // Correção aqui
            System.out.println("Produto " + (i + 1));
            System.out.println("Data do cadastro: " + produto.getDataDoCadastro());
            System.out.println("Código do produto: " + produto.getCodigoProduto());
            System.out.println("Nome do Produto: " + produto.getNomeProduto());
            System.out.println("Preço do produto: " + produto.getPrecoProduto());
            System.out.println("Data de fabricação: " + produto.getDataFabricacao());
            System.out.println("Tipo do produto: " + produto.getTipoProduto());
            System.out.println("Data de validade: " + produto.getValidadeDoProduto());
            System.out.println();
        }
    }
    
public static List<Produtos> lerListaProdutosDeTxt(String nomeArquivo) {
    List<Produtos> listaProdutos = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
        String linha;
        Produtos produto = null;

        while ((linha = reader.readLine()) != null) {
            if (linha.startsWith("Data do cadastro: ")) {
                if (produto != null) {
                    listaProdutos.add(produto);
                }
                produto = new Produtos(); // Correção aqui
                produto.setDataDoCadastro(linha.substring("Data do cadastro: ".length()).trim());
            } else if (linha.startsWith("Código do produto: ")) {
                produto.setCodigoProduto(Integer.parseInt(linha.substring("Código do produto: ".length()).trim()));
            } else if (linha.startsWith("Nome do Produto: ")) {
                produto.setNomeProduto(linha.substring("Nome do Produto: ".length()).trim());
            } else if (linha.startsWith("Preço do produto: ")) {
                produto.setPrecoProduto(Double.parseDouble(linha.substring("Preço do produto: ".length()).trim()));
            } else if (linha.startsWith("Data de fabricação: ")) {
                produto.setDataFabricacao(linha.substring("Data de fabricação: ".length()).trim());
            } else if (linha.startsWith("Tipo do produto: ")) {
                produto.setTipoProduto(linha.substring("Tipo do produto: ".length()).trim());
            } else if (linha.startsWith("Data de validade: ")) {
                produto.setValidadeDoProduto(linha.substring("Data de validade: ".length()).trim());
            }
        }

        if (produto != null) {
            listaProdutos.add(produto);
        }
    } catch (IOException e) {
        System.err.println("Erro ao ler o arquivo de produtos: " + e.getMessage());
    }

    return listaProdutos;
}



}
