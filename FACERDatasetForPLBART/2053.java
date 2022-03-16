  private void copyFile(File file, File dir) throws IOException {
    if (file.isDirectory()) {
      File outputFile = new File(dir, file.getName());
      outputFile.mkdir();
      for (File f : file.listFiles()) {
        copyFile(f, outputFile);
      }
    } else {
      File newFile = new File(dir, file.getName());
      FileChannel outputChannel = null;
      FileChannel inputChannel = null;
      try {
        outputChannel = new FileOutputStream(newFile).getChannel();
        inputChannel = new FileInputStream(file).getChannel();
        inputChannel.transferTo(0, inputChannel.size(), outputChannel);
        inputChannel.close();
      } finally {
        if (inputChannel != null) {
          inputChannel.close();
        }
        if (outputChannel != null) {
          outputChannel.close();
        }
      }
    }
  }

