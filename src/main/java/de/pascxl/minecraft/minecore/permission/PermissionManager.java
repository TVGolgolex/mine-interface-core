package de.pascxl.minecraft.minecore.permission;

import com.google.common.util.concurrent.ListenableFuture;
import de.pascxl.minecraft.minecore.language.Language;
import de.pascxl.minecraft.minecore.permission.group.PermissionGroup;
import de.pascxl.minecraft.minecore.permission.group.PermissionGroupSerializer;
import de.pascxl.minecraft.minecore.permission.group.permission.Permission;
import de.pascxl.minecraft.minecore.permission.group.permission.PermissionSerializer;
import de.pascxl.minecraft.minecore.permission.group.styling.PermissionGroupStyling;
import de.pascxl.minecraft.minecore.permission.group.styling.PermissionGroupStylingSerializer;

import java.util.List;
import java.util.UUID;

/**
 * Created by Pascal K. on 17.05.2023.
 */
public interface PermissionManager {

    PermissionSerializer getPermissionSerializer();

    PermissionGroupSerializer getGroupSerializer();

    PermissionGroupStylingSerializer getGroupStylingSerializer();

    String getGroupName(Language language,
                        String groupId);

    ListenableFuture<String> getGroupNameAsync(UUID uniqueId,
                                            String groupId);

    List<PermissionGroup> cachedGroups();

    void reloadPermissionGroups();

    PermissionGroup getFallback();

    PermissionGroup getGroup(String id);

    ListenableFuture<PermissionGroup> getGroupAsync(String id);

    ListenableFuture<PermissionGroup> createPermissionGroup(PermissionGroup permissionGroup);

    PermissionGroup constructPermissionGroup(String id,
                                             PermissionGroupStyling styling,
                                             long discordGroupId,
                                             long teamspeakGroupId,
                                             String sorting,
                                             boolean useAsDefault,
                                             boolean teamRank,
                                             List<Permission> permissions);

    PermissionGroupStyling constructPermissionGroupStyling(String groupName,
                                                           String prefix,
                                                           String suffix,
                                                           String hexCode,
                                                           String altColor);

}
