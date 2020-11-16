package musica.instrucoes;

import musica.Interpretador;
import musica.instrucoes.InstrucaoMusical;

public class AumentaVolume implements InstrucaoMusical {
    @Override
    public String executa(Interpretador.State state) {
        byte volume = (byte) (state.getVolume() *2);

        if (volume < 32)
            state.setVolume((byte) 32);
        else
            state.setVolume(volume);

        return ":Con(7,"+state.getVolume()+")";
    }
}
