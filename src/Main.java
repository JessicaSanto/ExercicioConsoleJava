import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        PessoaFisica metodosPf = new PessoaFisica();
        PessoaJuridica metodosPj = new PessoaJuridica();

        ArrayList<PessoaFisica> listaPf = new ArrayList<>();
        ArrayList<PessoaJuridica> listaPj = new ArrayList<>();


        System.out.println(

                "=============================================\n" +
                        "|   Bem vindo ao sistema de cadastro de     |\n" +
                        "|       Pessoa Físicas e Juridícas          |\n" +
                        "=============================================");

        Thread.sleep(2000);
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {

            System.out.println(

                    "=============================================\n" +
                            "|       Escolha uma das opções abaixo       |\n" +
                            "|-------------------------------------------|\n" +
                            "|           1 - Pessoa Física               |\n" +
                            "|           2 - Pessoa Juridíca             |\n" +
                            "|                                           |\n" +
                            "|           0 - Sair                        |\n" +
                            "=============================================");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    int opcaoPf;

                    do {

                        System.out.println(

                                "=============================================\n" +
                                        "|       Escolha uma das opções abaixo       |\n" +
                                        "|-------------------------------------------|\n" +
                                        "|       1 - Cadastrar Pessoa Física         |\n" +
                                        "|       2 - Listar Pessoas Física           |\n" +
                                        "|                                           |\n" +
                                        "|       0 - Voltar ao menu anterior         |\n" +
                                        "=============================================");

                        opcaoPf = scanner.nextInt();

                        switch (opcaoPf) {

                            case 1:
                                PessoaFisica novapf = new PessoaFisica();
                                Endereco novoEndPf = new Endereco();

                                System.out.print("Digite o nome da pessoa física que deseja cadastrar: ");
                                novapf.nome = scanner.next();

                                System.out.print("Digite o CPF: ");
                                novapf.cpf = scanner.next();

                                System.out.print("Digite o rendimento mensal (Digite somente numero: ");
                                novapf.rendimento = scanner.nextInt();

                                System.out.print("Digite a data de Nascimento: (dd-MM-yyyy) ");
                                LocalDate date = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                Period periodo = Period.between(date, LocalDate.now());

                                System.out.println(periodo.getYears());

                                // Verifica se a pessoa tem mais de 18 anos
                                if (periodo.getYears() >= 18) {
                                    System.out.println("A pessoa tem mais de 18 anos.");
                                } else {
                                    System.out.println("A pessoa tem menos de 18 anos.");
                                }

                                System.out.print("Digite o logradouro: ");
                                novoEndPf.logradouro = scanner.next();

                                System.out.print("Digite o número: ");
                                novoEndPf.numero = scanner.next();

                                System.out.print("Este endereço é comercial? S/N: ");
                                String endCom;
                                endCom = scanner.next();

                                if (endCom.equals("S")) {
                                    novoEndPf.enderecoComercial = true;
                                } else {
                                    novoEndPf.enderecoComercial = false;
                                }

                                novapf.endereco = novoEndPf;

                                listaPf.add(novapf);

                                System.out.println("Cadastro realizado com sucesso!");

                                break;

                            case 2:

                                if (listaPf.size() > 0) {

                                    for (PessoaFisica cadaPf : listaPf) {
                                        System.out.println();
                                        System.out.println("Nome: " + cadaPf.nome);
                                        System.out.println("CPF: " + cadaPf.cpf);
                                        System.out.println("Endereco: " + cadaPf.endereco.logradouro + "," + cadaPf.endereco.numero);
                                        System.out.println("Data de Nascimento:" + cadaPf.dataNasc);
                                        System.out.println("Imposto a ser pago: " + metodosPf.CalcularImposto(cadaPf.rendimento));
                                        System.out.println();
                                        System.out.println("Digite 0 para continuar");
                                        scanner.nextLine();
                                    }
                                    opcaoPf = scanner.nextInt();

                                } else {
                                    System.out.println("Lista vazia");
                                }
                                break;

                            case 0:
                                System.out.println("Voltando ao menu anterior");
                                break;

                            default:
                                System.out.println("Opção inválida, por favor digite uma opção válida");
                                break;

                        }
                    }
                    while (opcaoPf != 0);
                    break;

                case 2:
                    int opcaoPj = 0;

                    do {

                        System.out.println(

                                "=============================================\n" +
                                        "|       Escolha uma das opções abaixo       |\n" +
                                        "|-------------------------------------------|\n" +
                                        "|       1 - Cadastrar Pessoa Jurídica       |\n" +
                                        "|       2 - Listar Pessoas Jurídica         |\n" +
                                        "|                                           |\n" +
                                        "|       0 - Voltar ao menu anterior         |\n" +
                                        "=============================================");

                        opcaoPj = scanner.nextInt();

                        switch (opcaoPj) {
                            case 1:
                                PessoaJuridica metodospj = new PessoaJuridica();
                                PessoaJuridica novaPj = new PessoaJuridica();
                                Endereco novoEndPj = new Endereco();

                                System.out.print("O nome da empresa: ");
                                novaPj.nome = scanner.next();

                                System.out.print("A razão social: ");
                                novaPj.razaoSocial = scanner.next();

                                System.out.print("O CNPJ: ");
                                novaPj.cnpj = scanner.next();

                                System.out.print("O Rendimento: ");
                                novaPj.rendimento = scanner.nextInt();

                                System.out.print("O Logradouro: ");
                                novoEndPj.logradouro = scanner.next();

                                System.out.print("O número: ");
                                novoEndPj.numero = scanner.next();

                                System.out.println("Este endereço é comercial? S/N");
                                String endComPj;
                                endComPj = scanner.next();

                                if (endComPj.equals("S")) {
                                    novoEndPj.enderecoComercial = true;
                                } else {
                                    novoEndPj.enderecoComercial = false;
                                }

                                novaPj.endereco = novoEndPj;

                                listaPj.add(novaPj);

                                System.out.println("Cadastro realizado com sucesso!");

                                break;

                            case 2:

                                if (listaPj.size() > 0) {

                                    for (PessoaJuridica cadaPj : listaPj) {
                                        System.out.println();
                                        System.out.println("Nome:" + cadaPj.nome);
                                        System.out.println("Razão Social:" + cadaPj.razaoSocial);
                                        System.out.println("CNPJ:" + cadaPj.cnpj);

                                        System.out.println("Imposto a ser pago:" + metodosPj.CalcularImposto((cadaPj.rendimento)));

                                        System.out.println("Endereco:" + cadaPj.endereco.logradouro);
                                        System.out.println("Endereco:" + cadaPj.endereco.numero);

                                        System.out.println();
                                        System.out.println("Digite 0 para continuar");
                                        scanner.nextLine();
                                    }
                                    opcaoPj = scanner.nextInt();

                                } else {
                                    System.out.println("Lista vazia");
                                }
                                break;

                            case 0:
                                System.out.print("Voltando ao menu anterior");
                                break;

                            default:
                                System.out.println("Opção inválida, por favor digite uma opção válida");
                                break;

                        }
                    } while (opcaoPj != 0);
                    break;

                case 0:
                    System.out.print("Obrigado por utilizar o nosso sistema");
                    break;

                default:
                    System.out.print("Opção inválida, por favor digite uma opção válida");
                    break;


            }
        }
        while (opcao != 0);

    }
}


