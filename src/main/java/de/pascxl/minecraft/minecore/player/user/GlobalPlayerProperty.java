package de.pascxl.minecraft.minecore.player.user;

import com.google.common.reflect.TypeToken;
import de.pascxl.minecraft.minecore.player.data.DiscordVerify;
import de.pascxl.minecraft.minecore.player.data.SkinData;
import de.pascxl.minecraft.minecore.player.data.TeamspeakVerify;
import de.pascxl.minecraft.minecore.MineCore;
import de.pascxl.minecraft.minecore.utilities.Catcher;
import de.pascxl.minecraft.minecore.utilities.Doubled;
import de.pascxl.minecraft.minecore.utilities.Runnabled;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bson.Document;

import java.util.List;

/**
 * Created by Pascal K. on 01.02.2023.
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class GlobalPlayerProperty<E> {

    private Runnabled<Doubled<E, Document>> taskImplementation;

    private Catcher<E, Document> catcher;

    public static final GlobalPlayerProperty<Long> ONLINE_TIME = new GlobalPlayerProperty<>(longDocumentDoubled ->
            longDocumentDoubled.getSecond().append("ONLINE_TIME", longDocumentDoubled.getFirst()), document ->
            document.getLong("ONLINE_TIME"));

    public static final GlobalPlayerProperty<Long> FIRST_JOIN = new GlobalPlayerProperty<>(longDocumentDoubled ->
            longDocumentDoubled.getSecond().append("FIRST_JOIN", longDocumentDoubled.getFirst()), document ->
            document.getLong("FIRST_JOIN"));

    public static final GlobalPlayerProperty<Long> LAST_SEEN = new GlobalPlayerProperty<>(longDocumentDoubled ->
            longDocumentDoubled.getSecond().append("LAST_SEEN", longDocumentDoubled.getFirst()), document ->
            document.getLong("LAST_SEEN"));

    public static final GlobalPlayerProperty<String> PLAYER_NAME = new GlobalPlayerProperty<>(stringDocumentDoubled ->
            stringDocumentDoubled.getSecond().append("PLAYER_NAME", stringDocumentDoubled.getFirst()), document ->
            document.getString("PLAYER_NAME"));

    public static final GlobalPlayerProperty<String> LANGUAGE_ID = new GlobalPlayerProperty<>(stringDocumentDoubled ->
            stringDocumentDoubled.getSecond().append("LANGUAGE_ID", stringDocumentDoubled.getFirst()), document ->
            document.getString("LANGUAGE_ID"));

    public static final GlobalPlayerProperty<String> IPv4_ADDRESS = new GlobalPlayerProperty<>(stringDocumentDoubled ->
            stringDocumentDoubled.getSecond().append("IPv4_ADDRESS", stringDocumentDoubled.getFirst()), document ->
            document.getString("IPv4_ADDRESS"));

    public static final GlobalPlayerProperty<String> BRAND = new GlobalPlayerProperty<>(stringDocumentDoubled ->
            stringDocumentDoubled.getSecond().append("BRAND", stringDocumentDoubled.getFirst()), document ->
            document.getString("BRAND"));

    public static final GlobalPlayerProperty<List<String>> NAME_LIST = new GlobalPlayerProperty<>(listDocumentDoubled ->
            listDocumentDoubled.getSecond().append("NAME_LIST", listDocumentDoubled.getFirst()), (Catcher<List<String>, Document>) document ->
            (List) document.get("NAME_LIST"));

    public static final GlobalPlayerProperty<List<String>> IPv4_LIST = new GlobalPlayerProperty<>(listDocumentDoubled ->
            listDocumentDoubled.getSecond().append("IPv4_LIST", listDocumentDoubled.getFirst()), (Catcher<List<String>, Document>) document ->
            (List) document.get("IPv4_LIST"));

    public static final GlobalPlayerProperty<Integer> COINS = new GlobalPlayerProperty<>(integerDocumentDoubled ->
            integerDocumentDoubled.getSecond().append("COINS", integerDocumentDoubled.getFirst()), document -> 
            document.getInteger("COINS"));

    public static final GlobalPlayerProperty<Integer> FAVOURITE_GLASS_COLOR = new GlobalPlayerProperty<>(integerDocumentDoubled ->
            integerDocumentDoubled.getSecond().append("FAVOURITE_GLASS_COLOR", integerDocumentDoubled.getFirst()), document -> 
            document.getInteger("FAVOURITE_GLASS_COLOR"));

    public static final GlobalPlayerProperty<Integer> GOLD = new GlobalPlayerProperty<>(integerDocumentDoubled ->
            integerDocumentDoubled.getSecond().append("GOLD", integerDocumentDoubled.getFirst()), document -> 
            document.getInteger("GOLD"));

    public static final GlobalPlayerProperty<Integer> STATS_RESET_TOKEN = new GlobalPlayerProperty<>(integerDocumentDoubled ->
            integerDocumentDoubled.getSecond().append("STATS_RESET_TOKEN", integerDocumentDoubled.getFirst()), document -> 
            document.getInteger("STATS_RESET_TOKEN"));

    public static final GlobalPlayerProperty<Integer> JOIN_ME_TOKEN = new GlobalPlayerProperty<>(integerDocumentDoubled ->
            integerDocumentDoubled.getSecond().append("JOIN_ME_TOKEN", integerDocumentDoubled.getFirst()), document -> 
            document.getInteger("JOIN_ME_TOKEN"));

    public static final GlobalPlayerProperty<SkinData> SKIN = new GlobalPlayerProperty<>(clayerSkinDataDocumentDoubled -> {
        if (clayerSkinDataDocumentDoubled.getFirst() == null) {
            clayerSkinDataDocumentDoubled.getSecond().append("SKIN", null);
        } else
            clayerSkinDataDocumentDoubled.getSecond().append("SKIN", MineCore.getInstance().getDatabaseManager().getMongoDatabase().getGsonToBsonAdapter().toDocument(
                    clayerSkinDataDocumentDoubled.getFirst()));
    }, document -> {
        if (!document.containsKey("SKIN") || document.get("SKIN") == null) return null;
        return MineCore.getInstance().getDatabaseManager().getMongoDatabase().getGsonToBsonAdapter().toObjective((Document) document.get("SKIN"),
                new TypeToken<SkinData>() {
        }.getType());
    });

    public static final GlobalPlayerProperty<DiscordVerify> DISCORD_ID = new GlobalPlayerProperty<>(discordVerifyDocumentDoubled -> {
        if (discordVerifyDocumentDoubled.getFirst() == null) {
            discordVerifyDocumentDoubled.getSecond().append("DISCORD_ID", null);
        } else
            discordVerifyDocumentDoubled.getSecond().append("DISCORD_ID", MineCore.getInstance().getDatabaseManager().getMongoDatabase().getGsonToBsonAdapter().toDocument(
                    discordVerifyDocumentDoubled.getFirst()));
    }, document -> {
        if (!document.containsKey("DISCORD_ID") || document.get("DISCORD_ID") == null) return null;
        return MineCore.getInstance().getDatabaseManager().getMongoDatabase().getGsonToBsonAdapter().toObjective((Document) document.get("DISCORD_ID"),
                new TypeToken<DiscordVerify>() {
        }.getType());
    });

    public static final GlobalPlayerProperty<TeamspeakVerify> TEAMSPEAK_ID = new GlobalPlayerProperty<>(teamspeakVerifyDocumentDoubled -> {
        if (teamspeakVerifyDocumentDoubled.getFirst() == null) {
            teamspeakVerifyDocumentDoubled.getSecond().append("TEAMSPEAK_ID", null);
        } else
            teamspeakVerifyDocumentDoubled.getSecond().append("TEAMSPEAK_ID", MineCore.getInstance().getDatabaseManager().getMongoDatabase().getGsonToBsonAdapter().toDocument(
                    teamspeakVerifyDocumentDoubled.getFirst()));
    }, document -> {
        if (!document.containsKey("TEAMSPEAK_ID") || document.get("TEAMSPEAK_ID") == null) return null;
        return MineCore.getInstance().getDatabaseManager().getMongoDatabase().getGsonToBsonAdapter().toObjective((Document) document.get("TEAMSPEAK_ID"),
                new TypeToken<TeamspeakVerify>() {
        }.getType());
    });

    public static final GlobalPlayerProperty<Boolean> ALLOWED_CHAT = new GlobalPlayerProperty<>(booleanDocumentDoubled ->
            booleanDocumentDoubled.getSecond().append("ALLOWED_CHAT", booleanDocumentDoubled.getFirst()), document ->
            document.getBoolean("ALLOWED_CHAT"));

    public static final GlobalPlayerProperty<Boolean> ANIMATIONS = new GlobalPlayerProperty<>(booleanDocumentDoubled ->
            booleanDocumentDoubled.getSecond().append("Animations", booleanDocumentDoubled.getFirst()), document ->
            document.getBoolean("Animations"));

    public static final GlobalPlayerProperty<Boolean> PARTICLE = new GlobalPlayerProperty<>(booleanDocumentDoubled ->
            booleanDocumentDoubled.getSecond().append("Particles", booleanDocumentDoubled.getFirst()), document -> 
            document.getBoolean("Particles"));

    public static final GlobalPlayerProperty<Boolean> NOTIFY_SERVICE_MESSAGING = new GlobalPlayerProperty<>(booleanDocumentDoubled ->
            booleanDocumentDoubled.getSecond().append("NOTIFY_SERVICE_MESSAGING", booleanDocumentDoubled.getFirst()), document ->
            document.getBoolean("NOTIFY_SERVICE_MESSAGING"));
    
    public static final GlobalPlayerProperty<Boolean> NOTIFY_STAFF_CHAT = new GlobalPlayerProperty<>(booleanDocumentDoubled ->
            booleanDocumentDoubled.getSecond().append("NOTIFY_STAFF_CHAT", booleanDocumentDoubled.getFirst()), document -> 
            document.getBoolean("NOTIFY_STAFF_CHAT"));
    
    public static final GlobalPlayerProperty<Boolean> NOTIFY_STAFF_CHAT_HIGH = new GlobalPlayerProperty<>(booleanDocumentDoubled ->
            booleanDocumentDoubled.getSecond().append("NOTIFY_STAFF_CHAT-High", booleanDocumentDoubled.getFirst()), document -> 
            document.getBoolean("NOTIFY_STAFF_CHAT-High"));

    public static final GlobalPlayerProperty<Boolean> NOTIFY_JOIN_ME = new GlobalPlayerProperty<>(booleanDocumentDoubled ->
            booleanDocumentDoubled.getSecond().append("NOTIFY_JOIN_ME", booleanDocumentDoubled.getFirst()), document -> 
            document.getBoolean("NOTIFY_JOIN_ME"));

    public static final GlobalPlayerProperty<Boolean> TEAM_AUTHORIZATION = new GlobalPlayerProperty<>(booleanDocumentDoubled ->
            booleanDocumentDoubled.getSecond().append("TEAM_AUTHORIZATION", booleanDocumentDoubled.getFirst()), document -> 
            document.getBoolean("TEAM_AUTHORIZATION"));

    public static final GlobalPlayerProperty<Integer> CLIENT_VERSION = new GlobalPlayerProperty<>(integerDocumentDoubled ->
            integerDocumentDoubled.getSecond().append("CLIENT_VERSION", integerDocumentDoubled.getFirst()), document -> 
            document.getInteger("CLIENT_VERSION"));

    public static final GlobalPlayerProperty<Boolean> NICK_SERVICE = new GlobalPlayerProperty<>(booleanDocumentDoubled ->
            booleanDocumentDoubled.getSecond().append("NICK_SERVICE", booleanDocumentDoubled.getFirst()), document -> 
            document.containsKey("NICK_SERVICE") && document.getBoolean("NICK_SERVICE"));

}