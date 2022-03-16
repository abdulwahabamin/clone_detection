    public static boolean unArchiveFiles(String archiveFilePath, String toFolder) {
        if(isUnArchiving())
            return false;

        SERVICE.isUnArchiving=true;
        SERVICE.unArchiveTask = SERVICE.new RunUnArchivingTask();
        SERVICE.unArchiveTask.setZipFile(new FileItem(archiveFilePath));
        SERVICE.unArchiveTask.setToFolder(toFolder);
        SERVICE.unArchiveTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, true);
        return true;
    }

