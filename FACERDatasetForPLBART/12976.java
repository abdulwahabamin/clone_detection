    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        // Redraw the disk usage graph when layout size changes
        if (oldw != 0 && oldh != 0 && mLastDiskUsage != null) {
            drawDiskUsage(mLastDiskUsage);
        }
    }

