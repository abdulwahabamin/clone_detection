    private void startBackgroundImageExtraction(ImageView imageview, long id) {
        if (mAsyncTaskCount < MAX_ASYNC_TASKS) {
            mAsyncTaskCount++;
            new SetImageTask(imageview).execute(id);
        } else {
            Log.d(TAG, "startBackgroundImageExtraction(): Too many tasks.");
            WorkItem work = new WorkItem(id, imageview);
            deferredQueue.offer(work);
        }
    }

