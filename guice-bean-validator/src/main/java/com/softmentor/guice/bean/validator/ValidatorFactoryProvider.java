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
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import com.google.inject.Provider;

public class ValidatorFactoryProvider implements Provider<ValidatorFactory> {

  @Override
  public ValidatorFactory get() {
    return Validation.buildDefaultValidatorFactory();
  }

}