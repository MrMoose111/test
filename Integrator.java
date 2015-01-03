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
			
			if(high-low>1||Math.abs(f.apply(high) - f.apply(low))>10){
				iterator.add((low+high)/2);
				iterator.previous();
				iterator.previous();
			}
			//System.out.println(list);
		}
		
		double result = 0;
		iterator = list.listIterator();
		
		while(iterator.hasNext()){
			double low = iterator.next();
			if(!iterator.hasNext())break;
			double high = iterator.next();
			result += (high-low)*(f.apply(high)+f.apply(low))/2;
			iterator.previous();
		}
		
		return result;
	}
}
