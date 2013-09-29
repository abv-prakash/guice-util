package com.softmentor.guice.bean;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.google.common.collect.ImmutableList;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.netflix.governator.guice.BootstrapBinder;
import com.netflix.governator.guice.BootstrapModule;
import com.netflix.governator.guice.LifecycleInjector;
import com.netflix.governator.lifecycle.LifecycleManager;
import com.softmentor.guice.bean.api.module.SomeApiModule;
import com.softmentor.guice.bean.module.BeanValidatorModule;

/**
 * @author jiny
 * 
 */
public class BaseTest {

	public static Injector injector;
	public LifecycleManager manager;

	@BeforeSuite
	public void startSuite() throws Exception {
		Iterable<Module> modules = ImmutableList.<Module> builder()
				.add(new SomeApiModule()).build();
		BootstrapModule boostrapModule = new BootstrapModule() {
			
			@Override
			public void configure(BootstrapBinder binder) {
				binder.install(new BeanValidatorModule());
				
			}
		};
		injector = LifecycleInjector.builder()
				.withBootstrapModule(boostrapModule)
				.withModules(modules)
				.createInjector();
		// injector = Guice.createInjector(Stage.DEVELOPMENT, modules);
		manager = injector.getInstance(LifecycleManager.class);
		manager.start();
		injector.injectMembers(this);

	}

	@AfterSuite
	public void afterSuite() {
		manager.close();
	}

}
