package dbproject;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class Horoscope {
    ZodiacSigns zodiacSign;
    Map<ZodiacSigns, String> predictionsMap = new EnumMap<ZodiacSigns, String>(ZodiacSigns.class);

    public Horoscope(ZodiacSigns zodiacSign) {
        fillMap();
        this.zodiacSign = zodiacSign;
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Horoscope horoscope = (Horoscope) o;
//        return zodiacSign == horoscope.zodiacSign && predictionsMap.equals(horoscope.predictionsMap);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(zodiacSign, predictionsMap);
//    }

    private void fillMap() {
        if (predictionsMap.isEmpty()) {
            predictionsMap.put(ZodiacSigns.AQUARIUS, "Taking other people's opinions into consideration is usually the last item on your list of priorities, and that goes double when it comes to a very new and very exciting person in your life.");
            predictionsMap.put(ZodiacSigns.ARIES, "Feel like you're tripping over your own tongue? That's not surprising, considering the constant flow of verbosity that's spilling forth from you right now. Go ahead and enjoy your extreme eloquence -- everyone else is.");
            predictionsMap.put(ZodiacSigns.CANCER, "For the first time in a very long time, you're listening only to one authority -- yourself. This is especially true regarding a social matter. You've been worried far too long about doing the right thing. Now it's time to do right by you.");
            predictionsMap.put(ZodiacSigns.CAPRICORN, "Put the kibosh on anyone who's absolutely determined to make sure even the smallest things go haywire. With a little extra care, you can defuse this live wire before they make life any more difficult than it is.");
            predictionsMap.put(ZodiacSigns.GEMINI, "From you, a wink and a smile go beyond a thousand words -- they're practically an entire romantic saga. Your flirty energy livens things up wherever you go right now, so make sure that as many people as possible can appreciate your fabulous self.");
            predictionsMap.put(ZodiacSigns.LEO, "You may feel ready to move into a decisive new leadership role, but the stars say to let things gestate for a little while longer before you make your big move. Try talking things over with your boon companions and hear what they have to say.");
            predictionsMap.put(ZodiacSigns.LIBRA, "You love watching this new scenario unfold in your life, but suddenly watching it isn't enough. You want -- no, you need -- to take action, but you're not sure which way to turn. Take a moment and look before you leap.");
            predictionsMap.put(ZodiacSigns.PISCES, "Learn to deal with ambiguity by letting it exist, rather than trying to make it go away. If you act too rapidly, you might just find that the solution becomes a much larger problem than the original situation.");
            predictionsMap.put(ZodiacSigns.SAGITTARIUS, "Having this much activity going on around you can be somewhat unsettling, but don't sulk. Just because something seems out of sync doesn't mean it'll be that way permanently. Wait it out and you'll feel things start to jell.");
            predictionsMap.put(ZodiacSigns.SCORPIO, "Minor details could become major mistakes if they're left unchecked, but fortunately, there's plenty of time to check everything. Not only will this ensure your enterprise will go swimmingly, but it'll give you some much-needed peace of mind.");
            predictionsMap.put(ZodiacSigns.TAURUS, "Stay in the now rather than trying to jump forward into the future. You'll do best when you focus your attention on all the immediate details that require your assistance. Remember that, no matter how tempting it is to start booking yourself weeks in advance.");
            predictionsMap.put(ZodiacSigns.VIRGO, "Don't try to do more than you can comfortably handle -- and make sure you're very clear about your limits if others try to ask you to take more on. When possible, lighten your load rather than add more to it.");
        }
    }

    public String showPrediction() {
       return predictionsMap.get(zodiacSign);
    }
}
