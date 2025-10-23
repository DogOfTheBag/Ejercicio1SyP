import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Consola {
    public static void main(String[] args) throws IOException {
        Process proceso = new ProcessBuilder("cmd", "/c", args[0]).start();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
            String linea;
            while((linea = reader.readLine()) != null){
                System.out.println(linea);
            }
        }

    }
}