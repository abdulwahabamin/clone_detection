  @Override Bitmap decode(Request data) throws IOException {
    ContentResolver contentResolver = context.getContentResolver();
    setExifRotation(getExifOrientation(contentResolver, data.uri));
    String mimeType = contentResolver.getType(data.uri);
    boolean isVideo = mimeType != null && mimeType.startsWith("video/");

    if (data.hasSize()) {
      PicassoKind picassoKind = getPicassoKind(data.targetWidth, data.targetHeight);
      if (!isVideo && picassoKind == FULL) {
        return super.decode(data);
      }

      long id = parseId(data.uri);

      BitmapFactory.Options options = createBitmapOptions(data);
      options.inJustDecodeBounds = true;

      calculateInSampleSize(data.targetWidth, data.targetHeight, picassoKind.width,
          picassoKind.height, options);

      Bitmap result;

      if (isVideo) {
        // Since MediaStore doesn't provide the full screen kind thumbnail, we use the mini kind
        // instead which is the largest thumbnail size can be fetched from MediaStore.
        int kind = (picassoKind == FULL) ? Video.Thumbnails.MINI_KIND : picassoKind.androidKind;
        result = Video.Thumbnails.getThumbnail(contentResolver, id, kind, options);
      } else {
        result =
            Images.Thumbnails.getThumbnail(contentResolver, id, picassoKind.androidKind, options);
      }

      if (result != null) {
        return result;
      }
    }

    return super.decode(data);
  }

