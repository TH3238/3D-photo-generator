package primitives;

import geometries.Intersectable.GeoPoint;

import java.util.List;

/**
 * @Param DELTA - a const parameter for ray-head offset size for shading rays.
 * @param p0-Vector's starting point
 * @param dir-The     direction of the vector
 * this class represent a ray by starting point and direction
 */
public class Ray {
    private static final double DELTA = 0.1d;
    private final Point p0;
    private final Vector dir;


    /**
     * constructor ray
     *
     * @param p0-Vector's starting point
     * @param dir-The     direction of the vector
     *                    Normalize the vector in a state that is not normalized
     */
    public Ray(Point p0, Vector dir) {
        this.p0 = p0;
        this.dir = dir.normalize();

    }

    /**
     * This class represents a ray in 3D space, defined by its starting point and direction.
     *
     * The class provides a constructor to create a ray with the given starting point, direction, and surface normal.
     * The direction vector is normalized, and a small adjustment is made to the starting point to avoid self-intersection with the surface.
     *
     * @param p  The starting point of the ray.
     * @param dir  The direction vector of the ray.
     * @param n  The surface normal vector at the starting point of the ray.
     */
    public Ray(Point p, Vector dir, Vector n) {
        this.dir = dir.normalize();
        double nv = n.dotProduct(this.dir);

        Vector delta = n.scale(DELTA);

        if (nv < 0) {
            delta = delta.scale(-1);
        }
        this.p0 = p.add(delta);
    }


    /**
     * geter of point
     *
     * @return p0-Vector's starting point
     */
    public Point getP0() {
        return p0;
    }

    /**
     * geter of vector
     *
     * @return dir-The direction of the vector
     */
    public Vector getDir() {
        return dir;
    }

    /**
     * p = p0 + tv
     * v is the direction of the ray, p0 is the stating point of the ray
     *
     * @param t scalar
     * @return point on the ray
     */
    public Point getPoint(double t) {
        return p0.add(dir.scale(t));
    }

    /**
     * find the closest point to the starting point of the ray in list of GeoPoints
     *
     * @param geoPoints list of GeoPoints
     * @return the closest GeoPoint
     */
    public GeoPoint findClosestGeoPoint(List<GeoPoint> geoPoints) {
        if (geoPoints == null) {
            return null;
        }

        GeoPoint closesGeoPoint = null;
        double minDistance = Double.MAX_VALUE;

        for (var geoPoint : geoPoints) {
            double temp = geoPoint.point.distance(p0);
            if (minDistance > temp) {
                closesGeoPoint = geoPoint;
                minDistance = temp;
            }
        }

        return closesGeoPoint;
    }

    /**
     * equals-Compares two rays
     *
     * @param o-The object for comparison
     * @return Boolean value Whether the objects are equal or not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ray)) return false;
        Ray other = (Ray) o;
        return this.p0.equals(other.p0) && dir.equals(other.dir);
    }

    /**
     * toString
     *
     * @return Threading the values
     */
    @Override
    public String toString() {
        return p0.toString() + dir.toString();
    }

    /**
     * find the closest point to the starting point of the ray in list of Points
     *
     * @param points list of Points
     * @return the closest Point
     */
    public Point findClosestPoint(List<Point> points) {
        return points == null || points.isEmpty() ? null
                : findClosestGeoPoint(points.stream()
                .map(p -> new GeoPoint(null, p))
                .toList()).point;
    }
}
