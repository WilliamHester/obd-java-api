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
package me.williamhester.obd.commands.control;

import me.williamhester.obd.commands.PercentageObdCommand;
import me.williamhester.obd.enums.AvailableCommandNames;

/**
 * Timing Advance
 */
public class TimingAdvanceObdCommand extends PercentageObdCommand {

    @Override
    protected String getCommand() {
        return "0E";
    }

    @Override
    protected String getMode() {
        return "01";
    }

    @Override
    public String getName() {
        return AvailableCommandNames.TIMING_ADVANCE.getValue();
    }

}