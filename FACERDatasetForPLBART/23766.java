    private Album(long albumId,
                  String albumTitle,
                  long imageID,
                  int startTrack,
                  int endTrack) {
//       Log.d(TAG,"Album() entry.");
        id = albumId;
        title = albumTitle;
        this.mImageId = imageID;
        firstTrackIndex = startTrack;
        lastTrackIndex = endTrack;
    }

