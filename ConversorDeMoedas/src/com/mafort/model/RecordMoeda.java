package com.mafort.model;

import java.math.BigDecimal;
import java.util.HashMap;

public record RecordMoeda(HashMap<String, BigDecimal> conversion_rates, String base_code) {
}
