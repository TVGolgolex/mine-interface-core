package de.pascxl.minecraft.minecore.language;

import de.pascxl.minecraft.minecore.utilities.future.FutureHandler;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

/**
 * Created by Pascal K. on 17.05.2023.
 */
public interface LanguageManager {

    List<Language> getLoadedLanguages();

    MessageReceiver getReceiverFrom(UUID uuid, String name);

    MessageReceiver getReceiverFrom(Language language, String name);

    void unregisterReceiver(UUID uniqueId);

    MessageReceiver registerReceiver(UUID uniqueId, String pool);

    MessageReceiver registerReceiver(Language language, String pool);

    Language getDefault();

    Language getLanguage(String name);

    Language getLanguage(Predicate<Language> condition);

    void registerContent(String poolName, LanguageContent... contents);

    void registerContent(String poolName, List<LanguageContent> contents);

    void updateDatabase();

    void updateDatabaseAsync(FutureHandler<LanguageManager> future);

    void reload();

    void $a();

}
