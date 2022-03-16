        @Override
        public void onMetadataChanged(MediaMetadataCompat metadata) {
            if (metadata == null) {
                return;
            }
            FireLog.d(TAG, "(++) onMetadataChanged mediaId=" + metadata.getDescription().getMediaId() + " song=" + metadata.getDescription().getTitle());
            MediaCategoryActivity.this.onMetadataChanged(metadata); // always use this context
        }

