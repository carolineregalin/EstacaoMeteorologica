/* 
 *
 * - Alan Felipe Jantz 
 * - Caroline Belli Regalin
 * - Matheus Mahnke
 *
*/

import java.io.File; 
import java.nio.file.*;
import javax.swing.JFileChooser;

public class FilePathManipulator {
    
    // Propriedades
    JFileChooser chooser = new JFileChooser();
    
    // Método responsável por selecionar um arquivo
    public Path SelecionarArquivo() throws Exception {
        Path caminho = null;
        chooser.setDialogTitle("Selecionar arquivo");
        // Se a pessoa selecionou um arquivo
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            // Pega o arquivo selecionado no File Chooser
            File arquivo = chooser.getSelectedFile();
            // Se o arquivo selecionado não é binário
            if (!arquivo.getName().substring(arquivo.getName().lastIndexOf(".") + 1).endsWith("dat")) {
                throw new Exception("'" + arquivo.getName().substring(arquivo.getName().lastIndexOf(".") + 1) + "'" +" não é um formato de arquivo válido!");
            }
            // Retorna o caminho do arquivo
            caminho = Paths.get(arquivo.getAbsolutePath());
        }
        return caminho;
    }
    
    public Path SelecionarDiretorio() throws Exception {
        Path caminho = null;
        chooser.setDialogTitle("Salvar relatório");
        // Mostrar apenas diretórios
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        // Se a pessoa selecionou um arquivo
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            // Retorna o caminho da pasta
            caminho = Paths.get(chooser.getSelectedFile().toString());
        }
        return caminho;
    }
}
