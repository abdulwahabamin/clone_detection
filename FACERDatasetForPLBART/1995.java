  private void makeNewFolder(String folder) {
    File file = null;
    boolean bool = false;
    String filepath;
    if (path.endsWith(File.separator)) {
      filepath = path + folder;
    } else {
      filepath = path + File.separator + folder;
    }
    try {
      file = new File(filepath);
      bool = file.mkdir();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

