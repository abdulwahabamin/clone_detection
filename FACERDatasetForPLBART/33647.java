    /**
     * Obtains a bundle with the arguments, to be used to instantiate a new weather information
     * fragment.
     *
     * @param cityName   the name of the city for which the weather information was requested and
     *                   obtained
     * @param jsonString JSON weather information data in textual form
     * @return an argument bundle
     */
    private static Bundle getArgumentBundle(String cityName, String jsonString) {
        Bundle args = new Bundle();
        args.putString(CITY_NAME, cityName);
        args.putString(JSON_STRING, jsonString);
        return args;
    }

