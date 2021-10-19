import java.util.Arrays;

/**
 * Write the specification here
 */
public final class Vector3 {

    private double[] v = {0, 0, 0};

    public Vector3(double x, double y, double z) {
        this.v[0] = x;
        this.v[1] = y;
        this.v[2] = z;
    }

    public double getX() {
        return v[0];
    }

    public double getY() {
        return v[1];
    }

    public double getZ() {
        return v[2];
    }

    public double dot(Vector3 v2) {
        int res = 0;
        for (int i = 0; i < 3; i++) {
            res += this.v[i] * v2.v[i];
        }
        return res;
    }


    public double length() {
        int res = 0;
        for (int i = 0; i < 3; i++) {
            res += this.v[i] * this.v[i];
        }
        return Math.sqrt(res);
    }

    public Vector3 cross(Vector3 v2) {
        return new Vector3(this.v[1] * v2.v[2] - this.v[2] * v2.v[1],
                this.v[2] * v2.v[0] - this.v[0] * v2.v[2],
                this.v[0] * v2.v[1] - this.v[1] * v2.v[0]);
    }

    public Vector3 norm() {
        if (this.length() == 0) {
            return new Vector3(0, 0, 0);
        }

        return new Vector3(this.v[0] / this.length(),
                this.v[1] / this.length(),
                this.v[2] / this.length());
    }

    public Vector3 scale(int lambda) {
        return new Vector3(this.v[0] * lambda,
                this.v[1] * lambda,
                this.v[2] * lambda);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector3 vector3 = (Vector3) o;
        return Arrays.equals(v, vector3.v);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(v);
    }

    @Override
    public String toString() {
        return "Vector3{" +
                "v=" + Arrays.toString(v) +
                '}';
    }
}
