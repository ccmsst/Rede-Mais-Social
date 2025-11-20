// MENSAGEM: 9. atualizarStatus(status, aprovacao)
public class AfiliacaoDAO {
    public void atualizarStatus(Afiliacao afiliacao, String status, Aprovacao aprovacao) {
        System.out.println("  [AfiliacaoDAO] SIMULAÇÃO UPDATE: Afiliacao ID " + afiliacao.getId_afiliacao() + " alterada para status: " + status);
        afiliacao.setStatus(status); 
    }
}