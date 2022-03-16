  @Deprecated
  public void requestPermission(Activity activity, String[] permissionsList, int requestCode) {
    List<String> permissionNeeded = new ArrayList<>();
    for (String permission : permissionsList) {
      if (ActivityCompat.checkSelfPermission(activity, permission)
          != PackageManager.PERMISSION_GRANTED) {
        permissionNeeded.add(permission);
      }
    }
    if (permissionNeeded.size() > 0) {
      ActivityCompat.requestPermissions(activity,
          permissionNeeded.toArray(new String[permissionNeeded.size()]), requestCode);
    }
  }

