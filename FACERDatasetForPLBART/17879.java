                @Override
                public void onMetadataChanged(MediaMetadataCompat metadata) {
                    Log.d(TAG, "onMetadataChanged:called");
                    mMetadata = metadata;
                    displayMetadata(metadata);
                }

