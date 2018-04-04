package pl.jacek.parking.vehicle;

public enum VehicleType {
    CAR(1),
    MOTORCYCLE(2),
    BICYCLE(3),
    TRUCK(4),
    BUS(5),
    DISABLED_CAR(6);

    private final int value;

    VehicleType(int value) {
        this.value = value;
    }


    int getValue() {
        return value;
    }
}
