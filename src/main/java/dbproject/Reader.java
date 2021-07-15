package dbproject;

import java.io.*;

// singleton, т.к. нужен только один объект reader'a для всех методов, иначе стрим закрывается после первого вызова
public class Reader {

private static final BufferedReader instance = new BufferedReader(new InputStreamReader(System.in));
private Reader (){ }

    public static BufferedReader getReaderInstance() {
        return instance;
    }

    public static String readLine() {
    String input = null;
        try {
             input = getReaderInstance().readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }


    public static void close(){
        try {
            getReaderInstance().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
