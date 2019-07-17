package io.gitlab.lordkorea.simpletickets.config;

import io.gitlab.lordkorea.simpletickets.storage.StorageBackend;
import org.bukkit.configuration.ConfigurationSection;

/**
 * Represents a storage profile.
 */
public interface StorageProfile {

    /**
     * Loads the storage profile from the given configuration section.
     *
     * @param section The configuration section.
     */
    void load(ConfigurationSection section);

    /**
     * Creates a storage backend for this profile.
     *
     * @return The created backend.
     */
    StorageBackend createBackend();
}
