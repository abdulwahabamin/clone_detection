  @Override
  public void onBackPressed() {
    if (directoryItemAdapter.isCheckBoxVisibility) {
      llButtons.setVisibility(View.GONE);
      directoryItemAdapter.isCheckBoxVisibility = false;
    } else {
      finish();
    }
  }

