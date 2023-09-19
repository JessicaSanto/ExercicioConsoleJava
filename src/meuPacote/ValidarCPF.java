//package meuPacote;
//
//import javax.swing.text.DefaultFormatterFactory;
//import javax.swing.text.MaskFormatter;
//
///**
// * @author Gilberto Toledo
// */
//public class ValidarCPF {
//    private String cpf;
//    private static final String Formato = "###.###.###-##";
//
//    public CPF(String C) {
//        this.cpf = this.Format(C, false);
//    }
//
//
//    public boolean isCPF() {
//
//        if (this.cpf.length() != 11)
//            return (false);
//
//        return false;
//    }
//
//    public String getCPF(boolean Mascara) {
//        return Format(this.cpf, Mascara);
//    }
//
//    private String Format(String C, boolean Mascara) {
//        if (Mascara) {
//            return (C.substring(0, 3) + "." + C.substring(3, 6) + "." +
//                    C.substring(6, 9) + "-" + C.substring(9, 11));
//        } else {
//            C = C.replace(".", "");
//            C = C.replace("-", "");
//            return C;
//        }
//    }
//
//
//    public static DefaultFormatterFactory getFormat() {
//        try {
//            return new DefaultFormatterFactory(new MaskFormatter(Formato));
//        } catch (Exception e) {
//            return null;
//        }
//    }
//}