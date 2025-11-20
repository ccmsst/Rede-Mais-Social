import java.util.Date;
// Aprovacao.java (CORRIGIDA)
public class Aprovacao {
    private Integer id_aprovacao;
    private RepresentanteRMS aprovadoPor;
    private String status;
    private Date dataAprovacao;

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
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public void criaAprovacao() {
        System.out.println("  [Aprovacao] Aprovacao criada por: " + aprovadoPor.getNome() + " com status: " + status);
    }
    public void atualizaDataAprovacao(Date data) {
        this.dataAprovacao = data;
        System.out.println("  [Aprovacao] Data de aprovação atualizada para: " + data.toString());
    }
    public void mudaSituacao(String novoStatus) {
        this.status = novoStatus;
        System.out.println("  [Aprovacao] Status alterado para: " + novoStatus);
    }
}