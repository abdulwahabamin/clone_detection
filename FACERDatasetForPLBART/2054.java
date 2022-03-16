  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    llButtons.setVisibility(View.GONE);
    if (requestCode == INTENT_MAIN && resultCode == RESULT_OK) {
      finish();
    }
    if (resultCode == RESULT_OK) {
      if (requestCode == INTENT_COPY) {
        if (data.hasExtra(DIRECTORY_COPY_TO)) {
          List<DirectoryItem> list = directoryItemAdapter.getList();
          for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSelected()) {
              DirectoryItem di = (DirectoryItem) list.get(i);
              try {
                copyFile(new File(list.get(i).getFilepath()),
                    new File(data.getStringExtra(DIRECTORY_COPY_TO)));
              } catch (Throwable throwable) {

              }
            }
          }
        }
      }
      if (requestCode == INTENT_MOVE) {
        if (data.hasExtra(DIRECTORY_COPY_TO)) {
          List<DirectoryItem> list = directoryItemAdapter.getList();
          for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSelected()) {
              DirectoryItem di = list.get(i);
              try {
                moveFile(new File(list.get(i).getFilepath()),
                    new File(data.getStringExtra(DIRECTORY_COPY_TO)));
              } catch (Throwable throwable) {

              }
            }
          }
        }
      }
    }
    super.onActivityResult(requestCode, resultCode, data);
  }

