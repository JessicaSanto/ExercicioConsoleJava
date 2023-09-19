import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.awt.*;
import java.util.regex.Pattern;

public class PessoaJuridica extends Pessoa {
    public String cnpj;
    public String razaoSocial;

    public float CalcularImposto(float rendimento) {
        if (rendimento <= 3000) {
            return rendimento * .03f;

        } else if (rendimento <= 6000) {
            return rendimento * 0.5f;

        } else if (rendimento <= 10000) {
            return rendimento * .07f;

        } else {
            return rendimento * .09f;
        }
    }
    public boolean validarCnpj(String cnpj) {
        boolean retornoCnpjValido = Pattern.matches("^(\\d{14})|(\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2})$", cnpj);
        if (retornoCnpjValido) {
            if (cnpj.length() == 14) {
                String subStringCnpj14 = cnpj.substring(8, 12);
                if (subStringCnpj14.equals("0001")) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }


}
