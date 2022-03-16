    public boolean onLongClick(View view) {
        if (service == null) return true;

        long audioId = service.getAudioId();
        long artistId = service.getArtistId();
        long genreId = service.getGenreId();
        String song = service.getTrackName();
        String artist = service.getArtistName();
        String album = service.getAlbumName();

        if (audioId < 0) {
            return false;
        }

        if (MediaStore.UNKNOWN_STRING.equals(album) &&
                MediaStore.UNKNOWN_STRING.equals(artist) &&
                song != null &&
                song.startsWith("recording")) {
            // not music
            return false;
        }

        if (view.equals(artistNameView)) {
            Intent intent = new Intent(getActivity(), MusicBrowserActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(MusicContract.Artist.getMembersUri(artistId));
            startActivity(intent);
            if (!(getActivity() instanceof MusicBrowserActivity)) getActivity().finish();
            return true;
        } else if (view.equals(genreNameView)) {
            Intent intent = new Intent(getActivity(), MusicBrowserActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(MusicContract.Genre.getMembersUri(genreId));
            startActivity(intent);
            if (!(getActivity() instanceof MusicBrowserActivity)) getActivity().finish();
            return true;
        } else {
            throw new RuntimeException("shouldn't be here");
        }
    }

