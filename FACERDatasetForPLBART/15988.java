        private void fetchCover(String path, Cursor albumCursor) {
            if (path != null && new File(path).exists()) {
                Object tag = albumArt.getTag();
                if (tag != null) {
                    if(tag instanceof AsyncImageLoader.ImageLoadTask) {
                        asyncImageLoader.cancelTask((CancellableAsyncTaskHandler.Task) tag);
                    } else if(tag instanceof RemoteAlbumCoverLoader.RemoteCoverTask) {
                        remoteCoverLoader.cancelTask((CancellableAsyncTaskHandler.Task) tag);
                    }
                }

                AsyncImageLoader.ImageLoadTask imageLoadTask =
                        asyncImageLoader.loadImageAsync(albumArt, path);

                albumArt.setTag(imageLoadTask);
            } else {
                if(Library.getInt(albumCursor, AlbumTable.Columns.IS_REMOTE) == 1)
                fetchRemoteCover(path, albumCursor);
            }
        }

