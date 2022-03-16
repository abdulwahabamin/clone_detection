        private void fetchRemoteCover(String path, Cursor albumCursor) {
            String username = Library.getString(albumCursor, AlbumTable.Columns.REMOTE_USERNAME);
            long albumId = Library.getLong(albumCursor, AlbumTable.Columns.ALBUM_ID);

            if (albumArt.getTag() != null) {
                cancelAlbumArt();
            }

            RemoteAlbumCoverLoader.RemoteCoverTask task =
                    remoteCoverLoader.loadRemoteCover(albumArt, username, albumId, path);
            albumArt.setTag(task);
        }

