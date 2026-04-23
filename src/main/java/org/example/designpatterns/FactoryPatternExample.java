package org.example.designpatterns;

public final class FactoryPatternExample {
    private FactoryPatternExample() {
    }

    public static void main(String[] args) {
        MarketDataDecoder equityDecoder = DecoderFactory.create("EQUITY");
        MarketDataDecoder futuresDecoder = DecoderFactory.create("FUTURES");

        System.out.println(equityDecoder.decode("AAPL|185.22|100"));
        System.out.println(futuresDecoder.decode("ESM6|5250.75|12"));
    }
}

interface MarketDataDecoder {
    String decode(String rawMessage);
}

final class EquityDecoder implements MarketDataDecoder {
    @Override
    public String decode(String rawMessage) {
        return "Equity message decoded: " + rawMessage;
    }
}

final class FuturesDecoder implements MarketDataDecoder {
    @Override
    public String decode(String rawMessage) {
        return "Futures message decoded: " + rawMessage;
    }
}

final class DecoderFactory {
    private DecoderFactory() {
    }

    static MarketDataDecoder create(String assetClass) {
        return switch (assetClass) {
            case "EQUITY" -> new EquityDecoder();
            case "FUTURES" -> new FuturesDecoder();
            default -> throw new IllegalArgumentException("Unsupported asset class: " + assetClass);
        };
    }
}
