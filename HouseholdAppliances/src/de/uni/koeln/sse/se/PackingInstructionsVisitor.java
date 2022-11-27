package de.uni.koeln.sse.se;

public class PackingInstructionsVisitor implements Visitor {
	
	String instruction;
	
	public String getPackingInstructions(HouseholdItem item) {
		instruction = "";
		item.accept(this);
		return instruction;
	}

	@Override
	public void visitElectronic(Electronic electronic) {
		int lenght = (electronic.getLenght() + 1);
		int width = (electronic.getWidth() + 1);
		int height = (electronic.getHeight() + 1);
		
		instruction = (electronic.name + ":" + "\r" + ">should be covered with Polyethylene foam film and packed "
				+ "in a box with dimension: " + lenght + "x" + width + "x" + height);
		
	}

	@Override
	public void visitFurniture(Furniture furniture) {
		int lenght = furniture.getLenght();
		int width = furniture.getWidth();
		
		instruction = (furniture.name + ":" + "\r" + ">should be covered with waterproof covers "
				+ "with area of: " + lenght + "x" + width);
	}

	@Override
	public void visitGlass(Glass glass) {
		int lenght = (glass.getLenght() + 1);
		int width = (glass.getWidth() + 1);
		int height = (glass.getHeight() + 1);
		
		instruction = (glass.name + ":" + "\r" + ">should be wrapped with Bubble wraps "
				+ " and packed in a box with dimension: " +
				lenght + "x" + width + "x" + height);
		
	}

}
