    private Builder(Request request) {
      uri = request.uri;
      resourceId = request.resourceId;
      targetWidth = request.targetWidth;
      targetHeight = request.targetHeight;
      centerCrop = request.centerCrop;
      centerInside = request.centerInside;
      rotationDegrees = request.rotationDegrees;
      rotationPivotX = request.rotationPivotX;
      rotationPivotY = request.rotationPivotY;
      hasRotationPivot = request.hasRotationPivot;
      if (request.transformations != null) {
        transformations = new ArrayList<Transformation>(request.transformations);
      }
      config = request.config;
    }

