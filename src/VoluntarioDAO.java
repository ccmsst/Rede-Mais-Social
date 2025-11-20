public class VoluntarioDAO {
    
    public Voluntario criarVoluntario(Candidato candidato, Integer idAprovacao) { 
        if (idAprovacao == null) {
            System.err.println("AVISO: Tentativa de criar Voluntário sem ID de Aprovação.");
        }
        System.out.println("  [VoluntarioDAO] SIMULANDO: Voluntário criado para Candidato ID: " + candidato.getId_Candidato() + " com Aprovação ID: " + idAprovacao);
        return new Voluntario(0, candidato.getId_Candidato(), idAprovacao); 
    }
    
    public void adicionVoluntario(Candidato candidato) {
        System.out.println("  [VoluntarioDAO] SIMULAÇÃO: Adicionando Candidato ID " + candidato.getId_Candidato() + " como Voluntário.");
        // Chama o método do CandidatoDAO para transformar em voluntário
        CandidatoDAO candidatoDAO = new CandidatoDAO();
        candidatoDAO.tranformaEmVoluntario(candidato); 
    }
}