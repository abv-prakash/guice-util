package com.softmentor.guice.bean.caller;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;

import lombok.extern.slf4j.Slf4j;

import com.softmentor.guice.bean.api.ISomeApi;
import com.softmentor.guice.bean.api.domain.SomeSimpleBean;

/**
 * @author jiny
 * 
 */
@Slf4j
public class ApiConsumer {

	public ISomeApi api;

	/**
	 * 
	 */
	@Inject
	public ApiConsumer(ISomeApi api) {
		// TODO Auto-generated constructor stub
		this.api = api;
	}

	public void consumeApi(SomeSimpleBean bean) {
		try {

			api.doWork1("str1", "Some long string", bean);
		} catch (ConstraintViolationException cve) {
			System.out.println("Violations -------"
					+ cve.getConstraintViolations());
			log.debug("Violations ------- " + cve.getMessage());

		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.debug("Finished consumer");
	}
}
