    /** Create the immutable {@link Request} object. */
    public Request build() {
      if (centerInside && centerCrop) {
        throw new IllegalStateException("Center crop and center inside can not be used together.");
      }
      if (centerCrop && targetWidth == 0) {
        throw new IllegalStateException("Center crop requires calling resize.");
      }
      if (centerInside && targetWidth == 0) {
        throw new IllegalStateException("Center inside requires calling resize.");
      }
      return new Request(uri, resourceId, transformations, targetWidth, targetHeight, centerCrop,
          centerInside, rotationDegrees, rotationPivotX, rotationPivotY, hasRotationPivot, config);
    }

