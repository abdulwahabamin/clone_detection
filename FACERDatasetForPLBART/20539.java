  /**
   * Callback invoked right before your request is submitted.
   * <p>
   * <strong>Note:</strong> The passed {@link Drawable} may be {@code null} if none has been
   * specified via {@link RequestCreator#placeholder(android.graphics.drawable.Drawable)}
   * or {@link RequestCreator#placeholder(int)}.
   */
  void onPrepareLoad(Drawable placeHolderDrawable);

