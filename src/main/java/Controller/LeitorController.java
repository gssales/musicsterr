/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Leitor;
import arquivo.GeradorMidi;
import arquivo.LeitorDeTexto;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import musica.Interpretador;
import musica.TocadorDeMusica;

/**
 *
 * @author Pedro
 */
public class LeitorController {

    private final Leitor view;

    public LeitorController(Leitor view) {
        this.view = view;
    }

    public void tocaMusica() {
        Interpretador interpretador = new Interpretador();

        String texto = view.getTextMusica().getText();
        String musica = interpretador.interpreta(texto);

        TocadorDeMusica tocador = new TocadorDeMusica(musica);

        tocador.tocaMusica();

        System.out.println("teste");
    }

    public void salvaMIDI() {
        Interpretador interpretador = new Interpretador();

        String texto = view.getTextMusica().getText();
        String musica = interpretador.interpreta(texto);

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");

        int userSelection = fileChooser.showSaveDialog(this.view);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            boolean m = new GeradorMidi(musica, fileToSave.getAbsolutePath() + ".mid").saveMidi();
            if (m) {
                System.out.println("Arquivo Salvo");
            } else {
                System.out.println("Erro ao salvar o arquivo");
            }
        }
    }

    public void carregaTexto() {

        LeitorDeTexto leitorDeTexto = new LeitorDeTexto();

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        chooser.setFileFilter(filter);
        // optionally set chooser options ...
        if (chooser.showOpenDialog(this.view) == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            // read  and/or display the file somehow. ....
            leitorDeTexto.readFile(f.getAbsolutePath());

            String texto = leitorDeTexto.getTexto();

            view.getTextMusica().setText(texto);
        } else {
            // user changed their mind
        }

    }
}
