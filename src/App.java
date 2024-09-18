import java.io.BufferedReader;
import java.io.FileReader;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws Exception {

        String filePath = "C:/Users/muril/faculdade/T2AlestII/Caminho-das-frutinhas-saborosas/casoa30.txt";
        BufferedReader reader;

        try {

            int count = 0;
            FileReader fileReader = new FileReader(filePath);
            reader = new BufferedReader(fileReader);

            String line = reader.readLine();

            while(line != null) {
                for(int i = 0; i < line.length(); i++) {
                    if(line.charAt(i) == '#') {
                        count++;

                    }
                }
                System.out.println(line);
                line = reader.readLine();
            }

            System.out.println(count);


        } catch(Exception e) {

            System.out.println(e.getMessage());
            throw e;

        }

    }

    public static void percorrerArvore(String filePath) throws Exception {

    }
}
