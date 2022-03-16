    private void backgroundImageExtractionFinished() {
        mAsyncTaskCount--;
        if (mAsyncTaskCount < 0)
            mAsyncTaskCount = 0;
        WorkItem myWork = deferredQueue.poll();
        while ((myWork != null) && (mAsyncTaskCount < MAX_ASYNC_TASKS)) {
            mAsyncTaskCount++;
            Log.d(TAG, "backgroundImageExtractionFinished(): Starting deferred task.");
            new SetImageTask(myWork.imageView).execute(myWork.imageID);
        }
        Log.d(TAG, "backgroundImageExtractionFinished(): Task count=" + mAsyncTaskCount);
    }

