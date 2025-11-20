public class RepresentanteRMS {
    private Integer id_RepresentanteRMS;
    private String nome;

    public RepresentanteRMS(Integer id, String nome) { 
        this.id_RepresentanteRMS = id; 
        this.nome = nome;
    }
    public Integer getId_RepresentanteRMS() { return id_RepresentanteRMS; }
    public String getNome() { return nome; }
}