    public void onMetadataChanged(MediaMetadataCompat metadata) {
        FireLog.d(TAG, "(++) onMetadataChanged " + metadata);

        if (isFinishing() || isDestroyed()) {
            return;
        }
        if (metadata == null) {
            ImageHelper.loadBlurBg(this, bgView);
            return;
        }
        ImageHelper.loadBlurBg(this, bgView, metadata.getDescription());
    }

