/* 
 *
 * - Alan Felipe Jantz 
 * - Caroline Belli Regalin
 * - Matheus Mahnke
 *
*/

import java.io.*;
import java.nio.file.Path;
import java.text.*;
import java.util.*;

public class MesInfo {
    
    // Método responsável por gerar o relatório mensal
    public String gerarRelatorioMes(ArrayList<ClimaDoDia> mes) throws IllegalArgumentException {
        if (mes == null) {
            throw new IllegalArgumentException("Arquivo não pode ser nulo!");
        }
        return "Mês:" + getMesArquivo(mes) + " \n\r"
             + "Quantidade de dias considerados: " + getQuantidadeDiasMes(mes) + " \n\r"
             + "Acumulado de chuva: " + getAcumuladoChuva(mes) + " \n\r"
             + "Velocidade média do vento: " + getVelocidadeMediaVento(mes) + " \n\r"
             + "Maior velocidade do vento: " + getMaiorVelocidadeVento(mes) + " \n\r"
             + "Menor velocidade do vento: " + getMenorVelocidadeVento(mes) + " \n\r"
             + "Temperatura média: " + getTemperaturaMedia(mes) + " \n\r"
             + "Maior temperatura: " + getMaiorTemperatura(mes) + " \n\r"
             + "Menor temperatura: " + getMenorTemperatura(mes);
    }

    // Método que busca o arquivo contendo o mês
    public ArrayList<ClimaDoDia> carregarMes(Path path) throws Exception {
        if (path == null) {
            throw new IllegalArgumentException("Caminho do arquivo não pode ser nulo!");
        }
        ArrayList<ClimaDoDia> mes;
        try {
            ObjectInputStream file = new ObjectInputStream(new FileInputStream(path.toFile()));
            // Lê o objeto de ArrayList trazendo todo seu conteúdo
            mes = (ArrayList<ClimaDoDia>) file.readObject();
            file.close();
        } catch (Exception ex) {
            throw new Exception("Erro ao abrir arquivo!\r\n" + ex.getMessage());
        }
        return mes;
    }

    // Método que retorna a quantidade de dias registrados daquele mês
    public int getQuantidadeDiasMes(ArrayList<ClimaDoDia> mes) {
        return mes.size();
    }

    // Método que retorna o acumulado de chuva
    public String getAcumuladoChuva(ArrayList<ClimaDoDia> mes) {
        int acumulado = 0;
        // Percorre todos os dias daquele mês
        for (ClimaDoDia dia : mes) {
            // Soma os índices pluviométricos
            acumulado += dia.getIndicePluviometrico();
        }
        return acumulado + " mm";
    }

    // Método que retorna a velocidade média do vento daquele mês
    public String getVelocidadeMediaVento(ArrayList<ClimaDoDia> mes) {
        double cont = 0;
        // Percorre todos os dias daquela mês
        for (ClimaDoDia dia : mes) {
            // Soma a velocidade de cada um
            cont += dia.getVentoVelocidade();
        }
        return (cont / getQuantidadeDiasMes(mes)) + " km/h";
    }

    // Método que retorna o dia com maior velocidade de vento
    public String getMaiorVelocidadeVento(ArrayList<ClimaDoDia> mes) {
        // Objeto para armarezar o dia com maior velocidade de vento
        ClimaDoDia maior = new ClimaDoDia();
        // Velocidade inicial começa com 0
        maior.setVentoVelocidade(0);
        // Percorre todos os dias daquela mês
        for (ClimaDoDia dia : mes) {
            // Se a velocidade do dia atual for maior que a velocidade do maior 
            if (dia.getVentoVelocidade() > maior.getVentoVelocidade()) {
                // Substitui o maior dia pelo atual
                maior = dia;
            }
        }
        return maior.getVentoVelocidade() + " km/h em " + maior.getData() + " na direção " + maior.getVentoDirecao();
    }

    // Método que retorna o dia com menor velocidade de vento
    public String getMenorVelocidadeVento(ArrayList<ClimaDoDia> mes) {
        // Objeto para armarezar o dia com menor velocidade de vento
        ClimaDoDia menor = new ClimaDoDia();
        // Velocidade inicial começa com o valor máximo de um inteiro
        menor.setVentoVelocidade(Integer.MAX_VALUE);
        // Percorre todos os dias daquela mês
        for (ClimaDoDia dia : mes) {
            // Se a velocidade do dia atual for menor que a velocidade do menor 
            if (menor.getVentoVelocidade() > dia.getVentoVelocidade()) {
                // Substitui o menor dia pelo atual
                menor = dia;
            }
        }
        return menor.getVentoVelocidade() + " km/h em " + menor.getData() + " na direção " + menor.getVentoDirecao();
    }

    // Método que retorna a temperatura média daquele mês
    public String getTemperaturaMedia(ArrayList<ClimaDoDia> mes) {
        double acumulado = 0;
        // Percorre todos os dias daquela mês
        for (ClimaDoDia dia : mes) {
            // Soma a temperatura de cada um
            acumulado += dia.getTemperatura();
        }
        return (acumulado / getQuantidadeDiasMes(mes)) + " ºC";
    }

    // Método que retorna o dia com maior temperatura
    public String getMaiorTemperatura(ArrayList<ClimaDoDia> mes) {
        // Objeto para armarezar o dia com maior temperatura
        ClimaDoDia maior = new ClimaDoDia();
        // Temperatura inicial começa com o valor mínimo de um inteiro
        maior.setTemperatura(Integer.MIN_VALUE);
        // Percorre todos os dias daquela mês
        for (ClimaDoDia dia : mes) {
            // Se a temperatura do dia atual for maior que a velocidade do maior
            if ( dia.getTemperatura() > maior.getTemperatura()) {
                // Substitui o maior dia pelo atual
                maior = dia;
            }
        }
        return maior.getTemperatura() + " ºC em " + maior.getData();
    }
    
    // Método que retorna o dia com menor temperatura
    public String getMenorTemperatura(ArrayList<ClimaDoDia> mes) {
        // Objeto para armarezar o dia com menor temperatura
        ClimaDoDia menor = new ClimaDoDia();
        // Temperatura inicial começa com o valor máximo de um inteiro
        menor.setTemperatura(Integer.MAX_VALUE);
        // Percorre todos os dias daquela mês
        for (ClimaDoDia dia : mes) {
            // Se a temperatura do dia atual for menor que a velocidade do maior
            if (menor.getTemperatura() > dia.getTemperatura()) {
                // Substitui o menor dia pelo atual
                menor = dia;
            }
        }
        return menor.getTemperatura() + " ºC em " + menor.getData();
    }
    
    // Método que retorna o mês do arquivo
    public String getMesArquivo(ArrayList<ClimaDoDia> mes) {
        // Pega o primeiro dia do mês
        ClimaDoDia dia = mes.get(0);
        // Retorna o mês/ano
        return dia.getMes() + "/" + dia.getAno();
    }
}
