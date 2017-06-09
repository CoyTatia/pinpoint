/*
 * Copyright 2017 NAVER Corp.
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

package com.navercorp.pinpoint.plugin.redis;

/**
 * @author Woonduk Kang(emeroad)
 */
public class EndPointUtils {

    public static String getEndPoint(Object[] args) {
        final StringBuilder sb = new StringBuilder();
        // first argument is host
        sb.append(args[0]);

        // second argument is port
        if (args.length >= 2 && args[1] instanceof Integer) {
            sb.append(':').append(args[1]);
        } else {
            // set default port
            sb.append(':').append(6379);
        }
        return sb.toString();
    }

}
