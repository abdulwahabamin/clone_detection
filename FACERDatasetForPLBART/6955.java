    private void searchByPath(String path) {
        File[] files = new File(path).listFiles();
        filenum += files.length;
        publishProgress(filenum);
        for (int i = 0; i < files.length; i++) {
            File f = files[i];
            if (f.isDirectory()) {
                searchByPath(path + "/" + f.getName());
            } else {
                if (f.getName().contains(query)) {
                    searchfilemap.put(files[i], files[i].getName());
                }
            }
        }

    }

