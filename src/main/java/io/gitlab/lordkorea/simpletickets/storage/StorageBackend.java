package io.gitlab.lordkorea.simpletickets.storage;

import io.gitlab.lordkorea.simpletickets.model.Ticket;
import io.gitlab.lordkorea.simpletickets.model.TicketStats;
import org.bukkit.Location;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * Represents a storage backend.
 */
public interface StorageBackend {

    /**
     * Allocates a ticket.
     *
     * @param owner    The owner of the ticket.
     * @param location The location the ticket is created at.
     * @return The created ticket.
     */
    CompletableFuture<Ticket> allocateTicket(UUID owner, Location location);

    /**
     * Retrieves tickets that have been updated in the background. If the storage backend implementation does not
     * support background updates, this must always return an empty collection.
     *
     * @return The updated tickets.
     */
    CompletableFuture<Collection<Ticket>> getUpdatedTickets();

    /**
     * Retrieves all unresolved tickets, that is, tickets with a status other than
     * {@link io.gitlab.lordkorea.simpletickets.model.TicketStatus#RESOLVED}.
     *
     * @return All unresolved tickets.
     */
    CompletableFuture<Collection<Ticket>> getUnresolvedTickets();

    /**
     * Retrieves a ticket by ID.
     *
     * @param id The ID of the ticket.
     * @return The ticket.
     */
    CompletableFuture<Optional<Ticket>> getTicketById(int id);

    /**
     * Retrieves stats for the given player.
     *
     * @param player      The player.
     * @param maxAge      The maximum age for actions to be considered, in milliseconds.
     * @param claimedOnly When this is {@code true}, only tickets claimed by the player will be considered.
     * @return The stats for the given player.
     */
    CompletableFuture<Optional<TicketStats>> getStatsFor(final UUID player, final long maxAge,
                                                         final boolean claimedOnly);

    /**
     * Retrieves stats for all players.
     *
     * @param maxAge      The maximum age for actions to be considered, in milliseconds.
     * @param claimedOnly When this is {@code true}, only tickets claimed by the player will be considered.
     * @return The stats for all players.
     */
    CompletableFuture<Collection<TicketStats>> getGlobalStats(final long maxAge, final boolean claimedOnly);
}
