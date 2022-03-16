    public static void getSong(String memberName, final long songId,
                               final GetSongListener getSongListener) {
        String memberId = currentGroup.getMemberId(memberName);

        ShareGroup group = ShareGroup.shareGroupWeakReference.get();

        final Member member = currentGroup.getMemberFromUsername(memberName);
        String cachedSongName = member.songCache.get(songId);


        if(cachedSongName != null && new File(Library.FILE_SAVE_LOCATION,cachedSongName).exists()) {
            getSongListener.onGotSong(Library.FILE_SAVE_LOCATION+"/"+cachedSongName);
        } else {

            group.netService.sendRequest(memberId, ACTION_GET_SONG, songId,
                    new ResponseListener() {
                        @Override
                        public void onResponseReceived(Object responseData) {
                            member.songCache.put(songId, ((File) responseData).getName());
                            getSongListener.onGotSong(((File) responseData).getAbsolutePath());
                        }

                        @Override
                        public void onRequestFailed() {
                            getSongListener.onFailedGettingSong();
                        }
                    });
        }
    }

