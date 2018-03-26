/* 
 *
 * - Alan Felipe Jantz 
 * - Caroline Belli Regalin
 * - Matheus Mahnke
 *
*/

import java.io.Serializable;
import java.text.*;
import java.util.*;

public class ClimaDoDia implements Serializable {

    // Atributos
    private Date data;
    private String ventoDirecao;
    private int ventoVelocidade;
    private int indicePluviometrico;
    private double temperatura;
    
    // Construtor
    public ClimaDoDia(Date data, String direcao, int velocidade, int indice, double temperatura) {
        this.setData(data);
        this.setVentoDirecao(direcao);
        this.setVentoVelocidade(velocidade);
        this.setIndicePluviometrico(indice);
        this.setTemperatura(temperatura);
    }
    public ClimaDoDia() {
        // Construtor vazio
    }
    
    // Data
    public Date getData() {
        return this.data;
    }
    public String getDataFormatada() {
        return new SimpleDateFormat("dd/MM//yyyy").format(data);
    }
    public String getDia(){
        return new SimpleDateFormat("dd").format(data);
    }
    public String getMes(){
        return new SimpleDateFormat("MM").format(data);
    } 
    public String getAno(){
        return new SimpleDateFormat("yyyy").format(data);
    }
    public void setData(Date value) {
        if (value == null) {
            throw new IllegalArgumentException("Data não pode ser nula!");
        }
        this.data = value;
    }

    // Direção do Vento
    public String getVentoDirecao() {
        return ventoDirecao;
    }
    public void setVentoDirecao(String value) {
        if (value == null || value.trim().length() < 1) {
            throw new IllegalArgumentException("Direção do vento não pode ser nulo!");
        } 
        this.ventoDirecao = value;
    }

    // Velocidade do Vento
    public int getVentoVelocidade() {
        return ventoVelocidade;
    }
    public void setVentoVelocidade(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Velocidade não pode ser negativa!");
        }
        this.ventoVelocidade = value;
    }

    // Índice Pluviométrico
    public int getIndicePluviometrico() {
        return indicePluviometrico;
    }
    public void setIndicePluviometrico(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Índice pluviométrico não pode ser negativo!");
        }
        this.indicePluviometrico = value;
    }

    // Temperatura
    public double getTemperatura() {
        return temperatura;
    }
    public void setTemperatura(double value) {
        this.temperatura = value;
    }
}