    private static void eventReceived(String folder,long when) {
        //BLog.e(folder);
        if(SERVICE.checkFiles.get(folder)==null) {
            SERVICE.checkFiles.put(folder, Long.valueOf(when));

            SERVICE.indexHandler.removeCallbacks(SERVICE.runIndexFolderTask);
            SERVICE.indexHandler.postDelayed(SERVICE.runIndexFolderTask, 20000);
        }
    }

