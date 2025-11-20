import java.util.Arrays;
import java.util.List;

// MENSAGEM: 11. buscarONGsECampanhasPorPerfil(perfil)
public class ONGDAO {
    public List<ONG> buscarONGsECampanhasPorPerfil(Perfil perfil) {
        System.out.println("  [ONGDAO] SIMULAÇÃO SELECT: Buscando ONGs/Campanhas que dão match.");
        
        ONG ong = new ONG(1, "ONG Verde", Arrays.asList(new Campanha(10)));
        return Arrays.asList(ong);
    }
}