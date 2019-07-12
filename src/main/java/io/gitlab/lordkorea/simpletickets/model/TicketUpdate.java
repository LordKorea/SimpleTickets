package io.gitlab.lordkorea.simpletickets.model;

/**
 * An update to a ticket's status.
 */
public class TicketUpdate extends TicketHistoryEntry {

    /**
     * The type of update.
     */
    private final Type updateType;

    /**
     * Constructor.
     *
     * @param timestamp  The timestamp of this status update.
     * @param updateType The type of update of this entry.
     */
    public TicketUpdate(final long timestamp, final Type updateType) {
        super(timestamp);
        this.updateType = updateType;
    }

    @Override
    public String getDisplayString() {
        // TODO use i18n file for this
        return null;
    }

    /**
     * The different types of ticket update.
     */
    public enum Type {

        /**
         * This update is generated when a ticket is created.
         */
        CREATED,

        /**
         * This update is generated when a ticket is closed.
         */
        CLOSED,

        /**
         * This update is generated when a ticket is reopened.
         */
        REOPENED,

        /**
         * This update is generated when a ticket is claimed.
         */
        CLAIMED,

        /**
         * This update is generated when a ticket is unclaimed.
         */
        UNCLAIMED,

        /**
         * This update is generated when a ticket is escalated to another tier.
         */
        ESCALATED
    }
}
