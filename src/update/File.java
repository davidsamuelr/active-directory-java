/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package update;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author David Samuel
 */
public class File {

    private Date data;
    private String extensao;
    private String caminho;

    public File(Date data, String extensao, String caminho) {

        this.data = data;
        this.extensao = extensao;
        this.caminho = caminho + new SimpleDateFormat("yyyyMMdd").format(this.data) + this.extensao;

    }

    public BufferedReader getArquivo() throws FileNotFoundException, IOException {

        BufferedReader br = new BufferedReader(new FileReader(caminho));
        br.readLine(); // skip the header line
        return br;

    }

    public void verificaDiretorio(String nome) throws IOException {

        java.io.File diretorio = new java.io.File(nome);

        if (!diretorio.exists()) {
            diretorio.mkdirs();
        }

    }

    public void salvaArquivo(String texto) throws IOException {

        FileWriter arquivo = new FileWriter(caminho);
        new PrintWriter(arquivo).printf(texto);
        arquivo.close();

    }

    @Override
    public String toString() {
        return "file=" + caminho;
    }

}
