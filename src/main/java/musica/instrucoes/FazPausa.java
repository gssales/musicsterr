package musica.instrucoes;

import musica.Interpretador;
import musica.instrucoes.InstrucaoMusical;

public class FazPausa implements InstrucaoMusical {
    @Override
    public String executa(Interpretador.State state) {
        return "Rh";
    }
}
