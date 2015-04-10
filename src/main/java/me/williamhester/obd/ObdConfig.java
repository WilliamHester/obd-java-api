package me.williamhester.obd;

/**
 * Created by william on 4/10/15.
 */
public class ObdConfig {

    private ObdConfig() {}

    public static boolean useImperialUnits;

    /**
     * @return true if imperial units are used, or false otherwise
     */
    public static boolean useImperialUnits() {
        return useImperialUnits;
    }

    /**
     * Set to 'true' if you want to use imperial units, false otherwise. By
     * default this value is set to 'false'.
     *
     * @param isImperial a boolean.
     */
    public static void useImperialUnits(boolean isImperial) {
        useImperialUnits = isImperial;
    }

}
