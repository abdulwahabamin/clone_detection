  @Deprecated public void requestPermission(Activity activity, String permission, int requestCode) {
    if (ActivityCompat.checkSelfPermission(activity, permission)
        != PackageManager.PERMISSION_GRANTED) {
      ActivityCompat.requestPermissions(activity, new String[] { permission }, requestCode);
    }
  }

