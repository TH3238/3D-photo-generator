package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

/**
 * interface for light sources in some scene
 */
public interface LightSource {
    /**
     * get Intensity in point
     *
     * @param p
     * @return Color in point
     */
    public Color getIntensity(Point p);

    /**
     * Returns a vector coming out of the lighting source to the object
     *
     * @param p
     * @return Vector
     */
    public Vector getL(Point p);

    /**
     * gets distance of light
     *
     * @param point
     * @return distance
     */
    double getDistance(Point point);
}
