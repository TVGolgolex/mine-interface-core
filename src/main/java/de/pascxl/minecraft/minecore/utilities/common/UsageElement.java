package de.pascxl.minecraft.minecore.utilities.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * Created by Pascal K. on 01.12.2022.
 */
@Accessors(fluent = true)
@AllArgsConstructor
@Getter
public class UsageElement {

    private final String commandKey;
    private final String descriptionKey;
    private final String permission;
}
