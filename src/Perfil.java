import java.util.List;
import java.util.ArrayList;

// Perfil.java
public class Perfil {
    // NOVO ATRIBUTO: ID do Perfil
    private Integer id_perfil; 
    private String descricao;
    private List<Habilidade> habilidades = new ArrayList<>();
    private List<Interesse> interesses = new ArrayList<>();

    // Construtor adicionado
    public Perfil(Integer id_perfil) {
        this.id_perfil = id_perfil;
    }

    public Integer getId_perfil() { return id_perfil; } // Getter adicionado
    public List<Habilidade> getHabilidades() { return habilidades; }
    public List<Interesse> getInteresses() { return interesses; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void adicionarHabilidade(Habilidade h) { this.habilidades.add(h); }
    public void adicionarInteresse(Interesse i) { this.interesses.add(i); }
}