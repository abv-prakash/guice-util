package com.softmentor.guice.bean.api.module;

import com.google.inject.AbstractModule;
import com.softmentor.guice.bean.api.ISomeApi;
import com.softmentor.guice.bean.api.annotation.Managed;
import com.softmentor.guice.bean.api.domain.SomeSimpleBean;
import com.softmentor.guice.bean.api.impl.SomeApi;
import com.softmentor.guice.bean.api.resource.ISomeResource;
import com.softmentor.guice.bean.api.resource.SomeManagedResource;
import com.softmentor.guice.bean.api.resource.SomeResource;
import com.softmentor.guice.bean.api.resource.SomeResourceData;

/**
 * @author jiny
 *
 */
public class SomeApiModule extends AbstractModule{

	/* (non-Javadoc)
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		bind(SomeSimpleBean.class);
		bind(SomeResourceData.class);
		bind(ISomeApi.class).to(SomeApi.class).asEagerSingleton();
		bind(ISomeResource.class).annotatedWith(Managed.class).to(SomeManagedResource.class);
		bind(ISomeResource.class).to(SomeResource.class);
	}

}
