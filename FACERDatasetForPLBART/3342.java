        @Override
        public void run() {
            if(!Indexer.isRunning()) {
                SERVICE.new ReIndexTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, true);
            } else {
                SERVICE.indexHandler.postDelayed(runIndexFolderTask,20000);
            }
        }

