                @Override
                public void onChildrenLoaded(@NonNull String parentId,
                                             @NonNull List<MediaBrowserCompat.MediaItem> children) {

                    Log.w(TAG, "shuffle ="+getMediaController().isShuffleModeEnabled()+" parent="+mParentName);

                    try {
                        Log.d(TAG, "onChildrenLoaded:called");
                        Log.i(TAG, "onChildrenLoaded:no of items="+children.size());
                        mItemList = children;
                        mMediaBrowserCallback.onMediaBrowserChildrenLoaded(children);
                    } catch (Throwable t) {
                        Log.e(TAG, "onChildrenLoaded:exception", t);
                        t.printStackTrace();
                    }
                }

