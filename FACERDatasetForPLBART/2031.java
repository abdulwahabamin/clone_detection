  private void refreshList() {
    items.clear();
    File dir = new File(path);
    String[] list = dir.list();
    if (list != null) {
      for (String file : list) {
        if (!file.startsWith(".")) {
          items.add(new DirectoryItem(path, file, false));
        }
      }
    }
    horizontalList = getCurrentPathButtonsList();
    if (horizontalList.size() > 1) {
      horizontalList.remove(0);
    }
    horizontalAdapter.updateHorizontalList(horizontalList);
    Collections.sort(items, comparator);
    directoryItemAdapter.updateList(items);
  }

