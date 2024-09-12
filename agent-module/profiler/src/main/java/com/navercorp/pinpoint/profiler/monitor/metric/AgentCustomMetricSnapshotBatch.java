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

package com.navercorp.pinpoint.profiler.monitor.metric;

import java.util.List;
import java.util.Objects;

/**
 * @author Taejin Koo
 */
public class AgentCustomMetricSnapshotBatch implements MetricType {

    private final List<AgentCustomMetricSnapshot> agentCustomMetricSnapshotList;

    public AgentCustomMetricSnapshotBatch(List<AgentCustomMetricSnapshot> agentCustomMetricSnapshotList) {
        this.agentCustomMetricSnapshotList = Objects.requireNonNull(agentCustomMetricSnapshotList, "agentCustomMetricSnapshotList");
    }

    public List<AgentCustomMetricSnapshot> getAgentCustomMetricSnapshotList() {
        return agentCustomMetricSnapshotList;
    }

    @Override
    public String toString() {
        return "AgentCustomMetricSnapshotBatch{" +
            "agentCustomMetricSnapshotList=" + agentCustomMetricSnapshotList +
            '}';
    }

}
