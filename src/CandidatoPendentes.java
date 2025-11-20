import java.util.List;
import java.util.ArrayList;

public class CandidatoPendentes {
    private List<Candidato> listaPendentes = new ArrayList<>();

    public CandidatoPendentes() {}
    public void adicionar(Candidato c) { this.listaPendentes.add(c); }
    public List<Candidato> getListaPendentes() { return listaPendentes; }
    
    public Candidato getCandidatoPorId(int id) {
        return listaPendentes.stream()
                .filter(c -> c.getId_Candidato().equals(id))
                .findFirst()
                .orElse(null);
    }
}