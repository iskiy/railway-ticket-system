package com.railway.model.utils;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import static java.util.Arrays.asList;

@Getter
@Setter
@AllArgsConstructor
public class RestErrorList extends ArrayList<ErrorMessage> {

	private static final long serialVersionUID = -721424777198115589L;
	private HttpStatus status;

	public RestErrorList(HttpStatus status, ErrorMessage... errors) {
		this(status.value(), errors);
	}

	public RestErrorList(int status, ErrorMessage... errors) {
		super();
		this.status = HttpStatus.valueOf(status);
		addAll(asList(errors));
	}
}