package dbproject;

import java.io.*;

// singleton, т.к. нужен только один объект reader'a для всех методов, иначе стрим закрывается после первого вызова
public class Reader {

//    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//public class LazyInitializedSingleton {
//    private static LazyInitializedSingleton instance;
//    private LazyInitializedSingleton(){}
//    public static LazyInitializedSingleton getInstance(){ // #3
//        if(instance == null){		//если объект еще не создан
//            instance = new LazyInitializedSingleton();	//создать новый объект
//        }
//        return instance;		// вернуть ранее созданный объект
//    }

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
