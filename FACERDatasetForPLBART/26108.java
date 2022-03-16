    /**
     *
     * @param fileId The fileId to write to Disk.
     */
    public static void writeToFile(String fileId, final Object fileObj) {
        if(fileObj==null) {
            return;
        }
        final File file = buildFile(fileId);
        if (exists(file)) {
            TaskScheduler.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        String content = fileObj.getClass().equals(String.class)
                                ?fileObj.toString(): JsonHelper.toJson(fileObj);
                        FileWriter writer = new FileWriter(file);
                        writer.write(content);
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

