/**
 * Copyright (C) 2012-2013 InMobi Pvt. Ltd.
 * http://www.inmobi.com
 * http://www.inmobi.com/about-us/contact-us/
 * All rights reserved
 */

package com.softmentor.guice.bean.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Activates automatic method-level validation for any annotated bean.
 * 
 * @author abhinav.prakash
 * 
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoValidator {
}
