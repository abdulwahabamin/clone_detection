    private void loadLyrics() {

        final View lyricsView = rootView.findViewById(R.id.lyrics);
        final TextView poweredbyTextView = (TextView) lyricsView.findViewById(R.id.lyrics_makeitpersonal);
        poweredbyTextView.setVisibility(View.GONE);
        final TextView lyricsTextView = (TextView) lyricsView.findViewById(R.id.lyrics_text);
        lyricsTextView.setText(getString(R.string.lyrics_loading));
        String filename = getRealPathFromURI(Uri.parse(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI + "/" + MusicPlayer.getCurrentAudioId()));
        if (filename != null && lyrics == null) {
            lyrics = LyricsExtractor.getLyrics(new File(filename));
        }

        if (lyrics != null) {
            lyricsTextView.setText(lyrics);
        } else {
            String artist = MusicPlayer.getArtistName();
            if (artist != null) {
                int i = artist.lastIndexOf(" feat");
                if (i != -1) {
                    artist = artist.substring(0, i);
                }

                LyricsLoader.getInstance(this.getContext()).getLyrics(artist, MusicPlayer.getTrackName(), new Callback<String>() {
                    @Override
                    public void success(String s, Response response) {
                        lyrics = s;
                        if (s.equals("Sorry, We don't have lyrics for this song yet.\n")) {
                            lyricsTextView.setText(R.string.no_lyrics);
                        } else {
                            lyricsTextView.setText(s);
                            poweredbyTextView.setVisibility(View.VISIBLE);
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        lyricsTextView.setText(R.string.no_lyrics);
                    }
                });

            } else {
                lyricsTextView.setText(R.string.no_lyrics);
            }
        }
    }

