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
package me.williamhester.obd.commands.engine;

import me.williamhester.obd.commands.AbsObdCommand;
import me.williamhester.obd.enums.AvailableCommandNames;

/**
 * Mass Air Flow
 */
public class MassAirFlowObdCommand extends AbsObdCommand {

    private float maf = -1.0f;

    @Override
    protected String getCommand() {
        return "10";
    }

    @Override
    protected String getMode() {
        return "01";
    }

    @Override
    protected void performCalculations() {
        // ignore first two bytes [hh hh] of the response
        maf = (buffer.get(2) * 256 + buffer.get(3)) / 100.0f;
    }

    @Override
    public String getFormattedResult() {
        return String.format("%.2f%s", maf, "g/s");
    }

    /**
     * @return MAF value for further calculus.
     */
    public double getMAF() {
        return maf;
    }

    @Override
    public String getName() {
        return AvailableCommandNames.MAF.getValue();
    }

}
