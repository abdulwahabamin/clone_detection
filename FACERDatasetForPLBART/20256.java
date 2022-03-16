  @Override Bitmap decode(Request data) throws IOException {
    InputStream is = null;
    try {
      is = getInputStream();
      return decodeStream(is, data);
    } finally {
      Utils.closeQuietly(is);
    }
  }

