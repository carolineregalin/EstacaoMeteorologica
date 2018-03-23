
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
    public Path SelecionarArquivo() {
        Path caminho = null;
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            // Pega o arquivo selecionado no File Chooser
            File file = fileChooser.getSelectedFile();
            // Se o arquivo selecionado não é binário
            if (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf(".") + 1) != ".dat") {
                throw new IllegalArgumentException("Informe um formato de arquivo válido!");
            }
            // Retorna o caminho do arquivo
            caminho = Paths.get(file.getAbsolutePath());
        }
        return caminho;
    }
}
