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
package me.williamhester.obd.commands.fuel;

import me.williamhester.obd.commands.AbsObdCommand;
import me.williamhester.obd.enums.AvailableCommandNames;
import me.williamhester.obd.enums.FuelType;

/**
 * This command is intended to determine the vehicle fuel type.
 */
public class FindFuelTypeObdCommand extends AbsObdCommand {

    private int fuelType = 0;

    @Override
    protected String getCommand() {
        return "51";
    }

    @Override
    protected String getMode() {
        return "01";
    }

    @Override
    protected void performCalculations() {
        // ignore first two bytes [hh hh] of the response
        fuelType = buffer.get(2);
    }

    @Override
    public String getFormattedResult() {
        try {
            return FuelType.fromValue(fuelType).getDescription();
        } catch (Exception e) {
            return "-";
        }
    }

    @Override
    public String getName() {
        return AvailableCommandNames.FUEL_TYPE.getValue();
    }

}
