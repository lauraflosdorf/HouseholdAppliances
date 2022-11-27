package de.uni.koeln.sse.se;

public class MovingCostVisitor implements Visitor {
	
	double costs;
	String totalcost;
	
	public String getMovingCosts(HouseholdItem item) {
		totalcost = "";
		costs = 0.0;
		item.accept(this);
		return totalcost;
	}

	@Override
	public void visitElectronic(Electronic electronic) {
		if(electronic.fragile) {
			costs = ((5.0/10.0)*electronic.getWeight()); //5 euro per 10kg
		} else {
			costs = ((5.0/15.0)*electronic.getWeight()); //5 euro per 15kg
		}
		totalcost = ("Total Cost for " + electronic.name +
				" is: " + costs + " Euros");
	}
	

	@Override
	public void visitFurniture(Furniture furniture) {
		costs = ((5.0/20.0)*furniture.getWeight()); //5 euro per 20kg
		
		totalcost = ("Total Cost for " + furniture.name +
				" is: " + costs + " Euros");
	}

	@Override
	public void visitGlass(Glass glass) {
		if (glass.thickness == 1) {
			costs = (2.0*glass.getLenght());
		} else if (glass.thickness == 2) {
	    	costs = (1.20*glass.getLenght());
		} else if (glass.thickness == 3) {
			costs = (0.70*glass.getLenght());
		}
		
		totalcost = ("Total Cost for " + glass.name +
				" is: " + costs + " Euros");
		
	}

}
