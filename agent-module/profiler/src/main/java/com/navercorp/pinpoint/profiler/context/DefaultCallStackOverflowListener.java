/*
 * Copyright 2022 NAVER Corp.
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

package com.navercorp.pinpoint.profiler.context;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DefaultCallStackOverflowListener implements CallStackOverflowListener {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private final boolean isInfo = logger.isInfoEnabled();

    private final int maxDepth;
    private final int maxSequence;

    public DefaultCallStackOverflowListener(final int maxDepth, final int maxSequence) {
        this.maxDepth = maxDepth;
        this.maxSequence = maxSequence;
    }

    @Override
    public void fireOverflow(final int callStackIndex) {
        if (isInfo) {
            logger.info("CallStack maximum depth/sequence exceeded. Check the profiler.callstack.max.depth. current.index={}, max.depth={}, max.sequence={}", callStackIndex, maxDepth, maxSequence);
        }
    }
}
