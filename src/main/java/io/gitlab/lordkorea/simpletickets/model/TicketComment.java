package io.gitlab.lordkorea.simpletickets.model;

import java.util.UUID;

/**
 * A comment on a ticket, written by a player.
 */
public class TicketComment extends TicketHistoryEntry {

    /**
     * The author of the comment.
     */
    private final UUID author;

    /**
     * The content of the comment.
     */
    private final String content;

    /**
     * Constructor.
     *
     * @param timestamp The timestamp of the comment.
     * @param author    The author of the comment.
     * @param content   The content of the comment.
     */
    public TicketComment(final long timestamp, final UUID author, final String content) {
        super(timestamp);
        this.author = author;
        this.content = content;
    }

    @Override
    public String getDisplayString() {
        // TODO use i18n file for this
        return null;
    }
}
