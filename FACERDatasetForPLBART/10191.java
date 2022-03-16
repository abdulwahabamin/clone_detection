    /**
     * Method that draw the disk usage.
     *
     * @param diskUsage {@link com.cyanogenmod.filemanager.model.DiskUsage} The disk usage params
     */
    public void drawDiskUsage(DiskUsage diskUsage) {

        // Clear if a current drawing exit
        if (mAnimationFuture != null && !mAnimationFuture.isCancelled()) {
            mAnimationFuture.cancel(true);
        }

        // Clear canvas
        synchronized (LOCK) {
            this.mDrawingObjects.clear();
        }
        invalidate();

        // Start drawing thread
        AnimationDrawingRunnable animationDrawingRunnable = new AnimationDrawingRunnable(diskUsage);
        mAnimationFuture = sThreadPool.submit(animationDrawingRunnable);

    }

