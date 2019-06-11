package toyChildren;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author 2015.1.08.029
 */
public class Reader {

    FileReader scanner;
    BufferedReader file;
    static ArrayList<Tuple> tuplas = new ArrayList<>();

    public Reader(String fileName) throws FileNotFoundException, IOException {
        this.scanner = new FileReader(fileName);
        BufferedReader file = new BufferedReader(scanner);
        while (file.ready()) {
            String line = file.readLine();
            if ("".equals(line)) {
                break;
            }
            String[] s = line.split(",");
            //cria tupla
            Tuple t = new Tuple(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Double.parseDouble(s[2]));

            //adiciona aux em tuplas
            tuplas.add(t);
        }
    }  
    
    
    public ArrayList<Tuple> getTuplasOrdenadas(){
        ArrayList<Tuple> l = new ArrayList<>();
        for (Tuple t : tuplas) {
            l.add(t);
        }
        Collections.sort(l);
        return l;
    }
}
