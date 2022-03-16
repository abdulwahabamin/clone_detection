  private void delete(String fileToDelete) {
    File F = new File(fileToDelete);
    if (!F.exists()) {
      return;
    }
    if (F.isDirectory()) {
      for (File file : F.listFiles()) {
        delete(file.getPath());
      }
      F.delete();
    } else {
      F.delete();
    }
  }

