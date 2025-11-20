import java.util.Date;
import java.util.List;
public class ONG {
    private Integer id_ONG;
    private String nome;
    private List<Campanha> campanhas;
    public ONG(Integer id_ONG, String nome, List<Campanha> campanhas) { this.id_ONG = id_ONG; this.campanhas = campanhas; }
    public Integer getId_ONG() { return id_ONG; }
    public List<Campanha> getCampanhas() { return campanhas; }
}