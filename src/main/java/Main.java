import arquivo.LeitorDeTexto;
import arquivo.GeradorMidi;
import musica.Interpretador;
import musica.TocadorDeMusica;
import javax.swing.JFileChooser;

public class Main {
    public static void main(String[] args) {
        String path = ".\\files\\teste.txt";
        JFileChooser file = new JFileChooser();
        file.setVisible(true);

        LeitorDeTexto leitor = new LeitorDeTexto();
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

        String music = new Interpretador().interpreta(texto);

        boolean m = new GeradorMidi(music, "teste2.mid", ".\\files").saveMidi();
        if (m)
            System.out.println("Arquivo Salvo");
        else
            System.out.println("Erro ao salvar o arquivo");

        System.out.println(music);
        TocadorDeMusica t = new TocadorDeMusica(music);
        t.tocaMusica();
    }
}
