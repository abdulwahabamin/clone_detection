    private static short mpsToBft(double speed) {
        if (speed < 0.51d) {
            return 0;
        } else if (speed < 2.06d) {
            return 1;
        } else if (speed < 3.60d) {
            return 2;
        } else if (speed < 5.66d) {
            return 3;
        } else if (speed < 8.23d) {
            return 4;
        } else if (speed < 11.32d) {
            return 5;
        } else if (speed < 14.40d) {
            return 6;
        } else if (speed < 17.49d) {
            return 7;
        } else if (speed < 21.09d) {
            return 8;
        } else if (speed < 24.69d) {
            return 9;
        } else if (speed < 28.81d) {
            return 10;
        } else if (speed < 32.92d) {
            return 11;
        } else {
            return 12;
        }
    }

