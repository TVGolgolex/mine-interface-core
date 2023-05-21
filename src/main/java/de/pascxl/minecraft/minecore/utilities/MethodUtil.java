package de.pascxl.minecraft.minecore.utilities;

import com.sun.management.OperatingSystemMXBean;
import lombok.experimental.UtilityClass;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * JavaDoc this file!
 * Created: 17.05.2022
 *
 * @author GolgolexTV (golgolex@golgolex.de)
 */
@UtilityClass
public class MethodUtil {

    private final ThreadLocalRandom random = ThreadLocalRandom.current();
    private final char[] values = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (Exception var1) {
            return "127.0.0.1";
        }
    }

    public int firstValue(List<?> list) {
        int value = 0;
        for (Object ignored : list) {
            value++;
        }
        return value - list.size();
    }

    public boolean calcBoolean(boolean want, Boolean... booleans) {
        return Arrays.stream(booleans).anyMatch(aBoolean -> want);
    }

    public int lastValue(List<?> list) {
        int value = -1;
        for (Object ignored : list) {
            value++;
        }
        return value;
    }

    public boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception var2) {
            return false;
        }
    }

    public boolean isLong(String input) {
        try {
            Long.parseLong(input);
            return true;
        } catch (Exception var2) {
            return false;
        }
    }

    public boolean isBoolean(String input) {
        return (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false"));
    }

    public int randomIntMax(int max) {
        return random.nextInt(max);
    }

    public int randomIntBetween(int min, int max) {
        return min + (int) (Math.random() * max);
    }

    public double cpuUsage() {
        return ((OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getSystemCpuLoad() * 100.0;
    }

    public double internalCpuUsage() {
        return ((OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getProcessCpuLoad() * 100.0;
    }

    public long systemMemory() {
        return ((OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getTotalPhysicalMemorySize();
    }

    public String randomString(int size) {
        StringBuilder stringBuilder = new StringBuilder();

        for (short i = 0; i < size; ++i) {
            stringBuilder.append(values[random.nextInt(values.length)]);
        }

        return stringBuilder.substring(0);
    }

}
