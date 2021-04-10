package com.mohit.messenger.exceptions;

import com.mohit.messenger.model.ErrorMessage;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;

//@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 500, null);
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				       .entity(errorMessage)
					   .build();
	}

}