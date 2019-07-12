package io.gitlab.lordkorea.simpletickets.model;

import io.gitlab.lordkorea.simpletickets.SimpleTicketsPlugin;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;

import java.util.UUID;

/**
 * An update to a ticket's status.
 */
public class TicketUpdate extends TicketHistoryEntry {

    /**
     * The type of update.
     */
    private final Type updateType;

    /**
     * The issuer of the update.
     */
    private final UUID issuer;

    /**
     * Any additional data to the update.
     */
    private final String data;

    /**
     * Constructor.
     *
     * @param timestamp  The timestamp of this status update.
     * @param updateType The type of update of this entry.
     * @param issuer     The UUID of the player who caused this update.
     * @param data       Any additional data to the update.
     */
    public TicketUpdate(final long timestamp, final Type updateType, final UUID issuer, final String data) {
        super(timestamp);
        this.updateType = updateType;
        this.issuer = issuer;
        this.data = data;
    }

    @Override
    public String getDisplayString() {
        final String timestamp = getFormattedTimestamp();
        final String issuerName = Bukkit.getOfflinePlayer(issuer).getName();
        return SimpleTicketsPlugin.getMessageManager().format("simpletickets.format.comment", timestamp,
                issuerName, data);
    }

    /**
     * The different types of ticket update.
     */
    @RequiredArgsConstructor
    public enum Type {

        /**
         * This update is generated when a ticket is created.
         */
        CREATED("created"),

        /**
         * This update is generated when a ticket is closed.
         */
        CLOSED("closed"),

        /**
         * This update is generated when a ticket is reopened.
         */
        REOPENED("reopened"),

        /**
         * This update is generated when a ticket is claimed.
         */
        CLAIMED("claimed"),

        /**
         * This update is generated when a ticket is unclaimed.
         */
        UNCLAIMED("unclaimed"),

        /**
         * This update is generated when a ticket is escalated to another tier.
         */
        ESCALATED("escalated");

        /**
         * The ID of the type.
         */
        private @Getter final String id;
    }
}
