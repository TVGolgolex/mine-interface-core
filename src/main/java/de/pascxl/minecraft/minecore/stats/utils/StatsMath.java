package de.pascxl.minecraft.minecore.stats.utils;


import de.pascxl.minecraft.minecore.stats.stats.IStats;

import java.text.NumberFormat;

public class StatsMath {

    public static String getWinChance(IStats stats, StatsTime statsTime) {
        double wins = (double) stats.get("wins", statsTime);
        double played = (double) stats.get("games", statsTime);
        double chance = ((wins == 0) ? 0 : (wins * 100.0) / played);

        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        return nf.format(chance) + "%";
    }

    public static String getWrongKillQuote(IStats stats, StatsTime statsTime) {
        double wrongKills = (double) stats.get("wrongkills", statsTime);
        double kills = (double) stats.get("kills", statsTime);
        double chance = ((wrongKills == 0) ? 0 : (wrongKills * 100.0) / kills);

        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        return nf.format(chance) + "%";
    }

    public static String getKillDeathRatio(IStats stats, StatsTime statsTime) {
        long deaths = stats.get("deaths", statsTime);
        long kills = stats.get("kills", statsTime);

        double kd = (deaths == 0L) ? ((double) kills) : (kills / (double) deaths);
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        return nf.format(kd);
    }
}
