        private void cancelAlbumArt() {
            Object tag = trackAlbumArt.getTag();

            if(tag != null) {
                if(tag instanceof AsyncImageLoader.ImageLoadTask) {
                    asyncImageLoader.cancelTask((CancellableAsyncTaskHandler.Task) tag);
                } else if(tag instanceof RemoteAlbumCoverLoader.RemoteCoverTask) {
                    remoteCoverLoader.cancelTask((CancellableAsyncTaskHandler.Task) tag);
                }
            }
        }

