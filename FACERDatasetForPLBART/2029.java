  @Override
  public void onBackPressed() {
    if (directoryItemAdapter.isCheckBoxVisibility) {
      directoryItemAdapter.isCheckBoxVisibility = false;
    } else if (path.equals("/")) {
      finish();
    } else {
      path = cutPath(path);
    }
    llButtons.setVisibility(View.GONE);
    refreshList();
  }

