  public String getFilepath() {
    String filepath;
    if (getPath().endsWith(File.separator)) {
      filepath = getPath() + getName();
    } else {
      filepath = getPath() + File.separator + getName();
    }
    return filepath;
  }

