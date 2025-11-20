import java.util.List;

public class AprovacaoController {
    
    private CandidatoDAO candidatoDAO = new CandidatoDAO();
    private AfiliacaoDAO afiliacaoDAO = new AfiliacaoDAO();
    private AprovacaoDAO aprovacaoDAO = new AprovacaoDAO();
    private VoluntarioDAO voluntarioDAO = new VoluntarioDAO();
    private ONGDAO ongDAO = new ONGDAO();
    private RecomendacaoDAO recomendacaoDAO = new RecomendacaoDAO();
    
    private RepresentanteRMS representanteLogado;
    private Sessao sessao; 

    public AprovacaoController(RepresentanteRMS representanteLogado) {
        this.representanteLogado = representanteLogado;
        this.sessao = new Sessao(representanteLogado);
    }

    public CandidatoPendentes buscarCandidatosPendentes() {
        CandidatoPendentes listaPendentes = candidatoDAO.buscarPendentes(); 
        List<Candidato> pendentes = listaPendentes.getListaPendentes();
        if (pendentes.isEmpty()) {
            System.out.println("\n[SISTEMA] Não há candidatos pendentes para análise.");
        } else {
            System.out.println("\n[SISTEMA] CANDIDATO(S) PENDENTE(S) ENCONTRADOS:");
            for (Candidato c : pendentes) {
                System.out.println("   ID: " + c.getId_Candidato() + " | Nome: " + c.getNome());
            }
        }
        return listaPendentes;
    }

    public Candidato selecionaCandidato(int idCandidato, CandidatoPendentes listaPendentes) {
        Candidato candidato = listaPendentes.getCandidatoPorId(idCandidato);

        if (candidato == null) return null;
        
        Candidato detalhes = candidatoDAO.buscarDetalhes(idCandidato); 
        candidato.setPessoaFisica(detalhes.getPessoaFisica());
        candidato.setPerfil(detalhes.getPerfil());
        
        PessoaFisica pf = candidato.getPessoaFisica();
        System.out.println("\n--- DETALHES DE IDENTIFICAÇÃO DO CANDIDATO ---");
        System.out.println("Nome: " + candidato.getNome());
        System.out.println("Email: " + candidato.getEmail());
        if (pf != null) {
            System.out.println("CPF: " + pf.getCPF());
            System.out.println("Sexo: " + pf.getSexo());
            System.out.println("Nacionalidade: " + pf.getNacionalidade());
            System.out.println("Data Nasc.: " + pf.getDataNascimento());
            System.out.println("Profissão: " + pf.getProfissao());
            System.out.println("Endereço: " + pf.getEndereco());
        }
        System.out.println("-----------------------------------------------\n");

        return candidato;
    }

    // NOVOS MÉTODOS ADICIONADOS
    public Aprovacao aprovarAfiliacao(Candidato candidato) {
        System.out.println("\n[Controlador] Aprovando afiliação do candidato: " + candidato.getNome());
        
        // Cria sessão e aprovação
        sessao.criarAprovacao();
        Aprovacao aprovacao = sessao.getAprovacao();
        aprovacao = aprovacaoDAO.registrarAprovacao(aprovacao);
        
        // Atualiza afiliação
        afiliacaoDAO.atualizarStatus(candidato, candidato.getAfiliacao(), "Aprovado", aprovacao);
        
        // Cria voluntário
        voluntarioDAO.criarVoluntario(candidato, aprovacao.getId_aprovacao());
        
        // Processa recomendações
        solicitaRecomendacaoONGparceira(candidato, aprovacao);
        
        // Gera credenciais
        geraLoginSenhaVoluntario(candidato);
        
        System.out.println("\n[Controlador] SUCESSO! Candidato " + candidato.getNome() + " APROVADO.");
        return aprovacao;
    }
    
    public Aprovacao rejeitarAfiliacao(Candidato candidato, String motivo) {
        System.out.println("\n[Controlador] Rejeitando afiliação do candidato: " + candidato.getNome());
        System.out.println("Motivo: " + motivo);
        
        Aprovacao aprovacao = new Aprovacao(representanteLogado, "Rejeitado");
        aprovacao = aprovacaoDAO.registrarAprovacao(aprovacao);
        afiliacaoDAO.atualizarStatus(candidato, candidato.getAfiliacao(), "Rejeitado", aprovacao);
        
        return aprovacao;
    }

    public void solicitaAprovacao(Candidato candidato, Aprovacao resultado) {
        // Método mantido para compatibilidade
        if ("Aprovado".equals(resultado.getStatus())) {
            aprovarAfiliacao(candidato);
        }
    }
    
    public void solicitaRecomendacaoONGparceira(Candidato candidato, Aprovacao aprovacao) {
        System.out.println("\n[Controlador] Solicitando recomendações de ONGs parceiras para o perfil");
        
        List<ONG> ongsRecomendadas = ongDAO.buscarONGsECampanhasPorPerfil(candidato.getPerfil());
        
        System.out.println("[Controlador] >> Armazenando recomendações geradas.");
        for (ONG ong : ongsRecomendadas) {
            for (Campanha campanha : ong.getCampanhas()) {
                Recomendacao r = new Recomendacao(
                    campanha.getId_Campanha(), 
                    ong.getId_ONG(), 
                    representanteLogado.getId_RepresentanteRMS(), 
                    aprovacao.getId_aprovacao(), 
                    "Recomendação automática."
                );
                recomendacaoDAO.armazenarRecomendacao(r);
            }
        }
    }
    
    public void aprovaRecomendacaoONG() {
        System.out.println("\n[Controlador] Aprovando recomendações de ONGs parceiras.");
    }
    
    public void geraLoginSenhaVoluntario(Candidato candidato) {
        String login = "voluntario" + candidato.getId_Candidato();
        String senha = "senha" + candidato.getId_Candidato();
        enviaEmail(login, senha, candidato.getEmail());
        System.out.println("\n[Controlador] Login e senha gerados para o voluntário:");
    }
    
    public void enviaEmail(String login, String senha, String email) {
        System.out.println("\n[Controlador] Enviando email para: " + email);
        System.out.println("Login: " + login);
        System.out.println("Senha: " + senha);
        System.out.println("[Controlador] Email enviado com sucesso.");
    }
}