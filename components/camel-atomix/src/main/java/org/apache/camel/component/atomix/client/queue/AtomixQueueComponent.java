/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.atomix.client.queue;

import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.component.atomix.client.AbstractAtomixClientComponent;

public final class AtomixQueueComponent extends AbstractAtomixClientComponent<AtomixQueueConfiguration> {
    private AtomixQueueConfiguration configuration = new AtomixQueueConfiguration();

    public AtomixQueueComponent() {
        super();
    }

    public AtomixQueueComponent(CamelContext camelContext) {
        super(camelContext);
    }

    @Override
    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        AtomixQueueConfiguration configuration = this.configuration.copy();

        // Bind options to the configuration object
        setConfigurationProperties(configuration, parameters);

        AtomixQueueEndpoint endpoint = new AtomixQueueEndpoint(uri, this, remaining);
        endpoint.setConfiguration(configuration);

        setProperties(endpoint, parameters);

        return endpoint;
    }

    // **********************************************
    // Properties
    // **********************************************

    public AtomixQueueConfiguration getConfiguration() {
        return this.configuration;
    }

    /**
     * The shared component configuration
     */
    public void setConfiguration(AtomixQueueConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    protected AtomixQueueConfiguration getComponentConfiguration() {
        return getConfiguration();
    }
}
