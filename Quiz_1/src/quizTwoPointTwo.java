public class quizTwoPointTwo {
    public static void main(String[] args) {

        // initial position of the planet
        double initialRadius = 200; //unit
        double initialAngle = 0; //radians

        // Angle of rotation after one third of the orbit
        double thirdOfOrbit = (1.0 / 3.0) * 2 * Math.PI; //radians

        // Calculate new angle after one third of the orbit
        double newAngle = initialAngle + thirdOfOrbit;

        // calculate new position
        double newX = initialRadius * Math.cos(newAngle);
        double newY = initialRadius * Math.sin(newAngle);


        System.out.println("New position of the closest point on the planet to the sun after one third of the orbit:");
        System.out.println("X coordinate: " + newX);
        System.out.println("X coordinate: " + newY);
    }
}
