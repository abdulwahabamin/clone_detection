                @Override
                public void onMetadataChanged(MediaMetadataCompat metadata) {
                    if (metadata == null) {
                        FireLog.e(TAG, "(++) MediaController.Callback.onMetadataChanged");
                        return;
                    }
                    SearchActivity.this.onMetadataChanged(metadata);
                }

