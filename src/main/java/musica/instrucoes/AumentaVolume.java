package musica.instrucoes;

import musica.Interpretador;

public class AumentaVolume implements InstrucaoMusical {
    @Override
    public String executa(Interpretador.State state) {
        byte volume = (byte) (state.getVolume() *2);

        if (volume < 31)
            state.setVolume((byte) 31);
        else
            state.setVolume(volume);

        return ":Con(7,"+state.getVolume()+")";
    }
}
