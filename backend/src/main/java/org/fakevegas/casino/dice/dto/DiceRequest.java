package org.fakevegas.casino.dice.dto;

public record DiceRequest(int betAmount, int cutoff, boolean inverted) {}