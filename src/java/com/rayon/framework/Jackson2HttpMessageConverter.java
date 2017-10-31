package com.rayon.framework;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJacksonValue;

import java.io.IOException;

/**
 * Description:<br/>
 *
 * @author Rayon
 * @version 0.0.1
 * @date 2017/10/30
 * <p>
 * History:2017/10/30 Rayon 初始创建
 */
public class Jackson2HttpMessageConverter extends AbstractJackson2HttpMessageConverter {
    private String jsonPrefix;

    public Jackson2HttpMessageConverter() {
        this(buildMapper());
    }

    public Jackson2HttpMessageConverter(ObjectMapper objectMapper) {
        super(objectMapper, new MediaType[]{MediaType.APPLICATION_JSON_UTF8, new MediaType("application", "*+json", DEFAULT_CHARSET)});
    }

    private static ObjectMapper buildMapper(){
        ObjectMapper mapper = Jackson2ObjectMapperBuilder.json().build();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        mapper.registerModule(simpleModule);

        return mapper;
    }

    public void setJsonPrefix(String jsonPrefix) {
        this.jsonPrefix = jsonPrefix;
    }

    public void setPrefixJson(boolean prefixJson) {
        this.jsonPrefix = prefixJson?")]}\', ":null;
    }

    protected void writePrefix(JsonGenerator generator, Object object) throws IOException {
        if(this.jsonPrefix != null) {
            generator.writeRaw(this.jsonPrefix);
        }

        String jsonpFunction = object instanceof MappingJacksonValue ?((MappingJacksonValue)object).getJsonpFunction():null;
        if(jsonpFunction != null) {
            generator.writeRaw("/**/");
            generator.writeRaw(jsonpFunction + "(");
        }

    }

    protected void writeSuffix(JsonGenerator generator, Object object) throws IOException {
        String jsonpFunction = object instanceof MappingJacksonValue?((MappingJacksonValue)object).getJsonpFunction():null;
        if(jsonpFunction != null) {
            generator.writeRaw(");");
        }

    }
}
