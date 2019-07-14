package io.gitlab.lordkorea.simpletickets;

import io.gitlab.lordkorea.simpletickets.model.Ticket;
import io.gitlab.lordkorea.simpletickets.model.TicketStatus;
import io.gitlab.lordkorea.simpletickets.storage.StorageBackend;
import lombok.RequiredArgsConstructor;
import org.bukkit.Location;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * Keeps track of all known tickets and acts as a cache between the plugin and the storage backend.
 */
@RequiredArgsConstructor
public class TicketManager {

    /**
     * The registered tickets.
     */
    private final Map<Integer, Ticket> tickets = new HashMap<>();

    /**
     * The active storage backend.
     */
    private final StorageBackend storageBackend;

    /**
     * Allocates a ticket.
     *
     * @param owner    The owner of the ticket.
     * @param location The location the ticket is created at.
     * @return The created ticket.
     */
    public CompletableFuture<Ticket> allocateTicket(final UUID owner, final Location location) {
        return storageBackend.allocateTicket(owner, location);
    }

    /**
     * Retrieves a ticket by ID.
     *
     * @param id The ticket ID.
     * @return The ticket.
     */
    public CompletableFuture<Optional<Ticket>> getTicket(final int id) {
        final Ticket ticket = tickets.get(id);
        if (ticket != null) {
            return CompletableFuture.completedFuture(Optional.of(ticket));
        }
        return storageBackend.getTicketById(id);
    }

    /**
     * Returns the tickets that are open, i.e. have a status of
     * {@link io.gitlab.lordkorea.simpletickets.model.TicketStatus#OPEN}.
     *
     * @return The open tickets.
     */
    public Collection<Ticket> getOpenTickets() {
        return Collections.unmodifiableList(tickets.values().stream()
                .filter(t -> t.getStatus() == TicketStatus.OPEN)
                .collect(Collectors.toList()));
    }

    /**
     * Synchronizes tickets with the backend.
     */
    private void synchronizeWithBackend() {
        SimpleTicketsPlugin.createChain()
                .future(storageBackend.getUpdatedTickets())
                .syncLast(ts -> ts.forEach(t -> tickets.put(t.getId(), t)))
                .execute();
    }
}
