    static void getAlbumArt(String userName, long albumId,
                                   final GetAlbumArtListener albumArtListener) {
        String memberId = currentGroup.getMemberId(userName);

        ShareGroup group = ShareGroup.shareGroupWeakReference.get();

        group.netService.sendRequest(memberId, ACTION_GET_ALBUM_ART, albumId,
                new ResponseListener() {
                    @Override
                    public void onResponseReceived(Object responseData) {
                        albumArtListener.onGotAlbumArt((File) responseData);
                    }

                    @Override
                    public void onRequestFailed() {
                        albumArtListener.onFailedGettingAlbumArt();
                    }
                });
    }

