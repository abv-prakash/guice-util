package com.softmentor.guice.bean.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.softmentor.guice.bean.api.domain.SomeSimpleBean;
import com.softmentor.guice.bean.api.resource.ISomeResource;

/**
 * @author jiny
 *
 */
public interface ISomeApi {

	public void doWork();

	public void doWork1(String str1,@NotBlank String str2, @Valid SomeSimpleBean bean);

	public void doWork2(@Valid SomeSimpleBean bean);

	public void doWork3();

	public void doWork4();

}