package io.gitlab.lordkorea.simpletickets.util;

import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

/**
 * Manages messages sent by the plugin.
 */
public class MessageManager {

    /**
     * The plugin this class is a part of.
     */
    private final Plugin plugin;

    /**
     * The file in which messages are stored.
     */
    private final File messageFile;

    /**
     * The properties object in which messages are kept.
     */
    private final Properties messages;

    /**
     * Constructor.
     *
     * @param plugin The plugin the message manager is a part of.
     */
    public MessageManager(final Plugin plugin) {
        this.plugin = plugin;
        messageFile = new File(plugin.getDataFolder(), "messages.properties");
        messages = new Properties();
    }

    /**
     * Saves the default messages if no message file exists.
     */
    public void saveDefaultMessages() {
        if (!messageFile.exists()) {
            plugin.saveResource("messages.properties", false);
        }
    }

    /**
     * Loads messages from the message file into internal storage.
     */
    public void loadMessages() {
        try (final FileInputStream fis = new FileInputStream(messageFile)) {
            messages.load(fis);
        } catch (final IOException ex) {
            throw new IllegalStateException("Unable to load plugin messages from " + messageFile, ex);
        }
    }

    /**
     * Formats a message.
     *
     * @param fmt  The message format to use. If not found, the message will consist of this format.
     * @param data The data for formatting.
     * @return The formatted message.
     */
    public String format(final String fmt, final Object... data) {
        return MessageFormat.format(messages.getProperty(fmt, fmt), data);
    }
}
