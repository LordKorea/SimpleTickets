package io.gitlab.lordkorea.simpletickets.config;

import io.gitlab.lordkorea.simpletickets.storage.StorageBackend;
import org.bukkit.configuration.ConfigurationSection;

/**
 * A storage profile with type {@code mysql}.
 */
public class MySQLStorageProfile implements StorageProfile {

    /**
     * The host on which the database is located.
     */
    private String host;

    /**
     * The port under which the database can be reached.
     */
    private int port;

    /**
     * The database which should be used.
     */
    private String database;

    /**
     * The username used for authentication.
     */
    private String user;

    /**
     * The password used for authentication.
     */
    private String password;

    /**
     * The table prefix used for tables of the plugin.
     */
    private String tablePrefix;

    @Override
    public void load(final ConfigurationSection section) {
        if (!section.isString("host")) {
            throw new IllegalStateException("missing 'host' key or not a string");
        }
        host = section.getString("host");

        if (!section.isInt("port")) {
            throw new IllegalStateException("missing 'port' key or not an int");
        }
        port = section.getInt("port");

        if (!section.isString("database")) {
            throw new IllegalStateException("missing 'database' key or not a string");
        }
        database = section.getString("database");

        if (!section.isString("user")) {
            throw new IllegalStateException("missing 'user' key or not a string");
        }
        user = section.getString("user");

        if (!section.isString("password")) {
            throw new IllegalStateException("missing 'password' key or not a string");
        }
        password = section.getString("password");

        if (!section.isString("table-prefix")) {
            throw new IllegalStateException("missing 'table-prefix' key or not a string");
        }
        tablePrefix = section.getString("table-prefix");
    }

    @Override
    public StorageBackend createBackend() {
        // TODO
        return null;
    }
}
