import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

// InterfaceAprovacaoConsole.java
public class InterfaceAprovacaoConsole {
    
    private AprovacaoController controller;
    private Scanner scanner;
    
    public InterfaceAprovacaoConsole(AprovacaoController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }
    
    private void exibirPerfil(Perfil perfil) {
        System.out.println("\n--- PERFIL REGISTRADO ---");
        
        String interessesStr = perfil.getInteresses().stream()
            .map(Interesse::getNome)
            .collect(Collectors.joining(", "));
        System.out.println("Interesses: " + (interessesStr.isEmpty() ? "Nenhum" : interessesStr));
        
        String habilidadesStr = perfil.getHabilidades().stream()
            .map(Habilidade::getNome)
            .collect(Collectors.joining(", "));
        System.out.println("Habilidades: " + (habilidadesStr.isEmpty() ? "Nenhuma" : habilidadesStr));
        
        System.out.println("-------------------------\n");
    }

    public void iniciarFluxo() {
        System.out.println("=================================================");
        System.out.println("        💻 MÓDULO DE APROVAÇÃO (SIMULADO)        ");
        System.out.println("=================================================");
        
        CandidatoPendentes listaPendentes = controller.buscarCandidatosPendentes();
        List<Candidato> pendentes = listaPendentes.getListaPendentes();
        
        if (pendentes.isEmpty()) {
            System.out.println("\n[SISTEMA] Não há candidatos pendentes para análise.");
            return;
        }
        
        System.out.println("\n✅ ENCONTRADOS " + pendentes.size() + " CANDIDATO(S) PENDENTE(S):");
        for (Candidato c : pendentes) {
            System.out.println("   ID: " + c.getId_Candidato() + " | Nome: " + c.getNome());
        }
        
        System.out.print("\n➡️ Digite o ID do candidato que deseja ANALISAR (ou 0 para sair): ");
        int idSelecionado = scanner.nextInt();
        scanner.nextLine();

        if (idSelecionado == 0) return;
        
        Candidato candidatoEmAnalise = controller.analisarCandidato(idSelecionado, listaPendentes);
        
        if (candidatoEmAnalise == null) {
            System.out.println("\n[ERRO] Candidato com ID " + idSelecionado + " não encontrado.");
            return;
        }
        
        PessoaFisica pf = candidatoEmAnalise.getPessoaFisica();

        // SAÍDA ATUALIZADA: Exibir dados de identificação completos do Candidato
        System.out.println("\n--- DETALHES DE IDENTIFICAÇÃO DO CANDIDATO ---");
        System.out.println("Nome: " + candidatoEmAnalise.getNome());
        System.out.println("Email: " + candidatoEmAnalise.getEmail());
        if (pf != null) {
            System.out.println("CPF: " + pf.getCPF());
            System.out.println("Sexo: " + pf.getSexo());
            System.out.println("Nacionalidade: " + pf.getNacionalidade());
            System.out.println("Data Nasc.: " + pf.getDataNascimento());
            System.out.println("Profissão: " + pf.getProfissao());
            System.out.println("Endereço: " + pf.getEndereco());
        }
        System.out.println("-----------------------------------------------\n");
        
        String decisao;
        while (true) {
            System.out.print("➡️ Digite 'A' para APROVAR, 'R' para REJEITAR ou 'C' para CANCELAR: ");
            decisao = scanner.nextLine().trim().toUpperCase();
            if (decisao.equals("A") || decisao.equals("R") || decisao.equals("C")) break;
            System.out.println("[AVISO] Opção inválida. Tente novamente.");
        }
        
        Aprovacao resultado = null;
        if (decisao.equals("A")) {
            resultado = controller.aprovarAfiliacao(candidatoEmAnalise);
        } else if (decisao.equals("R")) {
            System.out.print("➡️ Digite o motivo da rejeição: ");
            String motivo = scanner.nextLine();
            resultado = controller.rejeitarAfiliacao(candidatoEmAnalise, motivo);
        }

        // NOVO REQUISITO: Exibir Perfil (Interesse e Habilidade) após a decisão
        if (resultado != null) {
            System.out.println("\n✅ DECISÃO REGISTRADA: " + resultado.getStatus().toUpperCase());
            exibirPerfil(candidatoEmAnalise.getPerfil());
        }
        
        System.out.println("=================================================");
    }
    
    public static void main(String[] args) {
        RepresentanteRMS repRMS = new RepresentanteRMS(777, "Ana Silva");
        AprovacaoController controller = new AprovacaoController(repRMS);
        InterfaceAprovacaoConsole fronteira = new InterfaceAprovacaoConsole(controller);
        fronteira.iniciarFluxo();
    }
}