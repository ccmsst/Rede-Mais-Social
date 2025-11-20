import java.util.Scanner;

public class AprovacaoBoundary {
    
    private AprovacaoController controller;
    private Scanner scanner;
    
    public AprovacaoBoundary(AprovacaoController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }
    
    public CandidatoPendentes buscaCandidatoPendente() {
        CandidatoPendentes listaPendentes = controller.buscarCandidatosPendentes();        
        return listaPendentes;
    }
    
    public Candidato selecionaCandidato(int id, CandidatoPendentes listaPendentes) {
        Candidato candidatoSelecionado = controller.selecionaCandidato(id, listaPendentes);
        return candidatoSelecionado;
    }
    
    public void SolicitaAprovacao(Candidato candidato, Aprovacao resultado) {
        controller.solicitaAprovacao(candidato, resultado);
    }
    
    public void iniciarFluxo() {
        System.out.println("=================================================");
        System.out.println("         MÓDULO DE APROVAÇÃO (SIMULADO)        ");
        System.out.println("=================================================");
        
        CandidatoPendentes listaPendentes = buscaCandidatoPendente();
        
        System.out.print("\nDigite o ID do candidato que deseja ANALISAR (ou 0 para sair): ");
        int idSelecionado = scanner.nextInt();
        scanner.nextLine();

        if (idSelecionado == 0) return;
        
        Candidato candidatoEmAnalise = selecionaCandidato(idSelecionado, listaPendentes);
        
        if (candidatoEmAnalise == null) {
            System.out.println("Candidato não encontrado!");
            return;
        }
        
        String decisao;
        while (true) {
            System.out.print("Digite 'A' para APROVAR, 'R' para REJEITAR: ");
            decisao = scanner.nextLine().trim().toUpperCase();
            if (decisao.equals("A") || decisao.equals("R")) break;
            System.out.println("[AVISO] Opção inválida. Tente novamente.");
        }
        
        Aprovacao resultado = null;
        if (decisao.equals("A")) {
            resultado = controller.aprovarAfiliacao(candidatoEmAnalise);
        } else if (decisao.equals("R")) {
            System.out.print("Digite o motivo da rejeição: ");
            String motivo = scanner.nextLine();
            resultado = controller.rejeitarAfiliacao(candidatoEmAnalise, motivo);
        }
        
        SolicitaAprovacao(candidatoEmAnalise, resultado);
        
        System.out.println("=================================================");
    }
    
    public static void main(String[] args) {
        RepresentanteRMS repRMS = new RepresentanteRMS(777, "Ana Silva");
        AprovacaoController controller = new AprovacaoController(repRMS);
        AprovacaoBoundary fronteira = new AprovacaoBoundary(controller);
        fronteira.iniciarFluxo();
    }
}