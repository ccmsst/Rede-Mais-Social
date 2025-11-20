// Candidato.java
public class Candidato {
    private Integer id_Candidato;
    private String nome;
    private String email;
    private PessoaFisica pessoaFisica;
    private Perfil perfil; 
    private Afiliacao afiliacao;
    
    public Candidato(Integer id_Candidato, String nome, String email) {
        this.id_Candidato = id_Candidato;
        this.nome = nome;
        this.email = email;
    }

    public Integer getId_Candidato() { return id_Candidato; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public PessoaFisica getPessoaFisica() { return pessoaFisica; }
    public Perfil getPerfil() { return perfil; }
    public Afiliacao getAfiliacao() { return afiliacao; }
    
    public void setPessoaFisica(PessoaFisica pessoaFisica) { this.pessoaFisica = pessoaFisica; }
    public void setPerfil(Perfil perfil) { this.perfil = perfil; }
    public void setAfiliacao(Afiliacao afiliacao) { this.afiliacao = afiliacao; }
}