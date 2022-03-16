    public static boolean MoveFiles(Activity activity, List<FileItem>files, String moveToPath) {
        SERVICE.activity=activity;
        if(SERVICE.isMoving)
            return false;

        //SERVICE.zipfile = new FileItem(archiveFilePath+File.separator+archiveFilename);
        SERVICE.isMoving=true;
        SERVICE.moveTask = SERVICE.new RunMovingTask();
        SERVICE.moveTask.setMoveToPath(moveToPath);
        SERVICE.moveTask.setList(files);
        SERVICE.moveTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, true);
        return true;
    }

