package musica;

import org.jfugue.realtime.RealtimePlayer;

public class TocaNotaMusical implements InstrucaoMusical {

    private String nota;
    private int oitava;

    public TocaNotaMusical(String nota, int oitava) {
        this.nota = nota;
        this.oitava = oitava;
    }

    @Override
    public void executa(RealtimePlayer player) {
        player.play(nota+oitava);
    }
}
