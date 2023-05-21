package de.pascxl.minecraft.minecore.language;

/**
 * Created by Pascal K. on 17.05.2023.
 */
public class CoreLanguagePreset {

    public static final String CORE_POOL = "core-pool";
    public static final String CORE_PERMISSION_GROUP_POOL = "permission-group-names";

    public CoreLanguagePreset(LanguageManager languageManager) {

        languageManager.registerContent(CORE_POOL,
                new LanguageContent("not_logged_in_to_team_account", "§cThis promotion is currently not available for you§8. §cLog in to your team account first§8."),
                //=======================================================================================================
                new LanguageContent("coins-display-own", "§7You own a fortune of §e{0} §7coins§8."),
                new LanguageContent("coins-target-not-found", "§e{0} §ccould not be found§8."),
                new LanguageContent("coins-display-other", "§e{0} §7has a fortune of §e{1} §7coins§8."),
                new LanguageContent("coins-command-too-much-resolved", "§cYou have made too many requests§8! §cPlease wait a moment§8."),
                //=======================================================================================================
                new LanguageContent("nick_toggle_nick_enabled", "§7You have §aactivated §7the automatic nickname§8."),
                new LanguageContent("nick_toggle_nick_disabled", "§7You have §aactivated §7the automatic nickname§8."),
                new LanguageContent("nick_player_was_nicked", "§7Your identity is now protected. Your new name is§8: §e{0}"),
                new LanguageContent("nick_player_was_un_nicked", "§7Your identity is no longer hidden§8."),
                new LanguageContent("nick_custom_nick_incorrect_usage", "§e/customnick <any player name>"),
                new LanguageContent("nick_player_nick_try_failed", "§cAn error occurred while generating a NickInfo§8. §cPlease try again§8!"),
                new LanguageContent("nick_system_is_not_enabled", "§cThe NickSystem is not activated on this server§8."),
                //=======================================================================================================
                new LanguageContent("stats_command_rank_not_found", "§cNo player with this rank was found§8."),
                new LanguageContent("stats_command_rank_invalid", "§cYou must specify a number§8!"),
                new LanguageContent("stats_command_player_not_found", "§cNo player with this name was found§8."),
                new LanguageContent("stats_command_too_much_resolved", "§cYou have made too many requests§8! §cPlease wait a moment§8."),
                new LanguageContent("stats_reset_command_no_reset_tokens", "§cYou do not own any stat reset tokens§8."),

                new LanguageContent("stats_reset_command_new_tokens_amount_one", "§aYou have used a stats reset token§8. You have §e{0} §7remaining§8."),
                new LanguageContent("stats_reset_command_new_tokens_amount_more", "§aYou have used a stats reset token§8. §7You have §e{0} §7more remaining§8."),
                new LanguageContent("stats_reset_command_reset_stats_target", "§7The statistics of §e{0} §7have been §creset§8."),
                new LanguageContent("stats_reset_command_reset_stats", "§7Your statistics have been reset§8."),
                new LanguageContent("stats_reset_command_reset_failed", "§cAn error occurred when resetting the statistics from §e{0}§8!"),
                //=======================================================================================================
                new LanguageContent("time-argument-day", "day"),
                new LanguageContent("time-argument-days", "days"),
                new LanguageContent("time-argument-hour", "hour"),
                new LanguageContent("time-argument-hours", "hours"),
                new LanguageContent("time-argument-minute", "minute"),
                new LanguageContent("time-argument-minutes", "minutes"),
                new LanguageContent("time-argument-second", "second"),
                new LanguageContent("time-argument-seconds", "seconds"),
                //=======================================================================================================
                new LanguageContent("server-player-coins-add", "§7You have received §e{0} §7coins§8!"),
                new LanguageContent("server-player-coins-remove", "§7You have lost §e{0} §7coins§8!"),
                //=======================================================================================================
                new LanguageContent("server-player-rank-update", "§7Your rank has been changed to §e{0}§8!"),
                new LanguageContent("server-player-rank-update-ending-time-never", "§7Rank expiration§8: §cNever"),
                new LanguageContent("server-player-rank-update-ending-time", "§7Rank expiration§8: §e{0}"),
                //=======================================================================================================
                new LanguageContent("server-player-online-time-allow-chat", "§7Now that you have been active on the network for more than §e15 §7minutes§8, §7the chat has been §aunlocked §7for you§8.")
        );

    }
}
