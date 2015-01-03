package test;

import java.util.function.DoubleFunction;

public class Test {

	public static void main(String[] args) {
		DoubleFunction<Double> f = x -> x*x*x;
		System.out.println(Integrator.integrate(f, 0, 200));
	}

}
