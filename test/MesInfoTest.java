/* 
 *
 * - Alan Felipe Jantz 
 * - Caroline Belli Regalin
 * - Matheus Mahnke
 *
*/

import java.nio.file.*;
import java.text.*;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MesInfoTest {
    
    @Test(expected = IllegalArgumentException.class)
    public void testGerarRelatorioMesComCaminhoNulo() throws Exception {
        String result = new MesInfo().gerarRelatorioMes(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testConcatenarRelatorioMes() throws Exception {
        String result = new MesInfo().gerarRelatorioMes(null);
    }

    @Test
    public void testGetQuantidadeDiasMes() {
        ClimaDoDia dia = new ClimaDoDia();
        ArrayList<ClimaDoDia> mes = new ArrayList<ClimaDoDia>();
        mes.add(dia);
        mes.add(dia);
        mes.add(dia);
        int result = new MesInfo().getQuantidadeDiasMes(mes);
        
        assertEquals(3, result);
    }
    
    @Test
    public void testGetAcumuladoChuva() {
        ArrayList<ClimaDoDia> mes = new ArrayList<ClimaDoDia>();
        ClimaDoDia dia = new ClimaDoDia();
        dia.setIndicePluviometrico(10);
        mes.add(dia);
        mes.add(dia);
        mes.add(dia);
        String result = new MesInfo().getAcumuladoChuva(mes);
        
        assertEquals("30 mm", result);
    }

    @Test
    public void testGetVelocidadeMediaVento() {
        ArrayList<ClimaDoDia> mes = new ArrayList<ClimaDoDia>();
        ClimaDoDia dia = new ClimaDoDia();
        dia.setVentoVelocidade(10);
        mes.add(dia);
        mes.add(dia);
        mes.add(dia);
        String result = new MesInfo().getVelocidadeMediaVento(mes);
        
        assertEquals("10.0 km/h", result);
    }

    @Test
    public void testGetTemperaturaMedia() {
        ArrayList<ClimaDoDia> mes = new ArrayList<ClimaDoDia>();
        ClimaDoDia dia = new ClimaDoDia();
        dia.setTemperatura(10);
        mes.add(dia);
        mes.add(dia);
        mes.add(dia);
        String result = new MesInfo().getTemperaturaMedia(mes);
        
        assertEquals("10.0 ºC", result);
    }
}
