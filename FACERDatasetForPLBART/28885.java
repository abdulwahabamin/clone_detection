    /**
     * Builds the URL for the OpenWeatherMap API that can be used to query the weather for multiple
     * cities.
     *
     * @param groupID A list of comma-separated city IDs.
     * @return Returns the URL that can be used to query the weather for the given cities.
     */
    protected String getUrlForQueryingGroupIDs(String groupID) {
        return String.format(
                "%sgroup?id=%s&units=metric&appid=%s",
                OwmApiData.BASE_URL,
                groupID,
                OwmApiData.getAPI_KEY()
        );
    }

