    public static boolean ArchiveFiles(String archiveFilePath, String archiveFilename, List<FileItem>files) {
        if(SERVICE.isArchiving())
            return false;

        SERVICE.zipfile = new FileItem(archiveFilePath+File.separator+archiveFilename);
        SERVICE.isArchiving=true;
        SERVICE.archiveTask = SERVICE.new RunArchivingTask();
        SERVICE.archiveTask.setZipFile(SERVICE.zipfile);
        SERVICE.archiveTask.setList(files);
        SERVICE.archiveTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, true);
        return true;
    }

