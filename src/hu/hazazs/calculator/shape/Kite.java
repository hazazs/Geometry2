package hu.hazazs.calculator.shape;

import hu.hazazs.calculator.LengthUnit;
import hu.hazazs.calculator.ValueWithUnit;

public class Kite implements Shape {

	private final ValueWithUnit a;
	private final ValueWithUnit b;
	private final ValueWithUnit e;
	private final ValueWithUnit f;

	public Kite(ValueWithUnit a, ValueWithUnit b, ValueWithUnit e, ValueWithUnit f) {
		this.a = a;
		this.b = b;
		this.e = e;
		this.f = f;
	}

	@Override
	public ValueWithUnit calculateArea(LengthUnit targetUnit) {
		e.convertTo(targetUnit);
		f.convertTo(targetUnit);
		return e.multiply(f).divide(2);
	}

	@Override
	public ValueWithUnit calculatePerimeter(LengthUnit targetUnit) {
		a.convertTo(targetUnit);
		b.convertTo(targetUnit);
		return a.add(b).multiply(2);
	}

}