
import java.io.File; 
import java.io.Serializable;
import java.nio.file.*;
import javax.swing.JFileChooser;
import java.lang.*;

/**
 *
 * @author Alan
 */
public class AbrirArquivo {
    
    // Propriedades
    JFileChooser fileChooser = new JFileChooser();
    
    // Método responsável por selecionar um arquivo
    public Path SelecionarArquivo() throws Exception {
        Path caminho = null;
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            // Pega o arquivo selecionado no File Chooser
            File arquivo = fileChooser.getSelectedFile();
            // Se o arquivo selecionado não é binário
            if (!getExtensaoArquivo(arquivo).endsWith("dat")) {
                throw new Exception("'" + getExtensaoArquivo(arquivo) + "'" +" não é um formato de arquivo válido!");
            }
            // Retorna o caminho do arquivo
            caminho = Paths.get(arquivo.getAbsolutePath());
        }
        return caminho;
    }
    
    private String getExtensaoArquivo(File value) {
        String nomeArquivo = value.getName();
        if(nomeArquivo.lastIndexOf(".") != -1 && nomeArquivo.lastIndexOf(".") != 0)
            return nomeArquivo.substring(nomeArquivo.lastIndexOf(".") + 1);
        else return "";
    }
}
