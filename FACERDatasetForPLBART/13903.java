  public void requestPermission(String[] permissionsList, int requestCode) {
    List<String> permissionNeeded = new ArrayList<>();
    for (String permission : permissionsList) {
      if (ActivityCompat.checkSelfPermission(mActivity, permission)
          != PackageManager.PERMISSION_GRANTED) {
        permissionNeeded.add(permission);
      }
    }
    if (permissionNeeded.size() > 0) {
      ActivityCompat.requestPermissions(mActivity,
          permissionNeeded.toArray(new String[permissionNeeded.size()]), requestCode);
    }
  }

