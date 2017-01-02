
public class Ch1_FactoryPattern {

	public static void main(String[] args){
		System.out.println("Hello,Ch1_FactoryPattern!\n");
		ShapeFactory shapeFactory = new ShapeFactory();
		Shape shape1 = shapeFactory.getShape("CIRCLE");
		Shape shape2 = shapeFactory.getShape("RECTANGLE");
		Shape shape3 = shapeFactory.getShape("SQUARE");
		
		Shape[] shapes = {shape1,shape2,shape3};
		for(Shape shape:shapes){
			shape.draw();
		}

	}
}

/////////////////////////////////////////////////
interface Shape{
	public void draw();
}

class Rectangle implements Shape{
	@Override
	public void draw(){
		System.out.println("Inside Rectangle::draw()");
	}
}
class Square implements Shape{
	@Override
	public void draw(){
		System.out.println("Inside Square::draw()");
	}
}
class Circle implements Shape {
	@Override
	public void draw() {
		System.out.println("Inside Circle::draw()");
	}
}
class ShapeFactory{
	//use getShape method to get object of type shape 
	public Shape getShape(String shapeType){
		if(shapeType == null){
			return null;
		}         
		if(shapeType.equalsIgnoreCase("CIRCLE")){
			return new Circle();
		} else if(shapeType.equalsIgnoreCase("RECTANGLE")){
			return new Rectangle();
		} else if(shapeType.equalsIgnoreCase("SQUARE")){
			return new Square();
		}
		return null;
	}
}
