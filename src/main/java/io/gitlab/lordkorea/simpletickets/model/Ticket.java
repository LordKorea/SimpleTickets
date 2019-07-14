package io.gitlab.lordkorea.simpletickets.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Represents a ticket. These objects are not unique, there may exist more than one Ticket per ID, for example due to
 * background updates.
 */
@AllArgsConstructor
public class Ticket {

    /**
     * The ID of the ticket.
     */
    private @Getter final int id;

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
     * The history of the ticket.
     */
    private final List<ITicketHistoryEntry> history = new ArrayList<>();

    /**
     * The tier of the ticket.
     */
    private TicketTier tier;

    /**
     * The status of this ticket.
     */
    private @Getter TicketStatus status;
}
