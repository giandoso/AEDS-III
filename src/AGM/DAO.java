package AGM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author giandoso
 */
public class DAO {

    static Graph g;
    static ArrayList<String[]> ops;

    public DAO() throws IOException {
        Reader tuplas = new Reader("src/AGM/newInstance.tsp", "tuplas");
        g = tuplas.buildGrafo();
        Reader operacoes = new Reader("src/AGM/operacoes.agm1", "operacoes");
        ops = operacoes.getOperacoes();

    }
}
