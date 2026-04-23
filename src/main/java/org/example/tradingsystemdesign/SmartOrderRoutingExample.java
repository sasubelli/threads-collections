package org.example.tradingsystemdesign;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

/**
 * Demonstrates simplified smart order routing.
 *
 * <p>A real SOR engine considers many more constraints than this example, including fees, rebates,
 * latency, toxicity, available liquidity, venue reliability, resting order probability, and client
 * instructions. This sample focuses on the interview-friendly core idea: choose the best venue
 * based on a policy.
 */
public final class SmartOrderRoutingExample {
    private SmartOrderRoutingExample() {
    }

    public static void main(String[] args) {
        List<VenueQuote> quotes = List.of(
                new VenueQuote("XNYS", new BigDecimal("185.25"), 400, 2),
                new VenueQuote("BATS", new BigDecimal("185.24"), 200, 1),
                new VenueQuote("IEX", new BigDecimal("185.26"), 1000, 4)
        );

        VenueQuote selected = bestExecutionVenue(quotes);
        System.out.println("Selected venue = " + selected);
    }

    /**
     * Chooses the best venue by price first, then by lower latency score.
     *
     * <p>Senior discussion point: in a production router, "best" is a business decision, not only
     * a technical one.
     */
    public static VenueQuote bestExecutionVenue(List<VenueQuote> quotes) {
        return quotes.stream()
                .min(Comparator.comparing(VenueQuote::offerPrice)
                        .thenComparing(VenueQuote::latencyScoreMillis))
                .orElseThrow(() -> new IllegalArgumentException("No venues available"));
    }
}

record VenueQuote(String venue, BigDecimal offerPrice, int availableQuantity, int latencyScoreMillis) {
}
