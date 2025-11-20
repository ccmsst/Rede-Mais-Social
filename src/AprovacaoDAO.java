// AprovacaoDAO.java (CORRIGIDO)
public class AprovacaoDAO {
    private static int nextId = 1;
    
    // Método para simular o registro e atribuição de ID no banco
    public Aprovacao registrarAprovacao(Aprovacao aprovacao) {
        
        // CORREÇÃO CRÍTICA: Atribui o próximo ID ao objeto Aprovacao antes de retornar.
        aprovacao.setId_aprovacao(nextId++); 
        
        System.out.println("  [AprovacaoDAO] SIMULAÇÃO INSERT: Registro de Aprovacao armazenado (ID atribuído: " + aprovacao.getId_aprovacao() + ").");
        return aprovacao;
    }
    public int getId_aprovacao() { return nextId;}
}