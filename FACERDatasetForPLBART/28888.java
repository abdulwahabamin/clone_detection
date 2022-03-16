    /**
     * Builds the URL for the OpenWeatherMap API that can be used to query the weather for several
     * cities within a given rectangle.
     *
     * @param boundingBox An array consisting of four value: The first value is the left longitude,
     *                    second bottom latitude, third right longitude, fourth top latitude.
     * @param mapZoom     The map zoom which determines the granularity of the OpenWeatherMap response.
     *                    Lower values will return less cities.
     * @return Returns the URL for the OpenWeatherMap API to retrieve the weather data of cities
     * within the specified bounding box.
     */
    public String getUrlForQueryingRadiusSearch(double[] boundingBox, int mapZoom) {
        return String.format(
                "%sbox/city?bbox=%s,%s,%s,%s,%s&cluster=yes&appid=%s",
                OwmApiData.BASE_URL,
                boundingBox[0],
                boundingBox[1],
                boundingBox[2],
                boundingBox[3],
                mapZoom,
                OwmApiData.getAPI_KEY()
        );
    }

