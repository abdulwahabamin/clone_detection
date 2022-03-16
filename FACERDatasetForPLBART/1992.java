  private String cutPath(String path) {
    do {
      path = path.substring(0, path.length() - 1);
    } while (path.charAt(path.length() - 1) != '/');
    return path;
  }

