import java.util.Collections;

// CandidatoDAO.java
public class CandidatoDAO {
    
    private Candidato getMockCandidato() {
        // ... (PessoaFisica permanece igual) ...
        PessoaFisica pf = new PessoaFisica(
            "123.456.789-00", 
            "Feminino", 
            "10/05/1995", 
            "Brasileira", 
            "Analista de Sistemas",
            "Rua das Flores, 123 - Centro"
        );

        // AJUSTE AQUI: Cria Perfil com um ID (ex: 1)
        Perfil perfil = new Perfil(1); 
        perfil.adicionarInteresse(new Interesse("Meio Ambiente"));
        perfil.adicionarInteresse(new Interesse("Voluntariado Local"));
        perfil.adicionarHabilidade(new Habilidade("Comunicação Interpessoal"));
        perfil.adicionarHabilidade(new Habilidade("Liderança"));

        // 3. Candidato
        Candidato c = new Candidato(101, "Joana Silva", "joana.s@email.com");
        c.setPessoaFisica(pf);
        c.setPerfil(perfil);

        // 4. Afiliacao
        Afiliacao a = new Afiliacao(500, c, "Pendente");
        c.setAfiliacao(a);
        
        return c;
    }
    
    // ... (restante dos métodos inalterados) ...
    public CandidatoPendentes buscarPendentes() {
        System.out.println("  [CandidatoDAO] SIMULANDO: Busca por candidatos pendentes.");
        CandidatoPendentes pendentes = new CandidatoPendentes();
        pendentes.adicionar(getMockCandidato()); 
        return pendentes;
    }
    
    public Candidato buscarDetalhes(int idCandidato) {
        System.out.println("  [CandidatoDAO] SIMULANDO: Busca por detalhes e perfil.");
        return getMockCandidato();
    }
    public void buscaCandidato(Candidato candidato) {
        System.out.println("  [CandidatoDAO] SIMULAÇÃO: Buscando Candidato ID " + candidato.getId_Candidato());
        candidato = getMockCandidato();
        candidato.getPerfil();
        candidato.getPerfil().getInteresses();
        candidato.getPerfil().getHabilidades();
    }
    public void tranformaEmVoluntario(Candidato candidato) {
        System.out.println("  [Candidato] Transformando em voluntário: " + candidato.getNome());
    }
}