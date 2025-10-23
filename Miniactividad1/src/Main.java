import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        /*Programa que coje los argumentos de args, se los pasa al programa hijo
        * y este los ejecuta por consola
        *
        * necesitamos aqui algo que nos pida los args, un output stream para mandar args y
        * un bufferedReader para leer. Al final un waitFor y chapamos*/
        String ruta = "C:\\Users\\alber\\Documents\\IntelIJ Projects\\Consola\\src";

        //args[0] = "dir";

        /*Con esto le pasamos los argumentos que queramos, simplemente ponemos aquí despues de consola los args
        * y ya el proceso cmd.start los manda directamente como args del programa hijo*/
        List<String> cmd = new ArrayList<>(Arrays.asList("java", "-cp", ruta, "Consola",/*ARGUMENTOS AQUÍ*/ "dir"));
        Process proceso = null;

        try{
            proceso = new ProcessBuilder(cmd).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

        String linea;

        while((linea = reader.readLine()) != null){
            System.out.println(linea);
        }

        try {
            proceso.waitFor();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Codigo de salida  " + proceso.exitValue());
    }
}