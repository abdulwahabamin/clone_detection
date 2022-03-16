    /**
     * Extracts JSON data from the provided web page as an {@link java.io.InputStream},
     * and converts the stream to a string.
     *
     * @param url a web address for the JSON data
     * @return a string representing the JSON data, or null if there are
     * connection problems
     * @throws java.io.IOException if there are connection problems
     */
    public String getJsonString(URL url) throws IOException {
        StringBuilder stringBuilder = null;
        InputStream inputStream = null;
        try {
            HttpURLConnection connection = getConnection(url);
            inputStream = connection.getInputStream();
            stringBuilder = readData(inputStream);
            connection.disconnect();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return stringBuilder.toString();
    }

