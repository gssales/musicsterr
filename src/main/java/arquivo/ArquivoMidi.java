package arquivo;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;

import java.io.File;
import java.io.IOException;

public class ArquivoMidi {
    private String musicStacatto;
    private String nomeArquivo;
    private String caminhoArquivo;

    public ArquivoMidi(String musicStacatto, String nomeArquivo, String caminhoArquivo) {
        this.musicStacatto = musicStacatto;
        this.nomeArquivo = nomeArquivo;
        this.caminhoArquivo = caminhoArquivo;
    }

    public boolean saveMidi() {
        try {
            MidiFileManager
                    .savePatternToMidi(
                            new Pattern(musicStacatto),
                            new File(caminhoArquivo+"\\"+nomeArquivo));
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
