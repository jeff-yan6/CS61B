public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    private static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        return Math.pow(Math.pow(this.xxPos - p.xxPos, 2) + Math.pow(this.yyPos - p.yyPos, 2), 0.5);
    }

    public double calcForceExertedBy(Planet p) {
        return (G*this.mass*p.mass/(Math.pow(this.calcDistance(p), 2)));
    }

    public double calcForceExertedByX(Planet p) {
        double dist = this.calcDistance(p);
        double force = this.calcForceExertedBy(p);
        return (p.xxPos - this.xxPos) / dist * force;
    }

    public double calcForceExertedByY(Planet p) {
        double dist = this.calcDistance(p);
        double force = this.calcForceExertedBy(p);
        return (p.yyPos - this.yyPos) / dist * force;
    }

    public double calcNetForceExertedByX(Planet[] p) {
        double sum = 0;
        for (Planet planet : p) {
            if (planet.equals(this)) {
                continue;
            }
            sum += this.calcForceExertedByX(planet);
        }
        return sum;
    }

    public double calcNetForceExertedByY(Planet[] p) {
        double sum = 0;
        for (Planet planet : p) {
            if (planet.equals(this)) {
                continue;
            }
            sum += this.calcForceExertedByY(planet);
        }
        return sum;
    }

    public void update(double t, double xxN, double yyN) {
        double xxA = xxN / this.mass;
        double yyA = yyN / this.mass;

        this.xxVel += xxA * t;
        this.yyVel += yyA * t;

        this.xxPos += this.xxVel*t;
        this.yyPos += this.yyVel*t;

    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, String.format("images/%s", this.imgFileName));
    }
}