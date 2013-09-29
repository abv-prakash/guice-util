package com.softmentor.guice.bean.test.api;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;

import lombok.extern.slf4j.Slf4j;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.softmentor.guice.bean.BaseTest;
import com.softmentor.guice.bean.api.ISomeApi;
import com.softmentor.guice.bean.api.domain.SomeSimpleBean;

/**
 * @author jiny
 * 
 */
@Slf4j
public class ApiTest extends BaseTest {
	@Inject
	SomeSimpleBean bean;

	@Inject
	ISomeApi api;

	public void initThisTest() {

		injector.injectMembers(this);
	}

	@Test
	public void testdoWork() {
		api.doWork();
	}

	@Test
	public void testdoWork1() {
		bean.setA("someA");
		bean.setB("someB");
		bean.setX(10);
		api.doWork1("valid", "validstr2", bean);
	}

	@Test
	public void testdoWork1Exception() {
		bean.setA("sA");
		bean.setB("something realling long on B");
		bean.setX(101);

		try {
			log.debug("Before doing the work");
			api.doWork1("valid", "validstr2", bean);

		} catch (ConstraintViolationException cve) {
			log.debug("Reached here test passed");
			assertThat("violations", cve.getConstraintViolations().size(),
					greaterThan(1));
			log.debug("Violations occurred are ----------- "
					+ cve.getConstraintViolations());

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unexpected Exception", e);
			log.debug("Reached here test failed");
		}
		log.debug("End test case");
	}
}
