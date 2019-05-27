package AGM;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author giandoso
 */
public class DAO {

    static Graph g;

    public DAO() throws IOException {
        Reader r = new Reader("src/AGM/newInstance.tsp");
        g = r.buildGrafo();
        List<Aresta> arestas = g.getArestasOrdenadas();
    }
}
