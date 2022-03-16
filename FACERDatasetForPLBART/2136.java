    public static FileModel getDirectorySize(File directory, AddToDatabaseCallback callback) {
        final File[] files = directory.listFiles();
        long size = 0;
        if (files == null) {
            return new FileModel(directory, size);
        }
        for (final File file : files) {
            try {
                if (!isSymlink(file)) {
                    long sizeInnerFile = sizeOf(file, callback);
                    if (file.isDirectory()) {
                        callback.addToDatabase(new FileModel(file, sizeInnerFile));
                    }
                    if (callback.isTaskCancelled()) {
                        break;
                    }
                    size += sizeInnerFile;
                    if (size < 0) {
                        break;
                    }
                }
            } catch (IOException ioe) {
                // ignore exception when asking for symlink
            }
        }
        FileModel fileModel = new FileModel(directory, size);
        callback.addToDatabase(fileModel);
        return fileModel;
    }

