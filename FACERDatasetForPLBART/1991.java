  @Override
  public void onBackPressed() {
    if (path.equals("/")) {
      finish();
    } else {
      path = cutPath(path);
    }
    refreshList();

  }

