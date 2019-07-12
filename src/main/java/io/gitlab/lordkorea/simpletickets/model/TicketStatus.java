package io.gitlab.lordkorea.simpletickets.model;

/**
 * Represents statuses a ticket can have.
 */
public enum TicketStatus {

    /**
     * A ticket is open if it hasn't been answered or hasn't been marked as closed.
     */
    OPEN,

    /**
     * A ticket is closed once staff answers the ticket and subsequently marks it as closed.
     */
    CLOSED,

    /**
     * A ticket is resolved once it is closed and the owner of the ticket views the ticket.
     */
    RESOLVED
}
