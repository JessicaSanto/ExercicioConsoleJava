

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
}
