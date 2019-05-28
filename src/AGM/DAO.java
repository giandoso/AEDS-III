package AGM;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author giandoso
 */
public class DAO {

    public Graph g;

    public DAO() throws IOException {
        Reader r = new Reader("src/AGM/newInstance.tsp");
        g = r.buildGrafo();
    }

    public Graph getG() {
        return g;
    }
    
    
    
}
