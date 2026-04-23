package org.example.designpatterns;

import java.math.BigDecimal;

public final class BuilderPatternExample {
    private BuilderPatternExample() {
    }

    public static void main(String[] args) {
        OrderRequest request = OrderRequest.builder()
                .clientOrderId("ORD-1001")
                .symbol("AAPL")
                .side("BUY")
                .quantity(500)
                .price(new BigDecimal("185.40"))
                .timeInForce("DAY")
                .build();

        System.out.println(request);
    }
}

final class OrderRequest {
    private final String clientOrderId;
    private final String symbol;
    private final String side;
    private final int quantity;
    private final BigDecimal price;
    private final String timeInForce;

    private OrderRequest(Builder builder) {
        this.clientOrderId = builder.clientOrderId;
        this.symbol = builder.symbol;
        this.side = builder.side;
        this.quantity = builder.quantity;
        this.price = builder.price;
        this.timeInForce = builder.timeInForce;
    }

    static Builder builder() {
        return new Builder();
    }

    static final class Builder {
        private String clientOrderId;
        private String symbol;
        private String side;
        private int quantity;
        private BigDecimal price;
        private String timeInForce = "DAY";

        Builder clientOrderId(String clientOrderId) {
            this.clientOrderId = clientOrderId;
            return this;
        }

        Builder symbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        Builder side(String side) {
            this.side = side;
            return this;
        }

        Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        Builder timeInForce(String timeInForce) {
            this.timeInForce = timeInForce;
            return this;
        }

        OrderRequest build() {
            if (clientOrderId == null || symbol == null || side == null || price == null) {
                throw new IllegalStateException("Missing required order fields");
            }
            return new OrderRequest(this);
        }
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "clientOrderId='" + clientOrderId + '\'' +
                ", symbol='" + symbol + '\'' +
                ", side='" + side + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", timeInForce='" + timeInForce + '\'' +
                '}';
    }
}
