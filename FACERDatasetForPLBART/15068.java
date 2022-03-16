    /**
     * Creates a new {@link HttpURLConnection}, sets the proxy, if available,
     * and sets the User-Agent property.
     * 
     * @param url URL to connect to
     * @return a new connection.
     * @throws IOException if an I/O exception occurs.
     */
    public HttpURLConnection openConnection(String url) throws IOException {
        URL u = new URL(url);
        HttpURLConnection urlConnection;
        urlConnection = (HttpURLConnection)u.openConnection();
        urlConnection.setRequestProperty("User-Agent", userAgent);
        urlConnection.setUseCaches(true);
        return urlConnection;
    }

