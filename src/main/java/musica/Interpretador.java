package musica;

import musica.instrucoes.*;

import java.util.*;

public class Interpretador {

    public class State {
        private byte oitava = 5;
        private byte instrumento = 0;
        private char ultimaNota = '\0';
        private byte volume = 31;

        public byte getOitava() {
            return oitava;
        }

        public void setOitava(byte oitava) {
            this.oitava = oitava;
        }

        public byte getInstrumento() {
            return instrumento;
        }

        public void setInstrumento(byte instrumento) {
            this.instrumento = instrumento;
        }

        public char getUltimaNota() {
            return ultimaNota;
        }

        public void setUltimaNota(char ultimaNota) {
            this.ultimaNota = ultimaNota;
        }

        public byte getVolume() {
            return volume;
        }

        public void setVolume(byte volume) {
            this.volume = volume;
        }
    }

    private HashMap<Character, InstrucaoMusical> mapeamento = new HashMap();

    public Interpretador() {
        mapeamento.put('A', new TocaNotaMusical('A'));
        mapeamento.put('B', new TocaNotaMusical('B'));
        mapeamento.put('C', new TocaNotaMusical('C'));
        mapeamento.put('D', new TocaNotaMusical('D'));
        mapeamento.put('E', new TocaNotaMusical('E'));
        mapeamento.put('F', new TocaNotaMusical('F'));
        mapeamento.put('G', new TocaNotaMusical('G'));
        mapeamento.put('I', new MudaInstrumento((byte) 7));
        mapeamento.put('i', new MudaInstrumento((byte) 7));
        mapeamento.put('O', new MudaInstrumento((byte) 7));
        mapeamento.put('o', new MudaInstrumento((byte) 7));
        mapeamento.put('U', new MudaInstrumento((byte) 7));
        mapeamento.put('u', new MudaInstrumento((byte) 7));
        mapeamento.put('!', new MudaInstrumento((byte) 114));
        mapeamento.put('\n', new MudaInstrumento((byte) 15));
        mapeamento.put(';', new MudaInstrumento((byte) 76));
        mapeamento.put(',', new MudaInstrumento((byte) 20));
        mapeamento.put('0', new ProximoInstrumento((byte) 0));
        mapeamento.put('1', new ProximoInstrumento((byte) 1));
        mapeamento.put('2', new ProximoInstrumento((byte) 2));
        mapeamento.put('3', new ProximoInstrumento((byte) 3));
        mapeamento.put('4', new ProximoInstrumento((byte) 4));
        mapeamento.put('5', new ProximoInstrumento((byte) 5));
        mapeamento.put('6', new ProximoInstrumento((byte) 6));
        mapeamento.put('7', new ProximoInstrumento((byte) 7));
        mapeamento.put('8', new ProximoInstrumento((byte) 8));
        mapeamento.put('9', new ProximoInstrumento((byte) 9));
        mapeamento.put('?', new ProximaOitava((byte) 1));
        mapeamento.put('.', new ProximaOitava((byte) 1));
        mapeamento.put(' ', new AumentaVolume());
    }

    public String interpreta2(String texto) {
        State state = new State();
        char[] arrayChars = texto.toCharArray();

        StringBuilder sequence = new StringBuilder();
        sequence.append(":CON(7,").append(state.getVolume()).append(") T110 ");

        for (char c : arrayChars) {
            if (mapeamento.containsKey(c)) {
                InstrucaoMusical instr = mapeamento.get(c);
                sequence.append(instr.executa(state))
                        .append(' ');

                if (!(instr instanceof TocaNotaMusical)) {
                    state.setUltimaNota('\0');
                }
            } else {
                if (state.getUltimaNota() != '\0') {
                    sequence.append(new TocaNotaMusical(state.getUltimaNota()).executa(state))
                            .append(' ');
                    state.setUltimaNota('\0');
                } else {
                    sequence.append(new FazPausa().executa(state))
                            .append(' ');
                }
            }
        }

        return sequence.toString();
    }
}
