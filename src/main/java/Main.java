import arquivo.Arquivo;
import arquivo.ArquivoMidi;
import musica.Interpretador;
import org.jfugue.player.Player;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\Users\\gssales\\Projects\\java\\teste.txt";

        Arquivo leitor = new Arquivo();
        String texto;
        if (leitor.fileExists(path)) {
            if (leitor.readFile(path)) {
                texto = leitor.getTexto();
            } else {
                System.out.println("Erro ao ler o arquivo");
                return;
            }
        } else {
            System.out.println("O arquivo não existe");
            return;
        }

        String music = new Interpretador().interpreta2(texto);

        boolean m = new ArquivoMidi(music, "teste2.mid", "C:\\Users\\gssales\\Projects\\java").saveMidi();
        if (m)
            System.out.println("Arquivo Salvo");
        else
            System.out.println("Erro ao salvar o arquivo");

        System.out.println(music);
        Player p = new Player();

        p.play(music);
    }
}
