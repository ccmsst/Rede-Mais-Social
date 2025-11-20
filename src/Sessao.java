import java.util.Date;

public class Sessao {
    private RepresentanteRMS representante;
    private Aprovacao aprovacao;
    
    public Sessao(RepresentanteRMS representante) { 
        this.representante = representante; 
    }
    
    public RepresentanteRMS getRepresentante() { return representante; }
    
    public static Sessao criaSessaoAprovacao() {
        RepresentanteRMS representante = new RepresentanteRMS(1, "João Silva");
        return new Sessao(representante);
    }
    
    public void criarAprovacao() {
        System.out.println("  [Sessao] Criando aprovação para representante: " + representante.getNome());
        this.aprovacao = new Aprovacao(representante, "Aprovado");
        aprovacao.criaAprovacao();
        aprovacao.atualizaDataAprovacao(new Date());
    }
    
    public Aprovacao getAprovacao() { return aprovacao; }
}