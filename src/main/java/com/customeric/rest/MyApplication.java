/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customeric.rest;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author ranjanp1
 */
public class MyApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
         Set<Class<?>> s = new HashSet<Class<?>>();
          s.add(HelloWorldResource.class);
          s.add(HelloWorldResourceMobile.class);
          return s;
      }
  }
