  /**
   * Callback indicating the image could not be successfully loaded.
   * <p>
   * <strong>Note:</strong> The passed {@link Drawable} may be {@code null} if none has been
   * specified via {@link RequestCreator#error(android.graphics.drawable.Drawable)}
   * or {@link RequestCreator#error(int)}.
   */
  void onBitmapFailed(Drawable errorDrawable);

