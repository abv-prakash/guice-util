package com.softmentor.guice.bean.api;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;

import lombok.extern.slf4j.Slf4j;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.softmentor.guice.bean.BaseTest;
import com.softmentor.guice.bean.api.domain.SomeSimpleBean;

@Slf4j
public class ISomeApiTest extends BaseTest {
	@Inject
	ISomeApi api;

	@BeforeClass
	public void beforeClass() {
		injector.injectMembers(this);
	}

	@AfterClass
	public void afterClass() {
	}

	@Test
	public void doWork() {
		api.doWork();
	}

	@Test(groups="sanity")
	public void doWork1() {
		SomeSimpleBean bean = injector.getInstance(SomeSimpleBean.class);
		bean.setA("someA");
		bean.setB("someB");
		bean.setX(10);
		api.doWork1("valid", "validstr2", bean);
		
	}
	
	@Test(groups={"sanity", "negative"}, expectedExceptions = ConstraintViolationException.class)
	public void doWork1_Exception1() {
		SomeSimpleBean bean = injector.getInstance(SomeSimpleBean.class);
		bean.setA("someA");
		bean.setB("something");
		bean.setX(101);
		try {
			log.debug("Before doing the work");
			api.doWork1("valid", "validstr2", bean);

		} catch (ConstraintViolationException cve) {
			log.debug("Boom violations caught");
			assertThat("violations", cve.getConstraintViolations().size(),
					greaterThanOrEqualTo(1));
			log.debug("Violations occurred are ----------- "
					+ cve.getConstraintViolations());
			throw cve;

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unexpected Exception", e);
			log.debug("Reached here test failed");
			throw e;
		}
		
	}

	@Test
	public void doWork2() {
		SomeSimpleBean bean = injector.getInstance(SomeSimpleBean.class);
		bean.setA("someA");
		bean.setB("someB");
		bean.setX(10);
		api.doWork2(bean);
	}

	@Test
	public void doWork3() {
		api.doWork3();
	}

	@Test
	public void doWork4() {
		api.doWork4();
	}
}
