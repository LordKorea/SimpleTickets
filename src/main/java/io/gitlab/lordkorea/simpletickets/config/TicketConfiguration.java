package io.gitlab.lordkorea.simpletickets.config;

import java.util.HashMap;
import java.util.Map;

/**
 * Models the plugin's configuration.
 */
public class TicketConfiguration {

    /**
     * A registry for storage profile types.
     */
    private static final Map<String, StorageProfile> STORAGE_PROFILE_TYPES = new HashMap<>();

    /**
     * The selected storage profile.
     */
    private StorageProfile storageProfile;

    /**
     * Multi-server compatibility settings.
     */
    private ProxySettings proxySettings;

    /**
     * The tier hierarchy set in the configuration file.
     */
    private TierHierarchy tierHierarchy;

    /**
     * Ticket limits regarding timeouts and word requirements.
     */
    private TicketLimits ticketLimits;

    /**
     * The ticket stats profile used for generating stats.
     */
    private StatsProfile statsProfile;

    /**
     * The ticket notification profile used for notifying players of tickets.
     */
    private NotificationProfile notificationProfile;

    /**
     * Housekeeping settings.
     */
    private HousekeepingSettings housekeepingSettings;
}
