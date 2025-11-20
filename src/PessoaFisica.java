// PessoaFisica.java
public class PessoaFisica {
    private String CPF;
    private String sexo;
    private String dataNascimento; 
    private String nacionalidade;
    private String profissao;
    private String endereco; 

    public PessoaFisica(String CPF, String sexo, String dataNascimento, String nacionalidade, String profissao, String endereco) {
        this.CPF = CPF;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.profissao = profissao;
        this.endereco = endereco;
    }

    public String getCPF() { return CPF; }
    public String getSexo() { return sexo; }
    public String getDataNascimento() { return dataNascimento; }
    public String getNacionalidade() { return nacionalidade; }
    public String getProfissao() { return profissao; }
    public String getEndereco() { return endereco; }
}