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

/**
 * This method will reset the OBD connection.
 */
public class OdbRawCommand extends ObdProtocolCommand {

    private String command;
    private String mode;

    /**
     * @param command a {@link java.lang.String} object.
     */
    public OdbRawCommand(String mode, String command) {
        this.mode = mode;
        this.command = command;
    }

    @Override
    protected String getCommand() {
        return command;
    }

    @Override
    protected String getMode() {
        return mode;
    }

    @Override
    public String getFormattedResult() {
        return getResult();
    }

    @Override
    public String getName() {
        return "Custom command " + getMode() + " " + getCommand();
    }

}