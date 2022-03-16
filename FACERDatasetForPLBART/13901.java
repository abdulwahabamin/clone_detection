  public boolean hasPermission(String[] permissionsList) {
    for (String permission : permissionsList) {
      if (ActivityCompat.checkSelfPermission(mActivity, permission)
          != PackageManager.PERMISSION_GRANTED) {
        return false;
      }
    }
    return true;
  }

