import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        String filename;
        if (args.length > 0) {
            filename = args[0];
        } else {
            filename = "C:\\Users\\muril\\OneDrive\\Área de Trabalho\\gepeto\\casoa60.txt";
        }

        Monkey monk = new Monkey(filename);
        


    
        char[][] tree = monk.constructTree(filename);
        monk.calculateMaxPath(tree.length, tree[0].length, tree);
        
    }
}
