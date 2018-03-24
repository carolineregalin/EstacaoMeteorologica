/* 
 *
 * - Alan Felipe Jantz 
 * - Caroline Belli Regalin
 * - Matheus Mahnke
 *
*/

import java.util.Date;

public class ClimaDoDia {

    // Propriedades
    private Date data;
    private String ventDirecao;
    private int ventoVelocidade;
    private int indicePluviomtrico;
    private double temperatura;
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getVentDirecao() {
        return ventDirecao;
    }

    public void setVentDirecao(String ventDirecao) {
        this.ventDirecao = ventDirecao;
    }

    public int getVentoVelocidade() {
        return ventoVelocidade;
    }

    public void setVentoVelocidade(int ventoVelocidade) {
        this.ventoVelocidade = ventoVelocidade;
    }

    public int getIndicePluviomtrico() {
        return indicePluviomtrico;
    }

    public void setIndicePluviomtrico(int indicePluviomtrico) {
        this.indicePluviomtrico = indicePluviomtrico;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }
}