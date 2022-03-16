    public float getInterpolation(float t) {
        if (type == EasingType.Type.IN) {
            return in(t);
        } else if (type == EasingType.Type.OUT) {
            return out(t);
        } else if (type == EasingType.Type.INOUT) {
            return inout(t);
        }

        return 0;
    }

