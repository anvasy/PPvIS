package controller;

import model.ComparableObject;

public class StrategyChooser {
	public SearchStrategy chooseStrategy(ComparableObject obj) {
		if(obj.getName() != null)
			return new SearchNameAndDayStrategy();
		
		if(obj.getYearBirthStart() != 0) 
			return new SearchYearAndDayStrategy();
		
		if(obj.getYearStartEnroll() != 0) 
			return new SearchYearsStrategy();
		
		return new SearchDayAndMonthStrategy();
	}
}
