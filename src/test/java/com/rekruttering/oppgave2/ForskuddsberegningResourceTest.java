package com.rekruttering.oppgave2;

import static org.assertj.core.api.Assertions.assertThat;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Ignore;
import org.junit.Test;

public class ForskuddsberegningResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig() {
            {
                register(new ForskuddsberegningResource());
            }
        };
    }

    @Test
    public void skal_levere_trekkprosent_fra_tabell() {
        String resultat = target("forskudd/prosent")
            .queryParam("bruttoloenn", 500_000)
            .request().get(String.class);

        assertThat(resultat).isEqualTo("32");
    }

    @Ignore("TODO: implementer endepunktet for nettoloennTabell")
    @Test
    public void skal_beregne_nettoloenn_med_tabell() {
        String resultat = target("forskudd/nettoloennTabell")
            .queryParam("bruttoloenn", 500_000)
            .request().get(String.class);

        assertThat(resultat).isEqualTo("340000");
    }
}
