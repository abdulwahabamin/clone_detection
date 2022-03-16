    private float computeDistance(long t, float xi, float vi, float ai, Long targetTime,
                                  Float vTarget) {
        if (targetTime == null || t < targetTime) {
            // distance covered with linear acceleration
            // distance = xi + vi * t + 1/2 * a * t^2
            return xi + vi * t + 0.5f * ai * t * t;
        } else {
            // distance covered with linear acceleration + distance covered with max velocity
            // distance = xi + vi * targetTime + 1/2 * a * targetTime^2
            //     + (t - targetTime) * vTarget;
            return xi + vi * targetTime + 0.5f * ai * targetTime * targetTime
                    + (t - targetTime) * vTarget;
        }
    }

