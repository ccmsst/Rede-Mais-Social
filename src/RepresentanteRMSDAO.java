public class RepresentanteRMSDAO {
    
    public void criaAprovacao(Candidato candidato, Aprovacao aprovacao) {
        System.out.println("  [RepresentanteRMSDAO] Criando aprovação para candidato: " + candidato.getNome());
        Sessao sessao = Sessao.criaSessaoAprovacao();
        sessao.criarAprovacao();
    }
}