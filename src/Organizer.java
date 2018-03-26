/* 
 *
 * - Alan Felipe Jantz 
 * - Caroline Belli Regalin
 * - Matheus Mahnke
 *
 */

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Organizer {

    private ArrayList<String> arquivos;
    private ArrayList<Path> pathArquivos = new ArrayList<Path>();

    // Método que separar por mes e gera os arquivos
    public ArrayList<Path> separarMeses(ArrayList<ClimaDoDia> meses) throws IOException {
        // Percorre todos os meses do ano
        for (int i = 1; i <= 12; i++) {
            // Cria um novo Arraylist de ClimaDoDia
            ArrayList<ClimaDoDia> mes = new ArrayList();
            // Percorre os objetos de ClimaDoDia no ArrayList informado por parâmetro
            for (ClimaDoDia dia : meses) {
                int mesAtual = Integer.parseInt(dia.getMes());
                // Se o mês do dia em questão é igual ao mês atual
                if (mesAtual == i) {
                    // Adiciona ele ao Array do vetor do mes em questão
                    mes.add(dia);
                }
            }
            // Se o array do mes não estiver vazio
            if (!mes.isEmpty()) {
                // Cria o arquivo com o arraylist com os dias do mes
                validarMes(mes);
            }
        }
        return pathArquivos;
    }

    // Método que valida o mês separado
    public void validarMes(ArrayList<ClimaDoDia> mes) throws IOException {
        // Percorre os dias daquele mês 
        for (int i = 0; i < mes.size(); i++) {
            // Objeto com o dia atual
            ClimaDoDia atual = mes.get(i);
            // Se não for o último dia do ArrayList
            if(i > 0){
                // Pega o dia seguinte ao atual
                ClimaDoDia diaAnterior = mes.get(i-1);
                // Se a data do objeto atual for depois da data do próximo objeto
                if (diaAnterior.getData().after(atual.getData())) {
                    throw new IllegalArgumentException("O dia " + atual.getDataFormatada()+ " foi encontrado depois do dia " + diaAnterior.getDataFormatada()+ ".");
                }
                
                if (diaAnterior.getData().equals(atual.getData())) {
                    throw new IllegalArgumentException("O dia " + diaAnterior.getDataFormatada()+ " está repetido.");
              }
            }
        }
        // Se passou em todas as validações, gera o arquivo
        salvarMes(mes, mes.get(0).getAno() + "-" + mes.get(0).getMes() + ".dat");
    }

    // Método que gera o arquivo serializado com os itens do mês
    public void salvarMes(ArrayList<ClimaDoDia> mes, String nomeArq) throws IOException {
        try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(nomeArq));
            // Grava em um único objeto o ArrayList, que agrega todos os objetos dentro dele
            file.writeObject(mes);
            file.close();

            Path path = Paths.get(nomeArq);
            pathArquivos.add(path);
        } catch (FileNotFoundException fnfe) {
            throw new FileNotFoundException("Ocorreu um problema na geração do arquivo serializado:\r\n" + fnfe.getMessage());
        } catch (IOException ex) {
            throw new IOException("Ocorreu um problema na geração do arquivo serializado:\r\n" + ex.getMessage());
        }
    }
}
