import musica.TocaNotaMusical;
import org.jfugue.realtime.RealtimePlayer;

import javax.sound.midi.MidiUnavailableException;

public class Main {
    public static void main(String[] args) {
        String music = "C3q D3q E3q G3q A3q B3q C3q";

        RealtimePlayer player = null;
        try {
            player = new RealtimePlayer();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }

        TocaNotaMusical nota1 = new TocaNotaMusical("C", 3);
        TocaNotaMusical nota2 = new TocaNotaMusical("C", 4);
        TocaNotaMusical nota3 = new TocaNotaMusical("C", 5);

        nota1.executa(player);
        nota2.executa(player);
        nota3.executa(player);
    }
}
