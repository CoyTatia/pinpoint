/*
 * Copyright 2018 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.navercorp.pinpoint.it.plugin.rabbitmq;

import com.navercorp.pinpoint.it.plugin.utils.AgentPath;
import com.navercorp.pinpoint.it.plugin.utils.TestcontainersOption;
import com.navercorp.pinpoint.test.plugin.Dependency;
import com.navercorp.pinpoint.test.plugin.PinpointAgent;
import com.navercorp.pinpoint.test.plugin.PinpointConfig;
import com.navercorp.pinpoint.test.plugin.PluginTest;
import com.navercorp.pinpoint.test.plugin.shared.SharedDependency;
import com.navercorp.pinpoint.test.plugin.shared.SharedTestLifeCycleClass;
import org.junit.jupiter.api.Test;

/**
 * @author Jiaqi Feng
 * @author HyunGil Jeong
 */
@PluginTest
@PinpointAgent(AgentPath.PATH)
@PinpointConfig("rabbitmq/client/pinpoint-rabbitmq.config")
@Dependency({"com.rabbitmq:amqp-client:[2.7.0,3.0.0)", "org.apache.qpid:qpid-broker:6.1.1"})
@SharedDependency({TestcontainersOption.TEST_CONTAINER, TestcontainersOption.RABBITMQ})
@SharedTestLifeCycleClass(TestBrokerServer.class)
public class RabbitMQClient_2_7_0_to_3_3_0_IT extends RabbitMQClientITBase {

    @Test
    public void testPush() throws Exception {
        testRunner.runPushTest();
    }

    @Test
    public void testPull() throws Exception {
        testRunner.runPullTest();
    }
}
