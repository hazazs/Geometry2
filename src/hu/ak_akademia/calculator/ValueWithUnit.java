package hu.ak_akademia.calculator;

public final class ValueWithUnit {

	private double value;
	private LengthUnit unit;

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

	public ValueWithUnit add(ValueWithUnit other) {
		other.convertTo(this.unit);
		return new ValueWithUnit(this.value + other.value, this.unit);
	}

	public ValueWithUnit multiply(double number) {
		return new ValueWithUnit(this.value * number, this.unit);
	}

	public ValueWithUnit multiply(ValueWithUnit other) {
		other.convertTo(this.unit);
		return new ValueWithUnit(this.value * other.value, this.unit);
	}
	
	private void convertTo(LengthUnit targetUnit) {
		if (targetUnit != this.unit) {
			this.value = this.value * this.unit.getConversionRate() / targetUnit.getConversionRate();
			this.unit = targetUnit;
		}
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