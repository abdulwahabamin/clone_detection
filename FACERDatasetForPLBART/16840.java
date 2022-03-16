        @Override
        public void onMetadataChanged(MediaMetadataCompat metadata) {
            FireLog.d(TAG, "(++) MediaController.Callback.onMetadataChanged metadata= " + metadata);
            if (metadata != null) {
                updateMediaDescription(metadata.getDescription());
                updateDuration(metadata);
            }
        }

