    /**
     * Obtains the URL to be used to retrieve the cities, satisfying user's query.
     */
    URL getUrlForFindCitiesQuery(Context context) {
        URL url;
        boolean doesQueryContainAnyLetters = doesQueryContainAnyLetters();
        if (doesQueryContainAnyLetters) {
            url = new OpenWeatherMapUrl(context).getAvailableCitiesListUrl(query);
        } else {
            url = getUrlUsingGeographicalCoordinates(context);
        }

        invalidQueryListener = null;
        return url;
    }

