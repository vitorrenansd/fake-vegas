package org.fakevegas.casino.roulette.model;

public enum Slots {
    SLOT_1(1, Colors.RED),
    SLOT_2(2, Colors.RED),
    SLOT_3(3, Colors.RED),
    SLOT_4(4, Colors.RED),
    SLOT_5(5, Colors.RED),
    SLOT_6(6, Colors.RED),
    SLOT_7(7, Colors.RED),
    SLOT_8(8, Colors.BLACK),
    SLOT_9(9, Colors.BLACK),
    SLOT_10(10, Colors.BLACK),
    SLOT_11(11, Colors.BLACK),
    SLOT_12(12, Colors.BLACK),
    SLOT_13(13, Colors.BLACK),
    SLOT_14(14, Colors.BLACK),
    SLOT_0(0, Colors.GREEN);

    private final int number;
    private final Colors color;

    Slots(int number, Colors color) {
        this.number = number;
        this.color = color;
    }

    public int getNumber() {
        return number;
    }
    public Colors getColor() {
        return color;
    }
}