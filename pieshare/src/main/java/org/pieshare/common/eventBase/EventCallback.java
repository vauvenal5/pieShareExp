/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.common.eventBase;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author vauve_000
 */
@Target(value={ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EventCallback
{	
	Class eventClass();
	Class sourceClass() default Class.class;
}
