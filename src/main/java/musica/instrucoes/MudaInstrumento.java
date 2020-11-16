package musica.instrucoes;

import musica.Interpretador;
import musica.instrucoes.InstrucaoMusical;

public class MudaInstrumento implements InstrucaoMusical {
    private byte instrumento;

    public MudaInstrumento(byte instrumento) {
        this.instrumento = instrumento;
    }

    @Override
    public String executa(Interpretador.State state) {
        state.setInstrumento(instrumento);
        return "I"+state.getInstrumento();
    }

    public byte getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(byte instrumento) {
        this.instrumento = instrumento;
    }
}
