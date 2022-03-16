  Bitmap decodeAsset(String filePath) throws IOException {
    final BitmapFactory.Options options = createBitmapOptions(data);
    byte[] imageData = null;
    if (requiresInSampleSize(options)) {
        calculateInSampleSize(data.targetWidth, data.targetHeight, options);
    }

    try {
        MediaMetadataRetriever mmdr = new MediaMetadataRetriever();
        mmdr.setDataSource(filePath);
        imageData = mmdr.getEmbeddedPicture();
    } catch (Exception e) {
        return null;
    }

    ByteArrayInputStream is = new ByteArrayInputStream(imageData);
    try {
      return BitmapFactory.decodeStream(is, null, options);
    } finally {
      Utils.closeQuietly(is);
    }
  }

