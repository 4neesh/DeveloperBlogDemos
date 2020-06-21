package com.aneesh.rest;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class ToDoDeserialiser extends JsonDeserializer {

    @Override
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        int userId = node.get("userId").intValue();
        int id = node.get("id").intValue();
        String title = node.get("title").textValue();
        boolean completed = node.get("completed").asBoolean();
        String isCompleted = completed ? "Is Completed" : "Not Completed";
        return new ToDo(userId, id, title, isCompleted);
    }
    
}
