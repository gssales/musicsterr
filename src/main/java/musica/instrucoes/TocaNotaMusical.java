package musica.instrucoes;

import musica.Interpretador;
import musica.instrucoes.InstrucaoMusical;

public class TocaNotaMusical implements InstrucaoMusical {

    private char nota;

    public TocaNotaMusical(char nota) {
        this.nota = nota;
    }

    @Override
    public String executa(Interpretador.State state) {
        state.setUltimaNota(nota);
        return ""+nota+state.getOitava();
    }

    public char getNota() {
        return nota;
    }

    public void setNota(char nota) {
        this.nota = nota;
    }
}
