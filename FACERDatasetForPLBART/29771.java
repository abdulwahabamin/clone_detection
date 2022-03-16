  /**
   * Set the view to find a parent from.
   *
   * @param view The view to find a parent from.
   * @return the single {@link SnackbarUtil} instance
   */
  public static SnackbarUtil with(@NonNull final View view) {
    return new SnackbarUtil(view);
  }

