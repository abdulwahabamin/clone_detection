                @Override
                public void onError(@NonNull String id) {
                    Log.e(TAG, "onError:subscription error id="+id);
                    mMediaBrowserCallback.onMediaBrowserSubscriptionError(id);

                }

