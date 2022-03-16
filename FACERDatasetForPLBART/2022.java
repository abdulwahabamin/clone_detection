    private String getQiuckPath(int index) {
      String quickPath = "/";
      for (int i = 0; i <= index; i++) {
        quickPath += horizontalList.get(i) + "/";
      }
      return quickPath;
    }

