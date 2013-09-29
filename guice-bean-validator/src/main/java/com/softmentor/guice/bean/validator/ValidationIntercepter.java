/**
 * Copyright (C) 2012-2013 InMobi Pvt. Ltd.
 * http://www.inmobi.com
 * http://www.inmobi.com/about-us/contact-us/
 * All rights reserved
 */

package com.softmentor.guice.bean.validator;

/**
 * @author abhinav.prakash
 */
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;

import lombok.extern.slf4j.Slf4j;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.google.inject.Inject;

@Slf4j
public class ValidationIntercepter implements MethodInterceptor {

	@Inject
	private ValidatorFactory validatorFactory;

	/**
	 * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
	 */
	@Override
	public Object invoke(final MethodInvocation invocation) throws Throwable {

		log.debug("Interceptor begin violations");
		ExecutableValidator executableValidator = validatorFactory
				.getValidator().forExecutables();

		Set<ConstraintViolation<Object>> violations = executableValidator
				.validateParameters(invocation.getThis(),
						invocation.getMethod(), invocation.getArguments());
		if (!violations.isEmpty()) {
			log.debug("Violations occurred on inputs --" + violations);
			// TODO: Not a good idea to throw something which is type of
			// RunTimeException.
			throw new ConstraintViolationException(violations);
		} else {
			log.debug("No Violations on inputs:-)");
		}
		
		Object result = invocation.proceed();
		// validate the return values if they have been annotated with any
		// constraints
		log.debug("Begin check violations for return value --");
		violations = executableValidator.validateReturnValue(
				invocation.getThis(), invocation.getMethod(), result);

		if (!violations.isEmpty()) {
			log.debug("Violations occurred on outputs --" + violations);
			throw new ConstraintViolationException(violations);
		} else {
			log.debug("No Violations on outputs:-)");
		}

		return result;

	}

}