  protected HttpURLConnection openConnection(Uri uri) throws IOException {
    HttpURLConnection connection = urlFactory.open(new URL(uri.toString()));
    connection.setConnectTimeout(Utils.DEFAULT_CONNECT_TIMEOUT);
    connection.setReadTimeout(Utils.DEFAULT_READ_TIMEOUT);
    return connection;
  }

