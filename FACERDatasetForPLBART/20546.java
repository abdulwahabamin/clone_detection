  protected HttpURLConnection openConnection(Uri path) throws IOException {
    HttpURLConnection connection = (HttpURLConnection) new URL(path.toString()).openConnection();
    connection.setConnectTimeout(Utils.DEFAULT_CONNECT_TIMEOUT);
    connection.setReadTimeout(Utils.DEFAULT_READ_TIMEOUT);
    return connection;
  }

