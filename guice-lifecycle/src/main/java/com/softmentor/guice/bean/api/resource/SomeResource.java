package com.softmentor.guice.bean.api.resource;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jiny
 *
 */
@Slf4j
public class SomeResource implements ISomeResource {

	public SomeResource(){
		
	}
	
	/* (non-Javadoc)
	 * @see com.softmentor.guice.bean.api.resource.ISomeResource#getData()
	 */
	@Override
	public SomeResourceData getData(){
		//call some thirdparty drivers/resources like file, db, kv cache etc and getData
		SomeResourceData someData = new SomeResourceData();
		log.debug("getData" + someData);
		//return data
		return someData;
	}
}
