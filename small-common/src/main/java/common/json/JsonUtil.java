package common.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.TimeZone;

/**
 * Created by tianwenyuan on 2016/6/13.
 */
public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.setTimeZone(TimeZone.getDefault());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
    }

    public static <T> T parseObject(String value, Class<T> type) {
        try {
            return objectMapper.readValue(value, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T parseObject(String value, TypeReference<T> typeReference) {
        try {
            return objectMapper.readValue(value, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String toJsonString(Object object){
        StringWriter stringWriter = new StringWriter();
        try {
            objectMapper.writeValue(stringWriter,object);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringWriter.toString();
    }

}
