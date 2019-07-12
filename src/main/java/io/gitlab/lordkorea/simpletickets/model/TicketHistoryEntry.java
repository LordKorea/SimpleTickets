package io.gitlab.lordkorea.simpletickets.model;

import io.gitlab.lordkorea.simpletickets.SimpleTicketsPlugin;
import io.gitlab.lordkorea.simpletickets.util.MessageManager;
import io.gitlab.lordkorea.simpletickets.util.TimeHelper;
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

    /**
     * Returns a formatted timestamp.
     *
     * @return The formatted timestamp.
     */
    protected String getFormattedTimestamp() {
        final long delta = System.currentTimeMillis() - timestamp;
        final String fmtTime = TimeHelper.formatSignificantTimeDifference(
                System.currentTimeMillis() - timestamp);

        final MessageManager msgs = SimpleTicketsPlugin.getMessageManager();
        if (TimeHelper.isNow(delta)) {
            return msgs.format("simpletickets.time.ago_now", fmtTime);
        }
        return msgs.format("simpletickets.time.ago", fmtTime);
    }
}
