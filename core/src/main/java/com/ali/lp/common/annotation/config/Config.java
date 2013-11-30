/**
* @{#} Config.java Created on 2010-8-16 下午11:04:14
*
* Copyright (c) 2010 by ZHONGBO software.
*/
package com.ali.lp.common.annotation.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author <a href="mailto:lizhe2@asiainfo-linkage.com">lizhe</a>
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Config {
    String value() default "";
}