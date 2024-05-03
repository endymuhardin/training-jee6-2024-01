package com.muhardin.endy.training.jee6.controller.rest;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonDateTimeProvider implements ContextResolver<ObjectMapper> {

    private final ObjectMapper json;

    public JacksonDateTimeProvider() throws Exception {
        this.json = JsonMapper.builder()
                .findAndAddModules()
                .build();
    }

    @Override
    public ObjectMapper getContext(Class<?> objectType) {
        return json;
    }
}
