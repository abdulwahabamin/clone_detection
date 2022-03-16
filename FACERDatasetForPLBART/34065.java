    public static int windDirectionDegreeToIndex(double degree, int numberOfDirections) {
        // to be on the safe side
        degree %= 360;
        if(degree < 0) degree += 360;

        degree += 180 / numberOfDirections; // add offset to make North start from 0

        int direction = (int)Math.floor(degree * numberOfDirections / 360);

        return direction % numberOfDirections;
    }

