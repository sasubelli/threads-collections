package org.example.interview;

public enum Planet {
    MERCURY(3.303e23, 2.4397e6),
    VENUS(4.869e24, 6.0518e6),
    EARTH(5.976e24, 6.37814e6),
    MARS(6.421e23, 3.3972e6),
    JUPITER(1.9e27, 7.1492e7),
    SATURN(5.688e26, 6.0268e7),
    URANUS(8.686e25, 2.5559e7),
    NEPTUNE(1.024e26, 2.4746e7);

    public static final double G = 6.67300E-11;

    private final double mass;
    private final double radius;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    public double surfaceGravity() {
        return G * mass / (radius * radius);
    }

    public double surfaceWeight(double objectMass) {
        return objectMass * surfaceGravity();
    }

    public static void main(String[] args) {
        double earthWeight = args.length == 0 ? 75.0 : Double.parseDouble(args[0]);
        double mass = earthWeight / EARTH.surfaceGravity();

        for (Planet planet : values()) {
            System.out.printf("Weight on %-8s = %.2f N%n", planet, planet.surfaceWeight(mass));
        }
    }
}
