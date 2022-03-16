  @Override public Response load(Uri uri, boolean localCacheOnly) throws IOException {
    HttpURLConnection connection = openConnection(uri);
    connection.setUseCaches(true);
    if (localCacheOnly) {
      connection.setRequestProperty("Cache-Control", "only-if-cached,max-age=" + Integer.MAX_VALUE);
    }

    int responseCode = connection.getResponseCode();
    if (responseCode >= 300) {
      connection.disconnect();
      throw new ResponseException(responseCode + " " + connection.getResponseMessage());
    }

    String responseSource = connection.getHeaderField(RESPONSE_SOURCE_OKHTTP);
    if (responseSource == null) {
      responseSource = connection.getHeaderField(RESPONSE_SOURCE_ANDROID);
    }

    long contentLength = connection.getHeaderFieldInt("Content-Length", -1);
    boolean fromCache = parseResponseSourceHeader(responseSource);

    return new Response(connection.getInputStream(), fromCache, contentLength);
  }

