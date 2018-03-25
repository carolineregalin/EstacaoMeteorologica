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
        String result = new MesInfo().concatenarRelatorioMes(null);
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
    
    /*
    @Test
    public void testGetMaiorTemperatura() {
        ArrayList<ClimaDoDia> mes = new ArrayList<ClimaDoDia>();
        String result = new MesInfo().getMaiorTemperatura(mes);
    
        assertEquals("", result);
    }

    @Test
    public void testGetMenorTemperatura() {
        ArrayList<ClimaDoDia> mes = new ArrayList<ClimaDoDia>();
        String result = new MesInfo().getMenorTemperatura(mes);
    
        assertEquals("", result);
    }
    
    @Test
    public void testGerarRelatorioMes() throws Exception {
        ArrayList<ClimaDoDia> mes = new ArrayList<ClimaDoDia>();
    
        assertEquals("", "");
    }
    @Test
    public void testCarregarMes() throws Exception {
        ArrayList<ClimaDoDia> mes = new ArrayList<ClimaDoDia>();
    
        assertEquals("", "");
    }
    
    @Test
    public void testGetMaiorVelocidadeVento() {
        ArrayList<ClimaDoDia> mes = new ArrayList<ClimaDoDia>();
        ClimaDoDia dia1 = new ClimaDoDia();
        dia1.setVentoVelocidade(12);
        mes.add(dia1);
        ClimaDoDia dia2 = new ClimaDoDia();
        dia2.setVentoVelocidade(10);
        mes.add(dia2);
        ClimaDoDia dia3 = new ClimaDoDia();
        dia3.setVentoVelocidade(8);
        mes.add(dia3);
        String result = new MesInfo().getMaiorVelocidadeVento(mes);
        
        assertEquals("", result);
    }
    
    @Test
    public void testGetMenorVelocidadeVento() {
        ArrayList<ClimaDoDia> mes = new ArrayList<ClimaDoDia>();
        String result = new MesInfo().getMenorVelocidadeVento(mes);
    
        assertEquals("", result);
    }
    
    @Test
    public void testGetMesArquivo() throws ParseException {
        ArrayList<ClimaDoDia> mes = new ArrayList<ClimaDoDia>();
        ClimaDoDia dia = new ClimaDoDia();
        Date date = new Date();
        dia.setData(date);
        mes.add(dia);
        String mesAno = new MesInfo().getMesArquivo(mes);
        
        assertEquals("Dezembro/2012", mesAno);
    }
    */
}
