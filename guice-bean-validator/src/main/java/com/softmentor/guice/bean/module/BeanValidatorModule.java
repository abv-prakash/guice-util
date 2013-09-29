package com.softmentor.guice.bean.module;

import javax.inject.Singleton;
import javax.validation.ValidatorFactory;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.matcher.Matchers;
import com.softmentor.guice.bean.validator.AutoValidator;
import com.softmentor.guice.bean.validator.ValidationIntercepter;
import com.softmentor.guice.bean.validator.ValidatorFactoryProvider;

/**
 * @author jiny
 *
 */
public class BeanValidatorModule implements Module {

	/* (non-Javadoc)
	 * @see com.google.inject.Module#configure(com.google.inject.Binder)
	 */
	@Override
	public void configure(Binder binder) {
		// TODO Auto-generated method stub
		// bind all validators and annotations for validations
	      binder.bind(ValidatorFactory.class).toProvider(ValidatorFactoryProvider.class).in(Singleton.class);
	      ValidationIntercepter validationInterceptor = new ValidationIntercepter();
	      binder.requestInjection(validationInterceptor);
	      binder.bindInterceptor(Matchers.annotatedWith(AutoValidator.class), Matchers.any(),
	          validationInterceptor);
		
	}

}
