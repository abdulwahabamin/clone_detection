    public static long getTwoPower(int y) {
        if (y == 0) {
            return 1;
        }
        long result = 2;
        for (int i = 0; i < (y - 1); i++) {
            result *= 2;
        }
        return result;
    }

