package musica.instrucoes;

import musica.Interpretador;
import org.jfugue.realtime.RealtimePlayer;

public interface InstrucaoMusical {
    String executa(Interpretador.State state);
}
