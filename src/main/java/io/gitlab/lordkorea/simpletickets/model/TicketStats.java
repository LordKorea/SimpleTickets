package io.gitlab.lordkorea.simpletickets.model;

import io.gitlab.lordkorea.simpletickets.model.TicketUpdate.Type;
import lombok.RequiredArgsConstructor;

import java.util.EnumMap;
import java.util.Map;
import java.util.UUID;

/**
 * Represents ticket stats.
 */
@RequiredArgsConstructor
public class TicketStats {

    /**
     * The player that these stats are about.
     */
    private final UUID player;

    /**
     * The stats, for each {@link Type}.
     */
    private final Map<Type, Integer> stats = new EnumMap<>(Type.class);
}
