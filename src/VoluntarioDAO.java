// VoluntarioDAO.java (CORRIGIDO PARA USAR INTEGER)

public class VoluntarioDAO {
    // Agora aceita Integer, garantindo que mesmo se fosse nulo, não haveria NPE
    // (embora o AprovacaoDAO garanta que não será nulo agora).
    public Voluntario criarVoluntario(Candidato candidato, Integer idAprovacao) { 
        if (idAprovacao == null) {
            System.err.println("AVISO: Tentativa de criar Voluntário sem ID de Aprovação.");
            // Lógica de tratamento de erro real
        }
        System.out.println("  [VoluntarioDAO] SIMULANDO: Voluntário criado para Candidato ID: " + candidato.getId_Candidato() + " com Aprovação ID: " + idAprovacao);
        // O construtor de Voluntario deve usar Integer para evitar problemas aqui
        return new Voluntario(0, candidato.getId_Candidato(), idAprovacao); 
    }
}