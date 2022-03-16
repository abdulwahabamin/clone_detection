    public void getAlbumInfo(AlbumQuery albumQuery, final AlbumInfoListener listener) {
        mRestService.getAlbumInfo(albumQuery.mArtist, albumQuery.mALbum, new Callback<AlbumInfo>() {
            @Override
            public void success(AlbumInfo albumInfo, Response response) {
                listener.albumInfoSuccess(albumInfo.mAlbum);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.albumInfoFailed();
                error.printStackTrace();
            }
        });
    }

