    /**
     * Get all files from a directory recursively and add it to the queue
     * @param directoryName Directory name
     */
    public void queueDirectory(String directoryName) {
        currentlyPlaying = 0;
        File directory = new File(directoryName);
        String fileName;
        Pattern r = Pattern.compile(FILE_PATTERN);

        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                fileName = file.toString();
                Matcher m = r.matcher(fileName);
                if (m.find()) {
                    Log.i("MediaPlayer", "Queue file " + fileName);
                    filesQueue.add(new Music(fileName));
                }
            } else if (file.isDirectory()) {
                queueDirectory(file.getAbsolutePath());
            }
        }
    }

