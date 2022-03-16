    private static int rotate(int value, int offset, int lowerBound, int upperBound) {
        int windowSize = upperBound - lowerBound;

        value += offset;
        if (value < lowerBound) {
            value += windowSize;
        } else if (value >= upperBound) {
            value -= windowSize;
        }
        return value;
    }

