package com.softmentor.guice.bean.api.impl;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.extern.slf4j.Slf4j;

import org.hibernate.validator.constraints.NotBlank;

import com.softmentor.guice.bean.api.ISomeApi;
import com.softmentor.guice.bean.api.domain.SomeSimpleBean;
import com.softmentor.guice.bean.validator.AutoValidator;

/**
 * @author jiny
 *
 */
@Slf4j
@AutoValidator
public class SomeApi implements ISomeApi {
	
	/* (non-Javadoc)
	 * @see com.softmentor.guice.bean.api.ISomeApi#doWork()
	 */
	public void doWork(){
		log.debug("Doing work - doWork");
	}
	
	/* (non-Javadoc)
	 * @see com.softmentor.guice.bean.api.ISomeApi#doWork1(java.lang.String, java.lang.String, com.softmentor.guice.bean.api.SomeSimpleBean)
	 */
	public void doWork1(String str1,String str2,SomeSimpleBean bean){
		log.debug("Doing work - doWork1");
	}
	
	/* (non-Javadoc)
	 * @see com.softmentor.guice.bean.api.ISomeApi#doWork2(com.softmentor.guice.bean.api.SomeSimpleBean)
	 */
	public void doWork2(SomeSimpleBean bean){
		log.debug("Doing work - doWork2");
	}
	
	/* (non-Javadoc)
	 * @see com.softmentor.guice.bean.api.ISomeApi#doWork3()
	 */
	public void doWork3(){
		log.debug("Doing work - doWork3");
	}
	
	/* (non-Javadoc)
	 * @see com.softmentor.guice.bean.api.ISomeApi#doWork4()
	 */
	public void doWork4(){
		log.debug("Doing work - doWork4");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
