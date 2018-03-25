/* 
 *
 * - Alan Felipe Jantz 
 * - Caroline Belli Regalin
 * - Matheus Mahnke
 *
*/

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClimaDoDiaTest {
    
    private ClimaDoDia instance = new ClimaDoDia();
    
    @Test
    public void testConstructorNoParam() {
        instance = new ClimaDoDia();
    }
    
    @Test
    public void testConstructorWithParam() {
        instance = new ClimaDoDia(new Date(), "SE", 10, 10, 10);
    }
    
    /*
    @Test
    public void testGetData() {
        Date result = instance.getData();
        
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDia() {
        String expResult = "";
        String result = instance.getDia();
        
        assertEquals(expResult, result);
    }

    @Test
    public void testGetMes() {
        String expResult = "";
        String result = instance.getMes();
        
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAno() {
        String expResult = "";
        String result = instance.getAno();
    
        assertEquals(expResult, result);
    }
    */

    @Test
    public void testSetData() {
        instance.setData(new Date());
    }

    @Test
    public void testGetVentoDirecao() {
        instance.setVentoDirecao("SE");
        
        assertEquals("SE", instance.getVentoDirecao());
    }
    
    @Test
    public void testSetVentoDirecaoValorValido() {
        instance.setVentoDirecao("SE");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetVentoDirecaoValorInvalido1() {
        instance.setVentoDirecao("DE");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetVentoDirecaoValorInvalido2() {
        instance.setVentoDirecao("");
    }
    
    @Test
    public void testGetVentoVelocidade() {
        instance.setVentoVelocidade(10);
        
        assertEquals(10, instance.getVentoVelocidade());
    }

    @Test
    public void testSetVentoVelocidadeValorValido() {
        instance.setVentoVelocidade(10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetVentoVelocidadeValorInvalido() {
        instance.setVentoVelocidade(-10);
    }
    
    @Test
    public void testGetIndicePluviometrico() {
        instance.setIndicePluviometrico(10);
        
        assertEquals(10, instance.getIndicePluviometrico());
    }

    @Test
    public void testSetIndicePluviometricoValorValido() {
        instance.setIndicePluviometrico(10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetIndicePluviometricoValorInvalido() {
        instance.setIndicePluviometrico(-10);
    }

    @Test
    public void testGetTemperatura() {
        instance.setTemperatura(10);
        
        assertEquals(10, instance.getTemperatura(), 0.0);
    }

    @Test
    public void testSetTemperatura() {
        instance.setTemperatura(10);
    }
}
