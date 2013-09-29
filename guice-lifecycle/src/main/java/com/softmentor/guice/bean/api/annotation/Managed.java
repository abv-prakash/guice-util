package com.softmentor.guice.bean.api.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import javax.inject.Qualifier;

/**
 * Annotation to indicate a managed resource.
 *
 * <p>Example usage:
 *
 * <pre>
 *   public class Car {
 *     &#064;Inject <b>@Managed</b> Fuel resourceFuel;
 *     ...
 *   }</pre>
 *   
 *   @author jiny
 */
@Qualifier
@Documented
@Retention(RUNTIME)
public @interface Managed {

}
