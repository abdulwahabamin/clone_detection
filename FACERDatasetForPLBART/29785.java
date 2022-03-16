  /**
   * Show the snackbar.
   */
  public Snackbar show() {
    final View view = this.view;
    if (view == null) return null;
    if (messageColor != COLOR_DEFAULT) {
      SpannableString spannableString = new SpannableString(message);
      ForegroundColorSpan colorSpan = new ForegroundColorSpan(messageColor);
      spannableString.setSpan(
          colorSpan, 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
      );
      sReference = new WeakReference<>(Snackbar.make(view, spannableString, duration));
    } else {
      sReference = new WeakReference<>(Snackbar.make(view, message, duration));
    }
    final Snackbar snackbar = sReference.get();
    final View snackbarView = snackbar.getView();
    if (bgResource != -1) {
      snackbarView.setBackgroundResource(bgResource);
    } else if (bgColor != COLOR_DEFAULT) {
      snackbarView.setBackgroundColor(bgColor);
    }
    if (bottomMargin != 0) {
      ViewGroup.MarginLayoutParams params =
          (ViewGroup.MarginLayoutParams) snackbarView.getLayoutParams();
      params.bottomMargin = bottomMargin;
    }
    if (actionText.length() > 0 && actionListener != null) {
      if (actionTextColor != COLOR_DEFAULT) {
        snackbar.setActionTextColor(actionTextColor);
      }
      snackbar.setAction(actionText, actionListener);
    }
    snackbar.show();
    return snackbar;
  }

