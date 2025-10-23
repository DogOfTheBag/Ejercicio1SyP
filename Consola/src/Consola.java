import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Consola {
    public static void main(String[] args) throws IOException {
        //para abrir la consola primero usamos el comando cmd, y después es necesario usar /c para ejecutar una nueva
        //en este caso he puesto que solo se ejecute la primera, pero si le quieres pasar varios pues se divide el array de args y se le pasa cada argumento
        Process proceso = new ProcessBuilder("cmd", "/c", args[0]).start();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
            String linea;
            while((linea = reader.readLine()) != null){
                System.out.println(linea);
            }
        }

    }
}