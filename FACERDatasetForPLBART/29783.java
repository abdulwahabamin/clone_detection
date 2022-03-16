  /**
   * Set the action.
   *
   * @param text     The text.
   * @param color    The color of text.
   * @param listener The click listener.
   * @return the single {@link SnackbarUtil} instance
   */

  public SnackbarUtil setAction(@NonNull final CharSequence text,
                                @ColorInt final int color,
                                @NonNull final View.OnClickListener listener) {
    this.actionText = text;
    this.actionTextColor = color;
    this.actionListener = listener;
    return this;
  }

