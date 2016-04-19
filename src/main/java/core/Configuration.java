package core;

public class Configuration {
    //default interval for WaitFor.Until - smart waiting check one condition, in millis
    public static int timeout = 4000;
    //interval between checks inside WaitFor.Until, in millis
    public static int pollingInterval = 100;
}
