class Sum {
    public static int sumOfAreas(Shape[] array) {
        int sum = 0;
        for (Shape shape : array) {
            if (shape.getClass() == Square.class) {
                int side = ((Square) shape).getSide();
                sum += side * side;
            } else if (shape.getClass() == Rectangle.class) {
                Rectangle rectangle = (Rectangle) shape;
                sum += rectangle.getHeight() * rectangle.getWidth();
            }
        }
        return sum;
    }
}

//Don't change the code below
class Shape {
}

class Square extends Shape {
    private int side;

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }
}

class Rectangle extends Shape {
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}