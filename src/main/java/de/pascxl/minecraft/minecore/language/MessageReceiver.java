package de.pascxl.minecraft.minecore.language;

import de.pascxl.minecraft.minecore.MineCore;

import java.util.UUID;

/**
 * Created by Pascal K. on 17.05.2023.
 */
public interface MessageReceiver {

    String getKey();

    MessagePool getMessagePool();

    boolean containsMessage(String key);

    String getMessage(String key, Object... arguments);

    String getMessageConverting(String key, Object... arguments);

    static MessageReceiver from(UUID uniqueId, String pool) {
        return MineCore.getInstance().getLanguageManager().getReceiverFrom(uniqueId, pool);
    }

    static MessageReceiver from(Language language, String pool) {
        return MineCore.getInstance().getLanguageManager().getReceiverFrom(language, pool);
    }

}
