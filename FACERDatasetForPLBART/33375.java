    /**
     * Opens and sets the network connection.
     *
     * @param url a web address for the JSON data
     * @return a connection pointing to a JSON data resource
     * @throws java.io.IOException if there are connection problems
     */
    private HttpURLConnection getConnection(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setReadTimeout(TIMEOUT);
        connection.setConnectTimeout(TIMEOUT * 2);
        connection.setRequestMethod(GET);
        connection.setDoInput(true);
        connection.connect();
        return connection;
    }

