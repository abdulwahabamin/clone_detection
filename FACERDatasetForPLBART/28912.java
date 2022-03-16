    /**
     * @param latLon     The center of the square.
     * @param edgeLength The edge length of the square.
     * @return Returns the square with the given edge length where the given latLon argument is the center of the square.
     * The first value in the return array is the left longitude, second bottom latitude, third right longitude, fourth
     * top latitude.
     */
    private static double[] getBoundingBox(double[] latLon, int edgeLength) {
        if (latLon.length != 2) {
            throw new IllegalArgumentException("Expected an array with two elements where the first is the longitude and the second the latitude");
        }

        // Compute the longitude difference
        // The formulas have been taken from the answer by Jim Lewis as of 2016-08-12
        // http://stackoverflow.com/questions/1253499/simple-calculations-for-working-with-lat-lon-km-distance
        double distance = edgeLength >> 1;
        double latDif = (distance / 110.574);
        // Need to do a degree to radian conversion here
        double lonDif = (distance / (111.32 * Math.cos((latLon[0] * Math.PI) / 180)));

        // Compute and return the square
        return new double[]{
                latLon[1] - lonDif,
                latLon[0] - latDif,
                latLon[1] + lonDif,
                latLon[0] + latDif
        };
    }

