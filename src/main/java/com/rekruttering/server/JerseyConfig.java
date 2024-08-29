package com.rekruttering.server;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.rekruttering.oppgave2.ForskuddsberegningResource;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(ForskuddsberegningResource.class);
        register(CORSResponseFilter.class);
    }

    public static class CORSResponseFilter implements ContainerResponseFilter {
        public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
            MultivaluedMap<String, Object> headers = responseContext.getHeaders();

            headers.add("Access-Control-Allow-Origin", "*");
            headers.add("Access-Control-Allow-Methods", "GET");
            headers.add("Access-Control-Allow-Headers", "Content-Type");
        }
    }
}