package com.softmentor.guice.bean;

import org.testng.annotations.BeforeSuite;

import com.google.common.collect.ImmutableList;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Stage;
import com.softmentor.guice.bean.api.module.SomeModule;
import com.softmentor.guice.bean.module.BeanValidatorModule;

/**
 * @author jiny
 *
 */
public class BaseTest {
	
	public static Injector injector;
	
	@BeforeSuite
	public void startSuite(){
		Iterable<Module> modules = ImmutableList.<Module>builder()
										.add(new BeanValidatorModule())
										.add(new SomeModule()).build();
	    // injector = LifecycleInjector.builder().withModules(modules).createInjector();
	    injector = Guice.createInjector(Stage.DEVELOPMENT, modules);
	    injector.injectMembers(this);
		
	}

}
