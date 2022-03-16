  @Override public String toString() {
    final StringBuilder sb = new StringBuilder("Request{");
    if (resourceId > 0) {
      sb.append(resourceId);
    } else {
      sb.append(uri);
    }
    if (transformations != null && !transformations.isEmpty()) {
      for (Transformation transformation : transformations) {
        sb.append(' ').append(transformation.key());
      }
    }
    if (targetWidth > 0) {
      sb.append(" resize(").append(targetWidth).append(',').append(targetHeight).append(')');
    }
    if (centerCrop) {
      sb.append(" centerCrop");
    }
    if (centerInside) {
      sb.append(" centerInside");
    }
    if (rotationDegrees != 0) {
      sb.append(" rotation(").append(rotationDegrees);
      if (hasRotationPivot) {
        sb.append(" @ ").append(rotationPivotX).append(',').append(rotationPivotY);
      }
      sb.append(')');
    }
    if (config != null) {
      sb.append(' ').append(config);
    }
    sb.append('}');

    return sb.toString();
  }

