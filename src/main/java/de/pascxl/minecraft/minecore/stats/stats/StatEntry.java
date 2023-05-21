package de.pascxl.minecraft.minecore.stats.stats;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
public class StatEntry {

    private long value;

    private long timestamp;
}
