  /**
   * Determine if the navigation bar will be on the bottom of the screen, based on logic in
   * PhoneWindowManager.
   */
  static boolean isNavBarOnBottom(@NonNull Context context) {
    final Resources res = context.getResources();
    final Configuration cfg = context.getResources().getConfiguration();
    final DisplayMetrics dm = res.getDisplayMetrics();
    boolean canMove = (dm.widthPixels != dm.heightPixels &&
        cfg.smallestScreenWidthDp < 600);
    return (!canMove || dm.widthPixels < dm.heightPixels);
  }

