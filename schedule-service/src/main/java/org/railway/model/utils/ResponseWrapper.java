package org.railway.model.utils;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(NON_NULL)
@Getter
@Setter
@AllArgsConstructor
public class ResponseWrapper {

    private Object data;
    private Object metadata;
    private List<ErrorMessage> errors;
}
