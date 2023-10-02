import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Produto {
    int codigoProduto;
    double precoProduto;
    Date dataFabricacao;
    String tipoProduto;
    Date validadeDoProduto;
    
    public Produto(int codigoProduto, float precoProduto, Date dataFabricacao, String tipoProduto, Date validadeDoProduto) {
        this.codigoProduto = codigoProduto;
        this.precoProduto = precoProduto;
        this.dataFabricacao = dataFabricacao;
        this.tipoProduto = tipoProduto;
        this.validadeDoProduto = validadeDoProduto;
    }

    public void cadastraProduto(){
        //
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o Código do produto: ");
        int cod = entrada.nextInt();
        System.out.println("");
        double preco = entrada.nextDouble();
        System.out.println("Data de fabricação: ");
        Date data = entrada.
        System.out.println("Digite o tipo do produto: ");
        String tipoProd = entrada.nextLine();
        System.out.println("");
        Date validade = entrada.nextLine();

    }

    
}
