import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Plot {
    protected String ownerName;

    public Plot(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public abstract String getShapeName();
    public abstract double calculateArea();
}

class CirclePlot extends Plot {
    private double radius;

    public CirclePlot(String ownerName, double radius) {
        super(ownerName);
        this.radius = radius;
    }

    @Override
    public String getShapeName() {
        return "CIRCLE";
    }

    @Override
    public double calculateArea() {
        // Circle area = pi * r * r
        return Math.PI * radius * radius;
    }
}

class RectanglePlot extends Plot {
    private double length;
    private double width;

    public RectanglePlot(String ownerName, double length, double width) {
        super(ownerName);
        this.length = length;
        this.width = width;
    }

    @Override
    public String getShapeName() {
        return "RECTANGLE";
    }

    @Override
    public double calculateArea() {
        // Rectangle area = length * width
        return length * width;
    }
}

class TrianglePlot extends Plot {
    private double base;
    private double height;

    public TrianglePlot(String ownerName, double base, double height) {
        super(ownerName);
        this.base = base;
        this.height = height;
    }

    @Override
    public String getShapeName() {
        return "TRIANGLE";
    }

    @Override
    public double calculateArea() {
        // Triangle area = 0.5 * base * height
        return 0.5 * base * height;
    }
}

public class GardenPlotAreaReport {
    public static void printGardenReport(List<Plot> plots) {
        double totalArea = 0.0;
        for (Plot p : plots) {
            double area = p.calculateArea();
            totalArea += area;
            System.out.printf("%s (%s): %.2f%n", p.getOwnerName(), p.getShapeName(), area);
        }
        System.out.printf("Total Area: %.2f%n", totalArea);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Plot> plots = new ArrayList<>();

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String shape = sc.next();
                String owner = sc.next();
                if (shape.equalsIgnoreCase("CIRCLE")) {
                    double r = sc.nextDouble();
                    plots.add(new CirclePlot(owner, r));
                } else if (shape.equalsIgnoreCase("RECTANGLE")) {
                    double l = sc.nextDouble();
                    double w = sc.nextDouble();
                    plots.add(new RectanglePlot(owner, l, w));
                } else if (shape.equalsIgnoreCase("TRIANGLE")) {
                    double b = sc.nextDouble();
                    double h = sc.nextDouble();
                    plots.add(new TrianglePlot(owner, b, h));
                }
            }
            printGardenReport(plots);
        } else {
            plots.add(new CirclePlot("Asha", 5));
            plots.add(new RectanglePlot("Ravi", 4, 6));
            plots.add(new TrianglePlot("Neha", 10, 3));
            printGardenReport(plots);
        }
        sc.close();
    }
}
