package io.gitlab.lordkorea.simpletickets.model;

import lombok.AllArgsConstructor;
import org.bukkit.Location;

import java.util.UUID;

/**
 * Represents a ticket.
 */
@AllArgsConstructor
public class Ticket {

    /**
     * The ID of the ticket.
     */
    private final int id;

    /**
     * The UUID of the owner of the ticket.
     */
    private final UUID owner;

    /**
     * The name of the server this ticket was created on.
     */
    private final String serverName;

    /**
     * The location this ticket was created at.
     */
    private final Location location;

    /**
     * The timestamp at which this ticket was created.
     */
    private final long creationTimestamp;

    /**
     * The UUID of the assignee of this ticket, i.e. the person who has claimed this ticket. May be {@code null}.
     */
    private UUID assignee;

    /**
     * The status of this ticket.
     */
    private TicketStatus status;

    /**
     * The tier of the ticket.
     */
    private TicketTier tier;
}
