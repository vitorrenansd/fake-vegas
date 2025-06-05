package org.fakevegas.casino.mines.dto;

import java.util.List;

public record MinesResult(boolean exploded, double multiplier, List<Integer> field) {}