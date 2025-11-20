public class AfiliacaoDAO {
    private VoluntarioDAO voluntarioDAO = new VoluntarioDAO();
    
    public void atualizarStatus(Candidato candidato, Afiliacao afiliacao, String status, Aprovacao aprovacao) {
        System.out.println("  [AfiliacaoDAO] SIMULAÇÃO UPDATE: Afiliacao ID " + afiliacao.getId_afiliacao() + " alterada para status: " + status);
        afiliacao.setStatus(status); 
        
        if (aprovacao != null) {
            aprovacao.mudaSituacao(status);
        }
        
        if ("Aprovado".equals(status)) {
            voluntarioDAO.adicionVoluntario(candidato);
        }
    }
}