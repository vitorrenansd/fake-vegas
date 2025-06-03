package org.fakevegas.casino.roulette.dto;

import org.fakevegas.casino.roulette.model.Colors;

public record RouletteRequest(int betAmount, Colors color) {}