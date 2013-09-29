package com.softmentor.guice.bean.api.module;

import com.google.inject.AbstractModule;
import com.softmentor.guice.bean.api.ISomeApi;
import com.softmentor.guice.bean.api.domain.SomeSimpleBean;
import com.softmentor.guice.bean.api.impl.SomeApi;
import com.softmentor.guice.bean.caller.ApiConsumer;

/**
 * @author jiny
 *
 */
public class SomeModule extends AbstractModule{

	/* (non-Javadoc)
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		bind(SomeSimpleBean.class);
		bind(ISomeApi.class).to(SomeApi.class).asEagerSingleton();
		bind(ApiConsumer.class);
		
	}

}
