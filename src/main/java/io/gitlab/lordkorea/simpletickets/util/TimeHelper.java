package io.gitlab.lordkorea.simpletickets.util;

import io.gitlab.lordkorea.simpletickets.SimpleTicketsPlugin;

/**
 * Helper class for time-related things.
 */
public final class TimeHelper {

    /**
     * Checks whether the given time difference can be considered "instantaneous" for display purposes. This is the case
     * when the given time difference entails less than 1000 milliseconds.
     *
     * @param milliDifference The time difference in milliseconds.
     * @return {@code true} if and only if the given time difference can be considered "instantaneous".
     */
    public static boolean isNow(final long milliDifference) {
        return milliDifference < 1000;
    }

    /**
     * Formats a time difference using the plugin's {@link io.gitlab.lordkorea.simpletickets.util.MessageManager}.
     *
     * @param milliDifference The time difference in milliseconds.
     * @return The formatted time difference.
     */
    public static String formatSignificantTimeDifference(final long milliDifference) {
        if (milliDifference < 1000) {
            return SimpleTicketsPlugin.getMessageManager().format("simpletickets.time.now");
        }

        final long secondDifference = milliDifference / 1000;
        if (secondDifference < 60) {
            return formatAmount("simpletickets.time.second", secondDifference);
        }

        final long minuteDifference = secondDifference / 60;
        if (minuteDifference < 60) {
            return formatAmount("simpletickets.time.minute", minuteDifference);
        }

        final long hourDifference = minuteDifference / 60;
        if (hourDifference < 24) {
            return formatAmount("simpletickets.time.hour", hourDifference);
        }

        final long dayDifference = hourDifference / 24;
        if (dayDifference < 7) {
            return formatAmount("simpletickets.time.day", dayDifference);
        }

        final long weekDifference = dayDifference / 7;
        if (weekDifference < 4) {
            return formatAmount("simpletickets.time.week", weekDifference);
        }

        // Time is complicated. Both years and months are based on weeks (with ideal months and years), but mutually
        // incompatible. Our workaround causes "12 months" to sometimes show up, even when this *should* be "1 year".
        // I'm open to more ideal solutions. :^)
        final long yearDifference = weekDifference / 52;
        if (yearDifference > 0) {
            return formatAmount("simpletickets.time.year", yearDifference);
        }

        final long monthDifference = weekDifference / 4;
        return formatAmount("simpletickets.time.month", monthDifference);
    }

    /**
     * Formats an amount, taking care of grammar (-s or no -s).
     *
     * @param fmt    The format. A format which just consists of the format with an added "s" is expected to exist.
     * @param amount The amount to format.
     * @return The formatted amount.
     */
    private static String formatAmount(final String fmt, final long amount) {
        if (amount == 1) {
            return SimpleTicketsPlugin.getMessageManager().format(fmt, amount);
        }
        return SimpleTicketsPlugin.getMessageManager().format(fmt + 's', amount);
    }

    /**
     * Private constructor to prevent instance creation.
     */
    private TimeHelper() {
    }
}
