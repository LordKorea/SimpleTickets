package io.gitlab.lordkorea.simpletickets.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Base implementation of {@link io.gitlab.lordkorea.simpletickets.model.ITicketHistoryEntry}.
 */
@RequiredArgsConstructor
public abstract class TicketHistoryEntry implements ITicketHistoryEntry {

    /**
     * The timestamp of the entry.
     */
    private @Getter final long timestamp;
}
