    public static void updateImage() {
        try {
            final Uri uri = PlayerConstants.SONGS_LIST.get(PlayerConstants.SONG_NUMBER).getAlbumArtPath();
            new AsyncTask<Void, Void, Bitmap>() {

                @Override
                protected Bitmap doInBackground(Void... params) {
                    Bitmap bitmap = null;
                    try {
                        bitmap = picasso.load(uri).get();
                    } catch (IOException e) {
                        bitmap=BitmapFactory.decodeResource(mContext.getResources(),R.drawable.default_album_art);
                    }
                    return bitmap;
                }

                @Override
                protected void onPostExecute(Bitmap bitmap) {
                    changeImageAnimation(bitmap);
                    changebgImageAnimation(bitmap);
                }
            }.execute();

        }
        catch(Exception e){}
    }

