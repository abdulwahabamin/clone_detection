  public void requestPermission(String permission, int requestCode) {
    if (ActivityCompat.checkSelfPermission(mActivity, permission)
        != PackageManager.PERMISSION_GRANTED) {
      ActivityCompat.requestPermissions(mActivity, new String[] { permission }, requestCode);
    }
  }

