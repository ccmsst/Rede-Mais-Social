public class Afiliacao {
    private Integer id_afiliacao;
    private String status;
    private Candidato candidato;
    private Aprovacao aprovacao;
    
    public Afiliacao(Integer id_afiliacao, Candidato candidato, String status) {
        this.id_afiliacao = id_afiliacao;
        this.candidato = candidato;
        this.status = status;
    }
    
    public Integer getId_afiliacao() { return id_afiliacao; }
    public void setStatus(String status) { this.status = status; }
    public String getStatus() { return status; }
   
    public Aprovacao getAprovacao() { return aprovacao; }
}