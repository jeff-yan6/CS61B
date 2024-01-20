public class NBody {
    public static double readRadius(String fileName) {
        In in = new In(fileName);
        int num = in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String fileName) {
        In in = new In(fileName);
        int num = in.readInt();
        double radius = in.readDouble();
        Planet[] p = new Planet[num];

        for(int i = 0 ; i < num ; ++i) {
            p[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
        }
        return p;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] p = readPlanets(filename);

        StdDraw.setXscale(0, radius);
        StdDraw.setYscale(0, radius);

        StdOut.printf("%f %f\n", T, dt);
        double t = 0;
        while(t <= T) {
//
            double[] xForces = new double[p.length];
            double[] yForces = new double[p.length];
            for(int i = 0 ; i < p.length ; ++i) {
                xForces[i] = p[i].calcNetForceExertedByX(p);
                yForces[i] = p[i].calcNetForceExertedByY(p);
            }
            for(int i = 0 ; i < p.length ; ++i) {
                p[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");

            for(int i = 0 ; i < p.length ; ++i) {
                StdOut.printf("%f %f ", p[i].xxPos, p[i].yyPos);
                p[i].draw();
            }
            StdOut.print("\n");
            StdDraw.enableDoubleBuffering();
            StdDraw.pause(10);
            t += dt;
        }

        StdOut.printf("%d\n", p.length);
        StdOut.printf("%.2e\n", radius);
        for(int i = 0 ; i < p.length ; ++i) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n", p[i].xxPos, p[i].yyPos,
                    p[i].xxVel, p[i].yyVel, p[i].mass, p[i].imgFileName);
        }
    }
}