package io.gitlab.lordkorea.simpletickets;

import co.aikar.taskchain.BukkitTaskChainFactory;
import co.aikar.taskchain.TaskChain;
import co.aikar.taskchain.TaskChainFactory;
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
     * Creates a new task chain.
     *
     * @param <T> The argument provided by the task chain. Meaningless on new chains.
     * @return The created chain.
     */
    public static <T> TaskChain<T> createChain() {
        return self.taskChainFactory.newChain();
    }

    /**
     * Obtains the message manager of this plugin.
     *
     * @return The message manager.
     */
    public static MessageManager getMessageManager() {
        return self.messageManager;
    }

    /**
     * A factory for {@link co.aikar.taskchain.TaskChain}s.
     */
    private TaskChainFactory taskChainFactory;

    @Override
    public void onEnable() {
        self = this;

        // Create the task chain factory.
        taskChainFactory = BukkitTaskChainFactory.create(this);

        // Save the default configuration if it does not exist.
        saveDefaultConfig();

        // Create the message manager.
        messageManager = new MessageManager(this);
        messageManager.saveDefaultMessages();
        messageManager.loadMessages();
    }
}
