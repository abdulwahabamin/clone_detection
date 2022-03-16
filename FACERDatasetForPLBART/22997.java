    private void getPlayList(File home) {
        try {
            if (!(home == null)) {
                File[] files = home.listFiles(new FileExtensionFilter());
                if (!(files == null)) {
                    if (files.length > 0) {
                        for (File file : files) {
                            if (file.isDirectory()) {
                                getPlayList(file);
                            } else if (file.isFile()) {
                                addSong(file);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            Log.d("",e.getLocalizedMessage());
        }
    }

