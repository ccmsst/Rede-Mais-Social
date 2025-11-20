// Aprovacao.java (CORRIGIDA)
public class Aprovacao {
    private Integer id_aprovacao;
    private RepresentanteRMS aprovadoPor;
    private String status;
    private String motivoRejeicao; 

    // Construtor simplificado (usado pelo Controller)
    public Aprovacao(RepresentanteRMS aprovadoPor, String status) { 
        this(null, aprovadoPor, status); // Chama o construtor completo
    }

    // Construtor completo (usado pelo DAO ao recuperar dados)
    public Aprovacao(Integer id_aprovacao, RepresentanteRMS aprovadoPor, String status) {
        this.id_aprovacao = id_aprovacao;
        this.aprovadoPor = aprovadoPor;
        this.status = status;
    } 

    public Integer getId_aprovacao() { return id_aprovacao; }
    public void setId_aprovacao(Integer id_aprovacao) { this.id_aprovacao = id_aprovacao; }
    public RepresentanteRMS getAprovadoPor() { return aprovadoPor; }
    
    // MÉTODO getStatus() RESTAURADO
    public String getStatus() { return status; }
    
    public String getMotivoRejeicao() { return motivoRejeicao; }
    public void setMotivoRejeicao(String motivoRejeicao) { this.motivoRejeicao = motivoRejeicao; }
}