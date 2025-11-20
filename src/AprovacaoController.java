import java.util.List;
import java.util.Collections;

// AprovacaoController.java
public class AprovacaoController {
    
    private CandidatoDAO candidatoDAO = new CandidatoDAO();
    private AfiliacaoDAO afiliacaoDAO = new AfiliacaoDAO();
    private AprovacaoDAO aprovacaoDAO = new AprovacaoDAO();
    private VoluntarioDAO voluntarioDAO = new VoluntarioDAO();
    private ONGDAO ongDAO = new ONGDAO();
    private RecomendacaoDAO recomendacaoDAO = new RecomendacaoDAO();

    private Sessao sessao; 

    public AprovacaoController(RepresentanteRMS representanteLogado) {
        this.sessao = new Sessao(representanteLogado);
    }

    // MENSAGEM: 1. buscarCandidatosPendentes()
    public CandidatoPendentes buscarCandidatosPendentes() {
        System.out.println("\n[Controlador] >> RepresentanteRMS solicitou lista de pendentes.");
        return candidatoDAO.buscarPendentes(); 
    }

    // MENSAGEM: 4. analisarCandidato(id)
    public Candidato analisarCandidato(int idCandidato, CandidatoPendentes listaPendentes) {
        Candidato candidato = listaPendentes.getCandidatoPorId(idCandidato);
        if (candidato == null) return null;
        
        // Chamada DAO para popular detalhes (PessoaFisica e Perfil)
        Candidato detalhes = candidatoDAO.buscarDetalhes(idCandidato); 
        candidato.setPessoaFisica(detalhes.getPessoaFisica());
        candidato.setPerfil(detalhes.getPerfil());
        return candidato;
    }

    // MENSAGEM: 7a. aprovarAfiliacao(candidato)
    public Aprovacao aprovarAfiliacao(Candidato candidato) {
        RepresentanteRMS aprovador = sessao.getRepresentante();
        System.out.println("\n[Controlador] >> INÍCIO DA APROVAÇÃO (Transação lógica).");
        
        Aprovacao aprovacao = new Aprovacao(aprovador, "Aprovado");
        aprovacao = aprovacaoDAO.registrarAprovacao(aprovacao); // Registra Aprovacao (8.)
        
        afiliacaoDAO.atualizarStatus(candidato.getAfiliacao(), "Aprovada", aprovacao); // Atualiza Afiliacao (9.)
        
        voluntarioDAO.criarVoluntario(candidato, aprovacao.getId_aprovacao()); // Cria Voluntario (10.)
        
        List<ONG> ongsRecomendadas = ongDAO.buscarONGsECampanhasPorPerfil(candidato.getPerfil()); // Busca Recomendações (11.)
        
        System.out.println("[Controlador] >> Armazenando recomendações geradas.");
        for (ONG ong : ongsRecomendadas) {
            for (Campanha campanha : ong.getCampanhas()) {
                Recomendacao r = new Recomendacao(campanha.getId_Campanha(), 1, aprovador.getId_RepresentanteRMS(), aprovacao.getId_aprovacao(), "Recomendação automática.");
                recomendacaoDAO.armazenarRecomendacao(r); // Armazena Recomendação (12.)
            }
        }
        
        System.out.println("\n[Controlador] SUCESSO! Candidato " + candidato.getNome() + " APROVADO.");
        return aprovacao;
    }
    
    // MENSAGEM: 7b. rejeitarAfiliacao(candidato, motivo)
    public Aprovacao rejeitarAfiliacao(Candidato candidato, String motivo) {
        Aprovacao aprovacao = new Aprovacao(sessao.getRepresentante(), "Rejeitado");
        aprovacao.setMotivoRejeicao(motivo);
        aprovacao = aprovacaoDAO.registrarAprovacao(aprovacao);
        afiliacaoDAO.atualizarStatus(candidato.getAfiliacao(), "Rejeitada", aprovacao);
        
        System.out.println("\n[Controlador] Afiliação de " + candidato.getNome() + " REJEITADA.");
        return aprovacao;
    }
}