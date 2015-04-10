/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package me.williamhester.obd.commands.protocol;

import me.williamhester.obd.commands.AbsObdCommand;

public abstract class ObdProtocolCommand extends AbsObdCommand {
    /**
     * Default ctor to use
     */
    public ObdProtocolCommand() { }

    @Override
    protected String getMode() {
        return "AT";
    }

    protected void fillBuffer() {
        // settings commands don't return a value appropriate to place into the
        // buffer, so do nothing
    }
}
