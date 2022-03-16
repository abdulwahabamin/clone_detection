  /**
   * Add view to the snackbar.
   * <p>Call it after {@link #show()}</p>
   *
   * @param child  The child view.
   * @param params The params.
   */
  public static void addView(@NonNull final View child,
                             @NonNull final ViewGroup.LayoutParams params) {
    final View view = getView();
    if (view != null) {
      view.setPadding(0, 0, 0, 0);
      Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) view;
      layout.addView(child, params);
    }
  }

