import musica.Interpretador;
import org.jfugue.player.Player;

public class Main {
    public static void main(String[] args) {
        String texto = " CDExCDE.CDE,CDEiCDE!CDE4CDE;CDExxxxCyDaEs CDE";
        String music = new Interpretador().interpreta2(texto);

        System.out.println(music);
        new Player().play(music);
    }
}
