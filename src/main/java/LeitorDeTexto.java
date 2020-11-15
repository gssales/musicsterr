import java.io.*;

public class LeitorDeTexto {
    private String texto;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void readFile(String path) {
        try {
            FileReader reader = new FileReader(path);
            BufferedReader buffer = new BufferedReader(reader);

            StringBuilder sbTexto = new StringBuilder();
            String line;
            while ((line = buffer.readLine()) != null)
                sbTexto.append(line);

            this.texto = sbTexto.toString();

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // TODO: 15/11/2020 return booleano 
    }

    public void writeFile(String path, String texto) {
        try {
            FileWriter writer = new FileWriter(path);
            PrintWriter printFile = new PrintWriter(writer);

            printFile.print(texto);

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // TODO: 15/11/2020 return boolean
    }
}
