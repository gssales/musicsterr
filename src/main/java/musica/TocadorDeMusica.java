package musica;

import org.jfugue.player.Player;

public class TocadorDeMusica {
    private String musica;

    public TocadorDeMusica(String musica) {
        this.musica = musica;
    }

    public void tocaMusica() {
        Player p = new Player();
        p.play(musica);
    }
}
