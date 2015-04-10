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
package me.williamhester.obd.commands;

import me.williamhester.obd.ObdConfig;
import me.williamhester.obd.enums.AvailableCommandNames;

/**
 * Current speed.
 */
public class SpeedObdCommand extends AbsObdCommand implements SystemOfUnits {

    private int metricSpeed = 0;

    @Override
    protected String getCommand() {
        return "0D";
    }

    @Override
    protected String getMode() {
        return "01";
    }

    @Override
    protected void performCalculations() {
        // Ignore first two bytes [hh hh] of the response.
        metricSpeed = buffer.get(2);
    }

    /**
     * @return a {@link java.lang.String} object.
     */
    public String getFormattedResult() {
        return ObdConfig.useImperialUnits ? String.format("%.2f%s", getImperialUnit(), "mph")
                : String.format("%d%s", getMetricSpeed(), "km/h");
    }

    /**
     * @return the speed in metric units.
     */
    public int getMetricSpeed() {
        return metricSpeed;
    }

    /**
     * @return the speed in imperial units.
     */
    public float getImperialSpeed() {
        return getImperialUnit();
    }

    /**
     * Convert from km/h to mph
     *
     * @return a float.
     */
    public float getImperialUnit() {
        return new Double(metricSpeed * 0.621371192).floatValue();
    }

    @Override
    public String getName() {
        return AvailableCommandNames.SPEED.getValue();
    }

}
