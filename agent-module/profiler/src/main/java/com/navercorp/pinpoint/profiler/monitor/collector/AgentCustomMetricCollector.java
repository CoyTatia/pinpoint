/*
 * Copyright 2020 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.navercorp.pinpoint.profiler.monitor.collector;

import com.navercorp.pinpoint.profiler.context.monitor.metric.CustomMetricRegistryService;
import com.navercorp.pinpoint.profiler.context.monitor.metric.CustomMetricWrapper;
import com.navercorp.pinpoint.profiler.monitor.metric.AgentCustomMetricSnapshot;

import java.util.Map;
import java.util.Objects;

/**
 * @author Taejin Koo
 */
public class AgentCustomMetricCollector {

    private final CustomMetricRegistryService customMetricRegistryService;

    public AgentCustomMetricCollector(CustomMetricRegistryService customMetricRegistryService) {
        this.customMetricRegistryService = Objects.requireNonNull(customMetricRegistryService, "customMetricRegistryService");
    }

    public AgentCustomMetricSnapshot collect() {
        Map<String, CustomMetricWrapper> customMetricMap = customMetricRegistryService.getCustomMetricMap();

        int size = customMetricMap.size();

        AgentCustomMetricSnapshot agentCustomMetricSnapshot = new AgentCustomMetricSnapshot(size);
        for (CustomMetricWrapper metricWrapper : customMetricMap.values()) {
            agentCustomMetricSnapshot.add(metricWrapper.snapshot());
        }

        return agentCustomMetricSnapshot;
    }

}
