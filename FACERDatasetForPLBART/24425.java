    private void update() {
        if (service == null) return;

        if (service.getAudioId() != -1) {
            String trackName = service.getTrackName();
            trackNameView.setText(trackName);
            String artistName = service.getArtistName();
            if (MediaStore.UNKNOWN_STRING.equals(artistName)) {
                artistName = getString(R.string.unknown_artist_name);
            }
            artistNameView.setText(artistName);
            String genreName = service.getGenreName();
            if (MediaStore.UNKNOWN_STRING.equals(genreName)) {
                genreName = getString(R.string.unknown_genre_name);
            }
            genreNameView.setText(genreName);
        } else {
            trackNameView.setText("");
            artistNameView.setText("");
            genreNameView.setText("");
        }
    }

