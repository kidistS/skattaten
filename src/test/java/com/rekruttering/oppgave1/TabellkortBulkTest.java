package com.rekruttering.oppgave1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class TabellkortBulkTest {

    @Ignore("TODO: implementer Tabellkort.flereProsenttrekkBasertPaaTabell")
    @Test
    public void flere_prosenttrekk_for_liste_med_bruttoloenn() {
        List<Integer> bulkBruttoloenn = Arrays.asList(500_000, 1, 800_000);
        List<Integer> resultatProsenttrekk = Tabellkort.flereProsenttrekkBasertPaaTabell(bulkBruttoloenn);
        assertThat(resultatProsenttrekk).containsExactly(32, 5, 45);
    }
}
