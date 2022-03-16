  @Override Bitmap decode(Request data) throws IOException {
    boolean loadFromLocalCacheOnly = retryCount == 0;

    Response response = downloader.load(data.uri, loadFromLocalCacheOnly);
    if (response == null) {
      return null;
    }

    loadedFrom = response.cached ? DISK : NETWORK;

    Bitmap result = response.getBitmap();
    if (result != null) {
      return result;
    }

    InputStream is = response.getInputStream();
    if (is == null) {
      return null;
    }
    // Sometimes response content length is zero when requests are being replayed. Haven't found
    // root cause to this but retrying the request seems safe to do so.
    if (response.getContentLength() == 0) {
      Utils.closeQuietly(is);
      throw new IOException("Received response with 0 content-length header.");
    }
    if (loadedFrom == NETWORK && response.getContentLength() > 0) {
      stats.dispatchDownloadFinished(response.getContentLength());
    }
    try {
      return decodeStream(is, data);
    } finally {
      Utils.closeQuietly(is);
    }
  }

