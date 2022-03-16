                @Override
                public void onChildrenLoaded(@NonNull String parentId,
                                             @NonNull List<MediaBrowserCompat.MediaItem> children) {
                    try {
                        FireLog.d(TAG, "(++) onChildrenLoaded, parentId=" + parentId + "  count=" + children.size());
                        adapter.refreshData(children);
                    } catch (Throwable t) {
                        FireLog.e(TAG, "Error on childrenloaded", t);
                    }
                }

