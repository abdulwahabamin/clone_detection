  /**
   * Dismiss the snackbar.
   */
  public static void dismiss() {
    if (sReference != null && sReference.get() != null) {
      sReference.get().dismiss();
      sReference = null;
    }
  }

