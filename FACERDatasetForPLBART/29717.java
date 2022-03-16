  /**
   * Set the alpha component of {@code color} to be {@code alpha}.
   */
  static @CheckResult
  @ColorInt
  int modifyAlpha(@ColorInt int color,
                  @IntRange(from = 0, to = 255) int alpha) {
    return (color & 0x00ffffff) | (alpha << 24);
  }

