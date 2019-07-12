package io.gitlab.lordkorea.simpletickets;

import io.gitlab.lordkorea.simpletickets.util.MessageManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main plugin class.
 */
public class SimpleTicketsPlugin extends JavaPlugin {

    /**
     * The plugin instance.
     */
    private static SimpleTicketsPlugin self;

    /**
     * The plugin's message manager, used for configurable messages.
     */
    private MessageManager messageManager;

    /**
     * Obtains the message manager of this plugin.
     *
     * @return The message manager.
     */
    public static MessageManager getMessageManager() {
        return self.messageManager;
    }

    @Override
    public void onEnable() {
        self = this;

        // Save the default configuration if it does not exist.
        saveDefaultConfig();

        // Create the message manager.
        messageManager = new MessageManager(this);
        messageManager.saveDefaultMessages();
        messageManager.loadMessages();
    }
}
