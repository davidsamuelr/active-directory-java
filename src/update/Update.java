/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package update;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import javax.naming.directory.SearchResult;

/**
 *
 * @author David Samuel
 */
public class Update {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        Update obj = new Update();
        obj.leArquivo();
        
    }

    public void leArquivo() throws Exception {

        BufferedReader br = null;
        String linha = "";
        Integer alterados = 0;
        String texto = "";
        String logDiretorio = "log";

        File arquivoSecad = new File(new Date(), ".csv", System.getProperty("user.dir") + "\\ad-");
        File arquivoLog = new File(new Date(), ".log", System.getProperty("user.dir") + "\\" + logDiretorio + "\\");
        arquivoLog.verificaDiretorio(logDiretorio);

        try {

            br = arquivoSecad.getArquivo();

            while ((linha = br.readLine()) != null) {

                String[] str = linha.split(";");

                Employee servidor = new Employee(str[str.length - 6],
                        str[str.length - 7], str[str.length - 10],
                        str[str.length - 3], str[str.length - 2],
                        str[str.length - 5], str[str.length - 1]);

                if (servidor.validaCpf() && servidor.valida() && servidor.validaStatus()) {

                    SearchResult sr = new Dap().busca(servidor);

                    if (sr != null) {
                        new Dap().altera(sr, servidor);
                        texto = texto + sr.getAttributes().get("displayName").toString().replace("displayName: ", "") + " - "
                                + sr.getAttributes().get("statusUser").toString().replace("statusUser: ", "") + "\n";
                        alterados++;
                    }

                } else {
                    texto = texto + "Line error " + alterados + "\n";
                }
            }
            arquivoLog.salvaArquivo(texto + "Changed= " + alterados + "\n" + new Date());

        } catch (FileNotFoundException e) {
            arquivoLog.salvaArquivo(e.getMessage());
        } catch (IOException e) {
            arquivoLog.salvaArquivo(e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    arquivoLog.salvaArquivo(e.getMessage());
                }
            }
        }
        
    }

}
