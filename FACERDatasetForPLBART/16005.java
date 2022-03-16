        private void fetchRemoteCover() {
            String username = song.getLibraryUsername();
            long albumId = song.getAlbumId();
            String path = song.getAlbumArt();

            if (trackAlbumArt.getTag() != null) {
                cancelAlbumArt();
            }

            RemoteAlbumCoverLoader.RemoteCoverTask task =
                    remoteCoverLoader.loadRemoteCover(trackAlbumArt, username, albumId, path);
            trackAlbumArt.setTag(task);
        }

