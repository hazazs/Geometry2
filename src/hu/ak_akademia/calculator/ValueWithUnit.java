package hu.ak_akademia.calculator;

final class ValueWithUnit {

	private final double value;
	private final LengthUnit unit;

	ValueWithUnit(double value, LengthUnit unit) {
		this.value = value;
		this.unit = unit;
	}

	double getValue() {
		return value;
	}

	LengthUnit getUnit() {
		return unit;
	}

	ValueWithUnit convertTo(LengthUnit targetUnit) {
		if (targetUnit == this.unit) {
			return this;
		} else {
			double newValue = this.value * this.unit.getConversionRate() / targetUnit.getConversionRate();
			return new ValueWithUnit(newValue, targetUnit);
		}
	}

	ValueWithUnit add(ValueWithUnit other) {
		double otherValue = other.convertTo(this.unit).value;
		return new ValueWithUnit(this.value + otherValue, this.unit);
	}

	private int getNumberOfDecimalPlaces(double value) {
		if (String.format("%f", value).matches("\\d+,0+")) {
			return 0;
		} else {
			value -= (int) value;
			int numberOfDecimalPlaces = 1;
			while (value * Math.pow(10.0, numberOfDecimalPlaces) < 1) {
				numberOfDecimalPlaces++;
			}
			return numberOfDecimalPlaces + 1;
		}
	}

	@Override
	public String toString() {
		return String.format("%." + getNumberOfDecimalPlaces(value) + "f %s", value, unit.getUnitName());
	}

}