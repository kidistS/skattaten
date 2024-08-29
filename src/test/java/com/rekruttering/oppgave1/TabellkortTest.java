package com.rekruttering.oppgave1;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class TabellkortTest {

    @Test
    public void skal_returnere_riktig_tabelltrekk_avhengig_av_bruttoloenn() {
        assertThat(Tabellkort.hentProsenttrekkBasertPaaTabell(1)).isEqualTo(5);
        assertThat(Tabellkort.hentProsenttrekkBasertPaaTabell(500_000)).isEqualTo(32);
        assertThat(Tabellkort.hentProsenttrekkBasertPaaTabell(800_000)).isEqualTo(45);
        assertThat(Tabellkort.hentProsenttrekkBasertPaaTabell(2_000_000)).isEqualTo(45);
    }

    @Test
    public void skal_feile_ved_negativ_loenn() {
        Assertions.assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> Tabellkort.hentProsenttrekkBasertPaaTabell(-1));
    }
}