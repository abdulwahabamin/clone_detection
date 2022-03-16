        private void fetchCover() {
            String path = song.getAlbumArt();
            if (path != null && new File(path).exists()) {
                Object tag = trackAlbumArt.getTag();
                if (tag != null) {
                    if(tag instanceof AsyncImageLoader.ImageLoadTask) {
                        asyncImageLoader.cancelTask((CancellableAsyncTaskHandler.Task) tag);
                    } else if(tag instanceof RemoteAlbumCoverLoader.RemoteCoverTask) {
                        remoteCoverLoader.cancelTask((CancellableAsyncTaskHandler.Task) tag);
                    }
                }
                
                AsyncImageLoader.ImageLoadTask imageLoadTask =
                        asyncImageLoader.loadImageAsync(trackAlbumArt, path);
                
                trackAlbumArt.setTag(imageLoadTask);
            } else if (song.isRemote()) {
                fetchRemoteCover();
            }
        }

