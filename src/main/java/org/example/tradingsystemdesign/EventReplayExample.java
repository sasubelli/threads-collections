package org.example.tradingsystemdesign;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates event replay and audit-friendly state reconstruction.
 *
 * <p>Trading platforms often keep immutable event logs so they can:
 *
 * <ul>
 *   <li>rebuild state after restart</li>
 *   <li>investigate incidents</li>
 *   <li>replay historical sessions</li>
 *   <li>prove what happened and in what order</li>
 * </ul>
 *
 * <p>The main design principle is that current state should be derivable from an ordered sequence
 * of business events.
 */
public final class EventReplayExample {
    private EventReplayExample() {
    }

    public static void main(String[] args) {
        List<OrderEvent> events = List.of(
                new OrderEvent("ORD-1", "NEW", Instant.parse("2026-04-23T09:00:00Z")),
                new OrderEvent("ORD-1", "ACKNOWLEDGED", Instant.parse("2026-04-23T09:00:00.010Z")),
                new OrderEvent("ORD-1", "PARTIALLY_FILLED", Instant.parse("2026-04-23T09:00:00.020Z")),
                new OrderEvent("ORD-1", "FILLED", Instant.parse("2026-04-23T09:00:00.030Z"))
        );

        OrderTimeline timeline = replay(events);
        System.out.println(timeline);
    }

    /**
     * Rebuilds a simple timeline from immutable events.
     *
     * <p>In real systems, replay engines also validate sequence gaps, duplicates, and recovery
     * boundaries.
     */
    public static OrderTimeline replay(List<OrderEvent> events) {
        List<String> states = new ArrayList<>();
        for (OrderEvent event : events) {
            states.add(event.status() + "@" + event.eventTime());
        }
        String latestStatus = events.isEmpty() ? "UNKNOWN" : events.get(events.size() - 1).status();
        return new OrderTimeline(events.isEmpty() ? "N/A" : events.get(0).orderId(), latestStatus, states);
    }
}

record OrderEvent(String orderId, String status, Instant eventTime) {
}

record OrderTimeline(String orderId, String finalStatus, List<String> transitions) {
}
