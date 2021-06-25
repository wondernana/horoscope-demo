package dbproject;

import org.junit.Test;

import java.time.MonthDay;

import static org.junit.Assert.assertEquals;

public class ZodiacCalculationTests {
        @Test
        // проверяет определение знака зодиака по граничным значениям начала периода
       public void testCalculationByStartDate() {
            User aqua = new User("Lana", "Banana", MonthDay.of(1, 21));
            aqua.calculateZodiacSign();
            assert (aqua.getZodiac().equals(ZodiacSigns.AQUARIUS));
            User pics = new User("Lana", "Banana", MonthDay.of(2, 19));
            pics.calculateZodiacSign();
            assert (pics.getZodiac().equals(ZodiacSigns.PISCES));
            User ari = new User("Lana", "Banana", MonthDay.of(3, 21));
            ari.calculateZodiacSign();
            assert (ari.getZodiac().equals(ZodiacSigns.ARIES));
            User taur = new User("Lana", "Banana", MonthDay.of(4, 21));
            taur.calculateZodiacSign();
            assert (taur.getZodiac().equals(ZodiacSigns.TAURUS));
            User gem = new User("Lana", "Banana", MonthDay.of(5, 21));
            gem.calculateZodiacSign();
            assert (gem.getZodiac().equals(ZodiacSigns.GEMINI));
            User canc = new User("Lana", "Banana", MonthDay.of(6, 22));
            canc.calculateZodiacSign();
            assert (canc.getZodiac().equals(ZodiacSigns.CANCER));
            User leo = new User("Lana", "Banana", MonthDay.of(7, 23));
            leo.calculateZodiacSign();
            assert (leo.getZodiac().equals(ZodiacSigns.LEO));
            User virgo = new User("Lana", "Banana", MonthDay.of(8, 24));
            virgo.calculateZodiacSign();
            assert (virgo.getZodiac().equals(ZodiacSigns.VIRGO));
            User lib = new User("Lana", "Banana", MonthDay.of(9, 24));
            lib.calculateZodiacSign();
            assert (lib.getZodiac().equals(ZodiacSigns.LIBRA));
            User scorp = new User("Lana", "Banana", MonthDay.of(10, 24));
            scorp.calculateZodiacSign();
            assert (scorp.getZodiac().equals(ZodiacSigns.SCORPIO));
            User sag = new User("Lana", "Banana", MonthDay.of(11, 23));
            sag.calculateZodiacSign();
            System.out.println(sag.getZodiac());
            assert (sag.getZodiac().equals(ZodiacSigns.SAGITTARIUS));
            User capr = new User("Lana", "Banana", MonthDay.of(12, 22));
            capr.calculateZodiacSign();
            assert (capr.getZodiac().equals(ZodiacSigns.CAPRICORN));
            // + граничные для Козерога:
            User capr2 = new User("Lana", "Banana", MonthDay.of(12, 31));
            capr2.calculateZodiacSign();
            assert (capr2.getZodiac().equals(ZodiacSigns.CAPRICORN));
            User capr3 = new User("Lana", "Banana", MonthDay.of(1, 1));
            capr3.calculateZodiacSign();
            assertEquals(capr3.getZodiac(),ZodiacSigns.CAPRICORN);
        }
    @Test
        // проверяет определение знака зодиака по граничным значениям конца периода
   public void testCalculationByEndDate() {
        User aqua = new User("Lana", "Banana", MonthDay.of(2, 18));
        aqua.calculateZodiacSign();
        assert (aqua.getZodiac().equals(ZodiacSigns.AQUARIUS));
        User pics = new User("Lana", "Banana", MonthDay.of(3, 20));
        pics.calculateZodiacSign();
        assert (pics.getZodiac().equals(ZodiacSigns.PISCES));
        User ari = new User("Lana", "Banana", MonthDay.of(4, 20));
        ari.calculateZodiacSign();
        assert (ari.getZodiac().equals(ZodiacSigns.ARIES));
        User taur = new User("Lana", "Banana", MonthDay.of(5, 20));
        taur.calculateZodiacSign();
        assert (taur.getZodiac().equals(ZodiacSigns.TAURUS));
        User gem = new User("Lana", "Banana", MonthDay.of(6, 21));
        gem.calculateZodiacSign();
        assert (gem.getZodiac().equals(ZodiacSigns.GEMINI));
        User canc = new User("Lana", "Banana", MonthDay.of(7, 22));
        canc.calculateZodiacSign();
        assert (canc.getZodiac().equals(ZodiacSigns.CANCER));
        User leo = new User("Lana", "Banana", MonthDay.of(8, 23));
        leo.calculateZodiacSign();
        assert (leo.getZodiac().equals(ZodiacSigns.LEO));
        User virgo = new User("Lana", "Banana", MonthDay.of(9, 23));
        virgo.calculateZodiacSign();
        assert (virgo.getZodiac().equals(ZodiacSigns.VIRGO));
        User lib = new User("Lana", "Banana", MonthDay.of(10, 23));
        lib.calculateZodiacSign();
        assert (lib.getZodiac().equals(ZodiacSigns.LIBRA));
        User scorp = new User("Lana", "Banana", MonthDay.of(11, 22));
        scorp.calculateZodiacSign();
        assert (scorp.getZodiac().equals(ZodiacSigns.SCORPIO));
        User sag = new User("Lana", "Banana", MonthDay.of(12, 21));
        sag.calculateZodiacSign();
        System.out.println(sag.getZodiac());
        assert (sag.getZodiac().equals(ZodiacSigns.SAGITTARIUS));
        User capr = new User("Lana", "Banana", MonthDay.of(1, 20));
        capr.calculateZodiacSign();
        assert (capr.getZodiac().equals(ZodiacSigns.CAPRICORN));
    }
}
