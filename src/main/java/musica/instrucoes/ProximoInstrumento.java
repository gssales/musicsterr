package musica.instrucoes;

import musica.Interpretador;
import musica.instrucoes.InstrucaoMusical;

public class ProximoInstrumento implements InstrucaoMusical {
    private byte soma;

    public ProximoInstrumento(byte soma) {
        this.soma = soma;
    }

    @Override
    public String executa(Interpretador.State state) {
        byte i = (byte) (state.getInstrumento() + soma);
        if (i < 0)
            state.setInstrumento((byte) 0);
        else
            state.setInstrumento(i);
        return "I"+state.getInstrumento();
    }

    public byte getSoma() {
        return soma;
    }

    public void setSoma(byte soma) {
        this.soma = soma;
    }
}
