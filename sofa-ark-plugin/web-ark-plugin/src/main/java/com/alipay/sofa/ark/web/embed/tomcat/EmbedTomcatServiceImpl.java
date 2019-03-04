/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.sofa.ark.web.embed.tomcat;

import com.alipay.sofa.ark.spi.web.EmbedTomcatService;
import org.apache.catalina.startup.Tomcat;

/**
 * This implementation would be published as ark service.
 *
 * @author qilong.zql
 * @since 0.6.0
 */
public class EmbedTomcatServiceImpl implements EmbedTomcatService {
    private Tomcat tomcat;
    private Object lock = new Object();

    @Override
    public Tomcat getEmbedTomcat() {
        return tomcat;
    }

    @Override
    public void setEmbedTomcat(Tomcat tomcat) {
        if (this.tomcat == null) {
            synchronized (lock) {
                if (this.tomcat == null) {
                    this.tomcat = tomcat;
                }
            }
        }
    }
}