package arquivo;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;

import java.io.File;
import java.io.IOException;

public class GeradorMidi {
    private String musicStacatto;
    private String path;

    public GeradorMidi(String musicStacatto, String path) {
        this.musicStacatto = musicStacatto;
        this.path = path;

    }

    public boolean saveMidi() {
        try {
            MidiFileManager
                    .savePatternToMidi(
                            new Pattern(musicStacatto),
                            new File(path));
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
