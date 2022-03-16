    private void fileSearch(String directory, String query) {
      File dir = new File(directory);
      String[] list = dir.list();
      if (list != null) {
        for (String file : list) {
          DirectoryItem di = new DirectoryItem(directory, file, false);
          if (!file.startsWith(".") && file.toLowerCase().contains(query.toLowerCase())) {
            Log.e("search", "found " + file);
            result.add(di);
          }
          if (new File(di.getFilepath()).isDirectory()) {
            fileSearch(di.getFilepath(), query);
          }
        }
      }
    }

