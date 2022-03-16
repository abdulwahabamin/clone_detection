  private int getCountOfSelectedItems() {
    int count = 0;
    List<DirectoryItem> list = directoryItemAdapter.getList();
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getSelected()) {
        count++;
      }
    }
    return count;
  }

