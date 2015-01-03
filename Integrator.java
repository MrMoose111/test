package test;

import java.util.function.DoubleFunction;
import java.util.LinkedList;
import java.util.ListIterator;

public class Integrator {

	private Integrator(){}
	
	public static double integrate(DoubleFunction<Double> f, double a, double b){
		LinkedList<Double> list = new LinkedList<>();
		list.add(a);list.add(b);
		ListIterator<Double> iterator = list.listIterator();
		
		while(iterator.hasNext()){
			double low = iterator.next();
			if(!iterator.hasNext())break;
			double high = iterator.next();
			iterator.previous();
			
			if(low-high>.01||f.apply(low) - f.apply(high)>.01){
				iterator.add(low-high);
				iterator.previous();
				iterator.previous();
			}
			
		}
		
		double result = 0;
		iterator = list.listIterator();
		
		while(iterator.hasNext()){
			double low = iterator.next();
			if(!iterator.hasNext())break;
			double high = iterator.next();
			result += (high-low)*(f.apply(high)+f.apply(low))/2;
		}
		
		return result;
	}
}
