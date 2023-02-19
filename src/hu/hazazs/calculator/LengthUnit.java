package hu.hazazs.calculator;

import java.util.stream.Stream;

public enum LengthUnit {

	MM("mm", 1.0 / 1000), CM("cm", 1.0 / 100), DM("dm", 1.0 / 10), M("m", 1.0), KM("km", 1000.0);

	private final String unitName;
	private final double conversionRate;

	private LengthUnit(String unitName, double conversionRate) {
		this.unitName = unitName;
		this.conversionRate = conversionRate;
	}

	String getUnitName() {
		return unitName;
	}

	double getConversionRate() {
		return conversionRate;
	}

	static LengthUnit getFrom(final String stringUnit) {
		return Stream.of(values())
				.filter(lengthUnit -> stringUnit.equals(lengthUnit.unitName))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Invalid length unit: " + stringUnit));
	}

}