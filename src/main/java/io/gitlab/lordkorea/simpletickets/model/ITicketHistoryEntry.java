package io.gitlab.lordkorea.simpletickets.model;

/**
 * Represents an element in a ticket's history.
 */
public interface ITicketHistoryEntry {

    /**
     * Returns the timestamp of this history entry.
     *
     * @return The timestamp of this history entry.
     */
    long getTimestamp();

    /**
     * Returns the display string of this history entry.
     *
     * @return The display string of this history entry.
     */
    String getDisplayString();
}
