

//import meuPacote.ValidarCNPJ;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        PessoaFisica metodosPf = new PessoaFisica();
        PessoaJuridica metodosPj = new PessoaJuridica();

        ArrayList<PessoaFisica> listaPf = new ArrayList<>();
        ArrayList<PessoaJuridica> listaPj = new ArrayList<>();

        System.out.print(
                "=============================================\n" +
                        "|   Bem vindo ao sistema de cadastro de     |\n" +
                        "|       Pessoa Físicas e Juridícas          |\n" +
                        "=============================================");

        Thread.sleep(2000);

//        limparTela();

        Scanner scanner = new Scanner(in);

        System.out.print(
                "=============================================\n" +
                        "|       Escolha uma das opções abaixo       |\n" +
                        "|-------------------------------------------|\n" +
                        "|           1 - Pessoa Física               |\n" +
                        "|           2 - Pessoa Juridíca             |\n" +
                        "|                                           |\n" +
                        "|           0 - Sair                        |\n" +
                        "=============================================");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:

                int opcaoPf;

                do {
//                    limparTela();

                    System.out.print(
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

                            System.out.print("Digite a data de Nascimento: ");
                            novapf.dataNasc = DateTimeFormatter.ofPattern(scanner.next());

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

//                            Thread.sleep(2000);
                            break;

                        case 2:

//                            limparTela();

                            if (listaPf.size() > 0) {

                                for (PessoaFisica cadaPf : listaPf) {
                                    System.out.println();
                                    System.out.println("Nome: " + cadaPf.nome);
                                    System.out.println("CPF: " + cadaPf.cpf);
                                    System.out.println("Endereco: " + cadaPf.endereco.logradouro + "," + cadaPf.endereco.numero);
//                                    System.out.println("Data de Nascimento:" + cadaPf.dataNasc);
                                    System.out.println("Imposto a ser pago: " + metodosPf.CalcularImposto(cadaPf.rendimento));
                                    System.out.println();
                                    System.out.println("Aperte 'ENTER' para continuar");
                                    scanner.nextLine();
                                }
                                opcaoPf = scanner.nextInt();

                            } else {
                                System.out.println("Lista vazia");
//                                Thread.sleep(2000);
                            }

                        case 0:
                            System.out.println("Voltando ao menu anterior");
                            break;

                        default:
//                            limparTela();
                            System.out.println("Opção inválida, por favor digite uma opção válida");
//                            Thread.sleep(2000);
                    }
                } while (opcaoPf != 0);

            case 2:

                int opcaoPj = 0;

                do {
//                    limparTela();

                    System.out.print(
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

//                            if (ValidarCNPJ.isCNPJ(novaPj.cnpj) == true)
//                                System.out.printf("%s\n", ValidarCNPJ.imprimeCNPJ(novaPj.cnpj));
//                            else System.out.printf("Erro, CNPJ inválido !!!\n");

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

//                            limparTela();

                            if (listaPj.size() > 0) {

                                for (PessoaJuridica cadaPj : listaPj) {
                                    System.out.println();
                                    System.out.println("Nome:" + cadaPj.nome);
                                    System.out.println("Razão Social:" + cadaPj.razaoSocial);
                                    System.out.println("CNPJ:" + (cadaPj.validarCnpj(cadaPj.cnpj) ? "CNPJ Válido" : "CNPJ Inálido"));

                                    System.out.println("Imposto a ser pago:" + metodosPj.CalcularImposto((cadaPj.rendimento)));

                                    System.out.println("Endereco:" + cadaPj.endereco.logradouro);
                                    System.out.println("Endereco:" + cadaPj.endereco.numero);

                                    System.out.println();
                                    System.out.println("Aperte 'ENTER' para continuar");
                                    scanner.nextLine();
                                }
                                opcaoPj = scanner.nextInt();

                            } else {
                                System.out.println("Lista vazia");
//                                Thread.sleep(2000);

                            }

                        case 0:
                            System.out.print("Obrigado por utilizar o nosso sistema");
                            break;

                        default:
//                limparTela();
                            System.out.print("Opção inválida, por favor digite uma opção válida");
//                Thread.sleep(3000);

                    }
                }
                while (opcao != 0);

//        PessoaFisica suaInstancia = new PessoaFisica();
//        LocalDate dataDeNascimento = LocalDate.of(1990, 8, 25); // Substitua com a data de nascimento desejada
//        boolean resultado = suaInstancia.ValidarDataNasc(dataDeNascimento);
//        System.out.println("Resultado: " + resultado);
//    }
//
//    public static void limparTela() {
//        System.out.print("\033[H\033[2J");
//        System.out.flush();
//    }

        }
    }
}