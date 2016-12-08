
public class Ch2_AbstractFactoryPattern {

	public static void main(String[] args) {
		System.out.println("Hello,Ch2_AbstractFactoryPattern!\n");
		AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
		Shape shape1 = shapeFactory.getShape("CIRCLE");
		Shape shape2 = shapeFactory.getShape("RECTANGLE");
		Shape shape3 = shapeFactory.getShape("SQUARE");
		Shape[] shapes = {shape1,shape2,shape3};
		for(Shape shape:shapes){
			shape.draw();
		}
		
		AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
		Color[] colors = new Color[3];
		colors[0] = colorFactory.getColor("RED");
		colors[1] = colorFactory.getColor("GREEN");
		colors[2] = colorFactory.getColor("BLUE");
		for(Color color:colors){
			color.fill();
		}
	}

}

abstract class AbstractFactory{
	abstract Color getColor(String color);
	abstract Shape getShape(String shape);
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

class ShapeFactory extends AbstractFactory{
	@Override 
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

	@Override
	Color getColor(String color) {
		// TODO Auto-generated method stub
		return null;
	}
}
/////////////////////////////////////////////////
interface Color{
	public void fill();
}
class Red implements Color{
	@Override 
	public void fill(){
		System.out.println("Inside Red::fill()");
	}
}
class Green implements Color{
	@Override 
	public void fill(){
		System.out.println("Inside Green::fill()");
	}
}
class Blue implements Color{
	@Override 
	public void fill(){
		System.out.println("Inside Blue::fill()");
	}
}


class ColorFactory extends AbstractFactory{
	@Override
	Color getColor(String colorType){
		if(colorType == null){
			return null;
		}
		if(colorType.equalsIgnoreCase("RED")){
			return new Red();
		}else if(colorType.equalsIgnoreCase("GREEN")){
			return new Green();
		}else if(colorType.equalsIgnoreCase("BLUE")){
			return new Blue();
		}
		return null;	
	}

	@Override
	Shape getShape(String shape) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

///////////////////////////////////////
class FactoryProducer{
	public static AbstractFactory getFactory(String choice){
		if(choice.equalsIgnoreCase("SHAPE")){
			return new ShapeFactory();
		}else if(choice.equalsIgnoreCase("COLOR")){
			return new ColorFactory();
		}
		return null;
	}
}
