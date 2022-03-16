    @Override
    public int compare(DirectoryItem di1, DirectoryItem di2) {
      return Integer.valueOf(
          (int) new File(di1.getFilepath()).lastModified() - (int) new File(di2.getFilepath())
              .lastModified());
    }

