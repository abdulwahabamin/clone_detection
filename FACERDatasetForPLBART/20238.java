  @Override Bitmap decode(Request data) throws IOException {
    String filePath = data.uri.toString().substring(BYTE_PREFIX_LENGTH);
    Bitmap bitmap = null;
    try {
        bitmap = decodeAsset(filePath);
    } catch (Exception e) {
        e.printStackTrace();
    }

    return bitmap;
  }

