package com.railway.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor
public class ErrorsGenerator {

    private final ObjectMapper objectMapper;

    public static final String EMPTY_ERRORS = """
                                               {
                                                   "errors": []
                                               }
                                               """;

    public <T> String generateErrors(Set<ConstraintViolation<T>> violations) {
        ObjectNode errorsNode = objectMapper.createObjectNode();
        ArrayNode errorsArray = errorsNode.putArray("errors");
        violations.forEach(violation -> errorsArray.add(violation.getMessage()));

        return errorsNode.toPrettyString();
    }

    public String generateErrors(List<String> errors) {
        ObjectNode errorsNode = objectMapper.createObjectNode();
        ArrayNode errorsArray = errorsNode.putArray("errors");
        errors.forEach(errorsArray::add);

        return errorsNode.toPrettyString();
    }

    public String generateSingleError(String error) {
        ObjectNode errorsNode = objectMapper.createObjectNode();
        ArrayNode errorsArray = errorsNode.putArray("errors");
        errorsArray.add(error);

        return errorsNode.toPrettyString();
    }

    public String generateErrorByStatus(HttpStatus status) {
        return generateSingleError(status.getReasonPhrase());
    }

}
