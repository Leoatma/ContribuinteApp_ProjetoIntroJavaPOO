import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class  ContribuinteApp {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        System.out.println("Olá bem vindo ao App do Contribuinte!\n");

        // Calculando Imposto
        double impostoTotal = 0.0;
        for (Contribuinte pessoa : lerDadosContribuintes()) {
            System.out.printf("\nPessoa nome: %s, Imposto = R$%.2f \n", pessoa.getName(), pessoa.calcularImposto());
            impostoTotal += pessoa.calcularImposto();
        }
        if (impostoTotal == 0) {
            System.out.println("Nenhum imposto registrado.");
        } else {
            System.out.printf("\nO imposto total dos contribuintes será de R$%.2f \n\n", impostoTotal);
        }

    }
    public static List<Contribuinte> lerDadosContribuintes () {

        Scanner scan = new Scanner(System.in);
        System.out.println("Antes de começar, favor informar o número de contribuintes: ");
        int qtdeContribuintes = scan.nextInt();

        List<Contribuinte> contribuintes = new ArrayList<>();


        if (qtdeContribuintes > 0) {
            System.out.println("_____________ENTRADA_____________");

            for (int idx = 0; idx < qtdeContribuintes; idx++) {
                System.out.printf("CONTRIBUINTE #%d \n", idx + 1);
                System.out.println("Pessoa Física ou Jurídica? \nF = Física / J = Jurídica");
                String tipoPessoa = scan.next().toUpperCase();
                scan.nextLine();

                System.out.println("Digite o nome da Pessoa: ");
                String nomePessoa = scan.nextLine();

                System.out.println("Informe a renda anual: ");
                double rendaPessoa = scan.nextDouble();

                if (tipoPessoa.equals("F")) {
                    System.out.println("Por favor, informe os gastos de Saúde: ");
                    double gastosSaude = scan.nextDouble();

                    contribuintes.add(new PessoaFisica(nomePessoa, rendaPessoa, gastosSaude));

                } else if (tipoPessoa.equals("J")) {
                    System.out.println("Favor informar o número de funcionários: ");
                    int nmFunci = scan.nextInt();

                    contribuintes.add(new PessoaJuridica(nomePessoa, rendaPessoa, nmFunci));
                } else {
                    System.out.printf("Tipo de Pessoa incorreto para contribuinte #%d", idx + 1);
                }
            }
        }
        scan.close();
        return contribuintes;
    }
}


    






