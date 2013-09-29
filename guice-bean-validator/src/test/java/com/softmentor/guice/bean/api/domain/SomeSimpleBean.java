package com.softmentor.guice.bean.api.domain;

import javax.validation.constraints.Max;

import lombok.Data;

import org.hibernate.validator.constraints.Length;

/**
 * @author jiny
 * 
 */
@Data
public class SomeSimpleBean {

	@Length(min = 3)
	String a;

	@Length(max = 10)
	String b;

	@Max(100)
	int x;

}
