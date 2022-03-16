  /**
   * Set the alpha component of {@code color} to be {@code alpha}.
   */
  public static @CheckResult
  @ColorInt
  int modifyAlpha(@ColorInt int color,
                  @FloatRange(from = 0f, to = 1f) float alpha) {
    return modifyAlpha(color, (int) (255f * alpha));
  }

