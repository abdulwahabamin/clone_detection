  /**
   * Add view to the snackbar.
   * <p>Call it after {@link #show()}</p>
   *
   * @param layoutId The id of layout.
   * @param params   The params.
   */
  public static void addView(@LayoutRes final int layoutId,
                             @NonNull final ViewGroup.LayoutParams params) {
    final View view = getView();
    if (view != null) {
      view.setPadding(0, 0, 0, 0);
      Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) view;
      View child = LayoutInflater.from(view.getContext()).inflate(layoutId, null);
      layout.addView(child, -1, params);
    }
  }

