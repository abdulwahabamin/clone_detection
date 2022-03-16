  @Deprecated public boolean hasPermission(Activity activity, String[] permissionsList) {
    for (String permission : permissionsList) {
      if (ActivityCompat.checkSelfPermission(activity, permission)
          != PackageManager.PERMISSION_GRANTED) {
        return false;
      }
    }
    return true;
  }

