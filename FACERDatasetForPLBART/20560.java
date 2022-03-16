  static String createKey(Request data, StringBuilder builder) {
    if (data.uri != null) {
      String path = data.uri.toString();
      builder.ensureCapacity(path.length() + KEY_PADDING);
      builder.append(path);
    } else {
      builder.ensureCapacity(KEY_PADDING);
      builder.append(data.resourceId);
    }
    builder.append('\n');

    if (data.rotationDegrees != 0) {
      builder.append("rotation:").append(data.rotationDegrees);
      if (data.hasRotationPivot) {
        builder.append('@').append(data.rotationPivotX).append('x').append(data.rotationPivotY);
      }
      builder.append('\n');
    }
    if (data.targetWidth != 0) {
      builder.append("resize:").append(data.targetWidth).append('x').append(data.targetHeight);
      builder.append('\n');
    }
    if (data.centerCrop) {
      builder.append("centerCrop\n");
    } else if (data.centerInside) {
      builder.append("centerInside\n");
    }

    if (data.transformations != null) {
      //noinspection ForLoopReplaceableByForEach
      for (int i = 0, count = data.transformations.size(); i < count; i++) {
        builder.append(data.transformations.get(i).key());
        builder.append('\n');
      }
    }

    return builder.toString();
  }

