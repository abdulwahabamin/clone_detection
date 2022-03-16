    /**
     * If the query doesn't contain any letters, it is assumed to contain a latitude and longitude.
     *
     * @return URL to be used to retrieve the cities, satisfying user's query
     */
    private URL getUrlUsingGeographicalCoordinates(Context context) {
        // we split the query into latitude and longitude
        String providedLatitude;
        String providedLongitude;

        if (query.contains(COORDINATES_SEPARATOR)) {
            String[] coordinates = query.split(COORDINATES_SEPARATOR);
            providedLatitude = coordinates[0];
            providedLongitude = coordinates[1];

            String processedLatitude = processProvidedCoordinate(providedLatitude, true);
            String processedLongitude = processProvidedCoordinate(providedLongitude, false);
            if (processedLatitude == null || processedLongitude == null) {
                return null;
            } else {
                return new OpenWeatherMapUrl(context).
                        getAvailableCitiesListUrlByGeographicalCoordinates(providedLatitude,
                                providedLongitude);
            }
        } else {
            invalidQueryListener.showAlertDialog(
                    R.string.coordinates_error_message_missing_separator);
            return null;
        }

    }

