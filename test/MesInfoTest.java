/* 
 *
 * - Alan Felipe Jantz 
 * - Caroline Belli Regalin
 * - Matheus Mahnke
 *
*/

import java.nio.file.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MesInfoTest {
    
    @Test(expected = IllegalArgumentException.class)
    public void testGerarRelatorioMesComCaminhoNulo() throws Exception {
        String result = new MesInfo().gerarRelatorioMes(null);
    }
    
}
