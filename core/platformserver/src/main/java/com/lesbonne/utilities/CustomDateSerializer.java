package com.lesbonne.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * java date object transfers to JSON date format through Jackson library
 * 
 * @author jassica
 *
 */
public class CustomDateSerializer extends JsonSerializer<Date>{

    @Override
    public void serialize(Date value, JsonGenerator gen,
            SerializerProvider serializers) throws IOException,
            JsonProcessingException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = formatter.format(value);
        gen.writeString(formattedDate);
    }
    
}
