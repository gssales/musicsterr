package musica.instrucoes;

import musica.Interpretador;
import musica.instrucoes.InstrucaoMusical;

public class ProximaOitava implements InstrucaoMusical {
    private byte soma;

    public ProximaOitava(byte soma) {
        this.soma = soma;
    }

    @Override
    public String executa(Interpretador.State state) {
        byte o = (byte) (state.getOitava() + soma);
        if (o > 10)
            state.setOitava((byte) 5);
        else
            state.setOitava(o);
        return "";
    }

    public byte getSoma() {
        return soma;
    }

    public void setSoma(byte soma) {
        this.soma = soma;
    }
}
