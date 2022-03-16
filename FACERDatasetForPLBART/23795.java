        private Bitmap getTrackArtwork(long id) {
            Bitmap artwork = null;
            try {
                Uri trackUri = ContentUris.withAppendedId(
                        android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, id);
                if (trackUri != null) {
                    MediaMetadataRetriever mmr = new MediaMetadataRetriever();
                    mmr.setDataSource(mContext, trackUri);

                    byte[] data = mmr.getEmbeddedPicture();
                    //coverart is an Imageview object

                    // convert the byte array to a bitmap
                    if (data != null)
                        artwork = BitmapFactory.decodeByteArray(data, 0, data.length);
                }
            } catch (Exception e) {
                Log.e(TAG, "Error getting album artwork", e);
                artwork = null;
            }
            return artwork;
        }

