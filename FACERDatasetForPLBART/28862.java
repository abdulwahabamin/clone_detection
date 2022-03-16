    /**
     * Takes the response from the (web) server and checks whether the requested city was found.
     *
     * @param data The textual response from the server.
     * @return Returns true if the city was found or false otherwise (i. e. in case of 404).
     */
    boolean wasCityFound(String data);

