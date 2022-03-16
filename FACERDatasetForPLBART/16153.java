    public void saveQueueToFile(String filePath) {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();

            PrintWriter printWriter = new PrintWriter(new FileOutputStream(file), true);
            int songsSaved=0;
            for (Song song : queue) {
                if(!song.isRemote()) {
                    printWriter.println(song.get_id());
                    songsSaved++;
                }
            }

            printWriter.close();

            if(songsSaved == 0) {
                file.delete();
            }
        } catch (IOException e) {
            Log.d("save queue", "failed to save queue");
            e.printStackTrace();
        }
    }

