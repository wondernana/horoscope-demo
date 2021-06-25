package dbproject;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShowPredictionTests {
    @Test
    //проверяет, что  для каждого знака зодиака (ключа) возвращается соотвествующий ему прогноз (значение)
    public void testShowPrediction(){
        for (ZodiacSigns z : ZodiacSigns.values()) {
            Horoscope test = new Horoscope(z);
            assertEquals(test.predictionsMap.get(z), test.showPrediction());
        }
    }
}
