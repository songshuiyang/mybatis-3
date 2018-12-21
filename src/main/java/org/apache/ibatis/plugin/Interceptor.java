/*
 *    Copyright 2009-2012 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.plugin;

import java.util.Properties;

/**
 * 拦截器
 * @author Clinton Begin
 */
public interface Interceptor {

  // 在这里完成拦截操作
  Object intercept(Invocation invocation) throws Throwable;

  // 用于封装目标对象，我们可以决定是否要进行拦截进而决定要返回一个什么样的目标对象
  Object plugin(Object target);

  // 用于在Mybatis配置文件中指定一些属性的。
  void setProperties(Properties properties);

}
