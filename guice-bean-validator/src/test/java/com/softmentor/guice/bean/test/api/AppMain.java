package com.softmentor.guice.bean.test.api;

import lombok.extern.slf4j.Slf4j;

import com.google.common.collect.ImmutableList;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Stage;
import com.softmentor.guice.bean.api.domain.SomeSimpleBean;
import com.softmentor.guice.bean.api.module.SomeModule;
import com.softmentor.guice.bean.caller.ApiConsumer;
import com.softmentor.guice.bean.module.BeanValidatorModule;

/**
 * @author jiny
 * 
 */
@Slf4j
public class AppMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Iterable<Module> modules = ImmutableList.<Module> builder()
				.add(new BeanValidatorModule()).add(new SomeModule()).build();
		// injector =
		// LifecycleInjector.builder().withModules(modules).createInjector();
		Injector injector = Guice.createInjector(Stage.DEVELOPMENT, modules);
		ApiConsumer apiCaller = injector.getInstance(ApiConsumer.class);
		SomeSimpleBean bean = new SomeSimpleBean();
		bean.setA("sA");
		bean.setB("something realling long on B");
		bean.setX(101);
		log.debug("Calling consumer..........");
		apiCaller.consumeApi(bean);
	}

}
