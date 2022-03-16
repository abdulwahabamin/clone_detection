    protected static long computeBound(float initialPos, float velocity, float acceleration,
                                       Long targetTime, Float targetVelocity, int minBound, int maxBound) {
        if (acceleration != 0) {
            // non-zero acceleration
            final int bound = acceleration > 0 ? maxBound : minBound;

            if (targetTime == null || targetTime < 0) {
                // https://www.wolframalpha.com/input/
                // ?i=solve+for+t+in+(d+%3D+x+%2B+v+*+t+%2B+0.5+*+a+*+t+*+t)

                final double tmp = Math.sqrt(
                        2 * acceleration * bound - 2 * acceleration * initialPos
                                + velocity * velocity);

                final double firstTime = (-tmp - velocity) / acceleration;
                if (firstTime > 0) {
                    return (long) firstTime;
                }

                final double secondTime = (tmp - velocity) / acceleration;
                if (secondTime > 0) {
                    return (long) secondTime;
                }

                return Long.MAX_VALUE;
            } else {
                // d = x + v * tm + 0.5 * a * tm * tm + tv * (t - tm)
                // d - x - v * tm - 0.5 * a * tm * tm = tv * t - tv * tm
                // d - x - v * tm - 0.5 * a * tm * tm + tv * tm = tv * t
                // t = (d - x - v * tm - 0.5 * a * tm * tm + tv * tm) / tv

                final double time =
                        (bound - initialPos - velocity * targetTime -
                                0.5 * acceleration * targetTime * targetTime +
                                targetVelocity * targetTime) /
                                targetVelocity;

                return time > 0 ? (long) time : Long.MAX_VALUE;
            }
        } else {
            float actualVelocity = targetTime == null ? velocity : targetVelocity;
            final int bound = actualVelocity > 0 ? maxBound : minBound;
            if (actualVelocity != 0) {
                final double time = (bound - initialPos) / actualVelocity;
                return time > 0 ? (long) time : Long.MAX_VALUE;
            } else {
                return Long.MAX_VALUE;
            }
        }
    }

