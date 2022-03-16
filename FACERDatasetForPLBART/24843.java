    public Bitmap getAlbumArtBitmap(Uri uri){
        Bitmap bm=getAlbumArt(uri);
        if (bm==null)
        {
            bm=BitmapFactory.decodeResource(getResources(), R.drawable.default_album_art);
        }
        return bm;
    }

