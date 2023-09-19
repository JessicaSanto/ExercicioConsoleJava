//package meuPacote;
//
//import java.util.InputMismatchException;
//
//public class ValidarCNPJ (String C, boolean M){
//    private boolean Mascara;
//    private String cpf;
//    private static final String Formato = "###.###.###-##";
//
//    this.Mascara = M;
//    this.cpf
//
//    public static boolean isCNPJ(String CNPJ) {
//             if(CNPJ.length() != 14)
//            return(false);
//
//        char dig13, dig14;
//        int sm, i, r, num, peso;
//
//// "try" - protege o código para eventuais erros de conversao de tipo (int)
//        try {
//// Calculo do 1o. Digito Verificador
//            sm = 0;
//            peso = 2;
//            for (i=11; i>=0; i--) {
//// converte o i-ésimo caractere do CNPJ em um número:
//// por exemplo, transforma o caractere '0' no inteiro 0
//// (48 eh a posição de '0' na tabela ASCII)
//                num = (int)(CNPJ.charAt(i) - 48);
//                sm = sm + (num * peso);
//                peso = peso + 1;
//                if (peso == 10)
//                    peso = 2;
//            }
//
//            r = sm % 11;
//            if ((r == 0) || (r == 1))
//                dig13 = '0';
//            else dig13 = (char)((11-r) + 48);
//
//// Calculo do 2o. Digito Verificador
//            sm = 0;
//            peso = 2;
//            for (i=12; i>=0; i--) {
//                num = (int)(CNPJ.charAt(i)- 48);
//                sm = sm + (num * peso);
//                peso = peso + 1;
//                if (peso == 10)
//                    peso = 2;
//            }
//
//            r = sm % 11;
//            if ((r == 0) || (r == 1))
//                dig14 = '0';
//            else dig14 = (char)((11-r) + 48);
//
//// Verifica se os dígitos calculados conferem com os dígitos informados.
//            if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13)))
//                return(true);
//            else return(false);
//        } catch (InputMismatchException erro) {
//            return(false);
//        }
//    }
//
//    public static String imprimeCNPJ(String CNPJ) {
//// máscara do CNPJ: 99.999.999.9999-99
//        return(CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) + "." +
//                CNPJ.substring(5, 8) + "." + CNPJ.substring(8, 12) + "-" +
//                CNPJ.substring(12, 14));
//    }
//}
