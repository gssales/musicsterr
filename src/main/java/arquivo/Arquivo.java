package arquivo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Arquivo {
    private String texto;

    public String getTexto() {
        return texto;
    }

    public boolean fileExists(String path) {
        return Files.exists(Path.of(path));
    }

    public boolean readFile(String path) {
        try {
            this.texto = Files.readString(Path.of(path));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
         return true;
    }

    public boolean writeFile(String path, String texto) {
        try {
            Files.writeString(Path.of(path), texto);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
