package io.gitlab.lordkorea.simpletickets.config;

import io.gitlab.lordkorea.simpletickets.storage.StorageBackend;
import org.bukkit.configuration.ConfigurationSection;

/**
 * A storage profile with type {@code file}.
 */
public class FlatfileStorageProfile implements StorageProfile {

    /**
     * The path to the backend file.
     */
    private String path;

    @Override
    public void load(final ConfigurationSection section) {
        if (!section.isString("path")) {
            throw new IllegalStateException("missing 'path' key or not a string");
        }

        path = section.getString("path");
    }

    @Override
    public StorageBackend createBackend() {
        // TODO
        return null;
    }
}
