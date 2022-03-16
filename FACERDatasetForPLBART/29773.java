  /**
   * Return the view of snackbar.
   *
   * @return the view of snackbar
   */
  public static View getView() {
    Snackbar snackbar = sReference.get();
    if (snackbar == null) return null;
    return snackbar.getView();
  }

