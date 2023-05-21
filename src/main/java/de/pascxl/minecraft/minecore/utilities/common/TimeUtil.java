package de.pascxl.minecraft.minecore.utilities.common;

import de.pascxl.minecraft.minecore.language.Language;

import java.text.DateFormat;

/**
 * Created by Pascal K. on 17.05.2023.
 */
public interface TimeUtil {

    DateFormat format();

    DateFormat hourFormat();

    String getEndDisplay(long end);

    String getHour();

    String getRemainingTimeString(Language language, long endTime);

    String[] getRemainingTime(long milli);

}
