package com.rekruttering.oppgave2;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rekruttering.oppgave1.Tabellkort;

@Path("forskudd")
public class ForskuddsberegningResource {

    @GET
    @Path("prosent")
    @Produces(MediaType.TEXT_PLAIN)
    public Response trekkprosentFraTabell(
        @QueryParam("bruttoloenn") int bruttoloenn) {
        return Response.ok(Tabellkort.hentProsenttrekkBasertPaaTabell(bruttoloenn)).build();
    }

    @GET
    @Path("nettoloennTabell")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response hentNetLoenn(@QueryParam("bruttoloenn") int bruttoloenn) {
        return Response.ok(Tabellkort.hentNettLoenn(bruttoloenn)).build();
    }



}
