package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

/**
 * Directional Light with constant light intensity and direction
 */
public class DirectionalLight extends Light implements LightSource {
    private Vector direction;

    /**
     * Constructor to a directional light object
     *
     * @param intensity Color - color parameter of directional light source
     * @param direction Vector - direction parameter of directional light source
     */
    public DirectionalLight(Color intensity, Vector direction) {
        super(intensity);
        this.direction = direction.normalize();
    }

    /**
     * Implementation of get Intesity of interface LightSource
     */
    @Override
    public Color getIntensity(Point p) {

        return getIntensity();
    }

    /**
     * Implementation of getL of interface LightSource
     * direction of directional light
     */
    @Override
    public Vector getL(Point p) {

        return direction;
    }

    @Override
    public double getDistance(Point point) {

        return Double.POSITIVE_INFINITY;
    }
}
