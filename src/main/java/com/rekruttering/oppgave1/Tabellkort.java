package com.rekruttering.oppgave1;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

@Slf4j
public class Tabellkort {

    private static NavigableMap<Integer, Integer> map = new TreeMap<>();

    static {
        map.put(1, 5);
        map.put(100_000, 10);
        map.put(200_000, 20);
        map.put(300_000, 25);
        map.put(400_000, 30);
        map.put(500_000, 32);
        map.put(600_000, 37);
        map.put(700_000, 40);
        map.put(800_000, 45);
    }

    public static int hentProsenttrekkBasertPaaTabell(int bruttoLoenn) {
        if (bruttoLoenn <= 0){
            throw new RuntimeException("Bruttoloenn " + bruttoLoenn + "ikke en gyldig verdi");
        }

        return map.floorEntry(bruttoLoenn).getValue();
    }

    // B
    public static int hentSkalttBesartPoBruttoloeanOgpersont(int bruttoLoenn, int persont) {
        if (bruttoLoenn <= 0 ||  persont <= 0){
            throw new RuntimeException("bruttoLoenn eller persont verdig ikke gitt ");
        }
        int tekke = (bruttoLoenn - (bruttoLoenn - ((bruttoLoenn * persont))/100));
        return tekke;
    }
    // D
    public static int hentTrekkBasertPaaTabell(int bruttoLoenn) {
        if (bruttoLoenn <= 0){
            throw new RuntimeException("Bruttoloenn " + bruttoLoenn + "ikke en gyldig verdi");
        }
        int persont = map.floorEntry(bruttoLoenn).getValue();
        int tekke = (bruttoLoenn - (bruttoLoenn - ((bruttoLoenn * persont))/100));
        return tekke;
    }

    // C
    public static int hentNettLoenn(int bruttoLoenn) {
        if (bruttoLoenn <= 0){
            throw new RuntimeException("Bruttoloenn " + bruttoLoenn + "ikke en gyldig verdi");
        }
        int persont = map.floorEntry(bruttoLoenn).getValue();
        int netLoenn = (bruttoLoenn - ((bruttoLoenn * persont)/100));
        return netLoenn;
    }
//  E

    public static List<Integer> flereProsenttrekkBasertPaaTabell(List<Integer> flereBrutoloenn){
        if (flereBrutoloenn.isEmpty()){
            throw new RuntimeException("Bruttoloenn er ikke gitt" );
        }
        log.info("I flereProsenttrekkBasertPaaTabell method....");
        List<Integer> flerePersonter = new ArrayList<>();
        for (Integer bruttlolenn: flereBrutoloenn){
            flerePersonter.add(map.floorEntry(bruttlolenn).getValue());
        }
     return flerePersonter;

    }
}
