  public DirectoryItem(String filePath) {
    int a = 0;
    for (int i = filePath.length() - 1; i >= 0; i--) {
      if (filePath.charAt(i) == '/') {
        a = i;
        break;
      }
    }
    this.name = filePath.substring(a + 1);
    this.path = filePath.substring(0, a);
  }

