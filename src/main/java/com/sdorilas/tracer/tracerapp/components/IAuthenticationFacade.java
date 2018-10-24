package com.sdorilas.tracer.tracerapp.components;

import org.springframework.security.core.Authentication;

public interface IAuthenticationFacade {
	Authentication getAuthentication();
}
