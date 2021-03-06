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
import me.williamhester.obd.enums.FuelTrim;

/**
 * Fuel Trim.
 */
public class FuelTrimObdCommand extends AbsObdCommand {

    private float fuelTrimValue = 0.0f;
    private final FuelTrim bank;

    /**
     * Default ctor.
     * <p/>
     * Will read the bank from parameters and construct the command accordingly.
     * Please, see FuelTrim enum for more details.
     *
     * @param bank a {@link me.williamhester.obd.enums.FuelTrim} object.
     */
    public FuelTrimObdCommand(final FuelTrim bank) {
        this.bank = bank;
    }

    @Override
    protected String getCommand() {
        return bank.buildObdCommand();
    }

    @Override
    protected String getMode() {
        return "01";
    }

    /**
     * @param value
     * @return
     */
    private float prepareTempValue(final int value) {
        return new Double((value - 128) * (100.0 / 128)).floatValue();
    }

    protected void performCalculations() {
        // ignore first two bytes [hh hh] of the response
        fuelTrimValue = prepareTempValue(buffer.get(2));
    }

    @Override
    public String getFormattedResult() {
        return String.format("%.2f%s", fuelTrimValue, "%");
    }

    /**
     * @return the readed Fuel Trim percentage value.
     */
    public final float getValue() {
        return fuelTrimValue;
    }

    /**
     * @return the name of the bank in string representation.
     */
    public final String getBank() {
        return bank.getBank();
    }

    @Override
    public String getName() {
        return bank.getBank();
    }

}
