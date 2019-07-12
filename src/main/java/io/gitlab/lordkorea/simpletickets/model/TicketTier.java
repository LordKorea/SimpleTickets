package io.gitlab.lordkorea.simpletickets.model;

import lombok.RequiredArgsConstructor;

/**
 * Represents tiers tickets can have.
 */
@RequiredArgsConstructor
public class TicketTier {

    /**
     * The ID of the ticket tier.
     */
    private final String id;

    /**
     * The ticket tier which is "up the ladder" from this ticket tier.
     */
    private final TicketTier ladderUp;

    /**
     * The display name of the ticket tier.
     */
    private final String displayName;
}
