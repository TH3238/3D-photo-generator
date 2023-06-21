package primitives;

/**
 * this class gives factors of material and the texture of the geometry.
 * geometries objects can have the same material.
 *
 * @author tehila and esther malka
 */
public class Material {

    /**
     * diffusive
     */
    public Double3 kD = new Double3(0, 0, 0);
    /**
     * specular
     */
    public Double3 kS = new Double3(0, 0, 0);
    /**
     * Discount coefficient for transparency
     */
    public Double3 kT = new Double3(0, 0, 0);
    /**
     * Coefficient of attenuation for reflection
     */
    public Double3 kR = new Double3(0, 0, 0);
    public int nShininess = 0;

//region Getters
    public double Glossy = 0;

    /**
     * getting of nShininess
     *
     * @return nShininess
     */
    public int getnShininess() {
        return nShininess;
    }

    /**
     * getting of kD
     *
     * @return kD
     */
    public Double3 getkD() {
        return kD;
    }

    //region Setters
    // ** all setters implements the Builder Design Pattern **//
    public Material setkD(Double3 kD) {
        this.kD = kD;
        return this;
    }

    public Material setkD(Double kD) {
        this.kD = new Double3(kD);
        return this;
    }
    //endregion

    /**
     * getting of kS
     *
     * @return kS
     */
    public Double3 getkS() {
        return kS;
    }

    public Material setkS(Double3 kS) {
        this.kS = kS;
        return this;
    }

    public Material setkS(Double kS) {
        this.kS = new Double3(kS);
        return this;
    }

    /**
     * getting of kD
     *
     * @return kD
     */
    public Double3 getkT() {
        return kT;
    }

    public Material setkT(Double3 kT) {
        this.kT = kT;
        return this;
    }

    public Material setkT(Double kT) {
        this.kT = new Double3(kT);
        return this;
    }

    /**
     * getting of kD
     *
     * @return kD
     */
    public Double3 getkR() {
        return kR;
    }

    public Material setkR(Double3 kR) {
        this.kR = kR;
        return this;
    }

    public Material setkR(Double kR) {
        this.kR = new Double3(kR);
        return this;
    }

    public Material setnshininess(int nShininess) {
        this.nShininess = nShininess;
        return this;
    }

    public double getGlossy() {
        return Glossy;
    }

    public Material setGlossy(double Glossy) {
        this.Glossy = Glossy;
        return this;
    }

    //endregion
}
