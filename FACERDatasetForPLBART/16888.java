    @Override
    public void onItemClick(MediaItemWrapper mediaItemWrapper) {
        FireLog.d(TAG, "(++) onItemClick");
        if (mediaItemWrapper == null)
            return;

        if (mediaItemWrapper.getMediaItem() != null && mediaItemWrapper.getMediaItem().isPlayable()) {
            onPlaySelected(mediaItemWrapper.getMediaItem());
        } else {
            ActionHelper.startMediaCategoryActivity(this, mediaItemWrapper);
        }
    }

