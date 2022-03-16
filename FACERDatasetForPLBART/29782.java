  /**
   * Set the action.
   *
   * @param text     The text.
   * @param listener The click listener.
   * @return the single {@link SnackbarUtil} instance
   */
  public SnackbarUtil setAction(@NonNull final CharSequence text,
                                @NonNull final View.OnClickListener listener) {
    return setAction(text, COLOR_DEFAULT, listener);
  }

