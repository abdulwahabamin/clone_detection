    public static boolean PasteFiles(Activity activity, List<FileItem>files, String pasteToPath) {
        SERVICE.activity=activity;
        if(SERVICE.isPasting)
            return false;

        //SERVICE.zipfile = new FileItem(archiveFilePath+File.separator+archiveFilename);
        SERVICE.isPasting=true;
        SERVICE.pasteTask = SERVICE.new RunPastingTask();
        SERVICE.pasteTask.setPasteToPath(pasteToPath);
        SERVICE.pasteTask.setList(files);
        SERVICE.pasteTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, true);
        return true;
    }

