package com.softmentor.guice.bean.api.resource;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jiny
 * 
 */
@Slf4j
public class SomeManagedResource implements ISomeResource {

	private boolean postConstuctInvoked;
	private boolean preDestroyInvoked;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.softmentor.guice.bean.api.resource.ISomeResource#getData()
	 */
	@Override
	public SomeResourceData getData() {
		// call some thirdparty drivers/resources like file, db, kv cache etc
		// and getData
		SomeResourceData someData = new SomeResourceData();
		log.debug("getData" + someData);
		// return data
		return someData;
	}

	@PostConstruct
	protected void start() {
		postConstuctInvoked = true;
	}

	@PreDestroy
	protected void close() {
		preDestroyInvoked = true;
	}

	public boolean isPostConstuctInvoked() {
		return postConstuctInvoked;
	}

	public boolean isPreDestroyInvoked() {
		return preDestroyInvoked;
	}

}
