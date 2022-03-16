  private Request(Uri uri, int resourceId, List<Transformation> transformations, int targetWidth,
      int targetHeight, boolean centerCrop, boolean centerInside, float rotationDegrees,
      float rotationPivotX, float rotationPivotY, boolean hasRotationPivot, Bitmap.Config config) {
    this.uri = uri;
    this.resourceId = resourceId;
    if (transformations == null) {
      this.transformations = null;
    } else {
      this.transformations = unmodifiableList(transformations);
    }
    this.targetWidth = targetWidth;
    this.targetHeight = targetHeight;
    this.centerCrop = centerCrop;
    this.centerInside = centerInside;
    this.rotationDegrees = rotationDegrees;
    this.rotationPivotX = rotationPivotX;
    this.rotationPivotY = rotationPivotY;
    this.hasRotationPivot = hasRotationPivot;
    this.config = config;
  }

