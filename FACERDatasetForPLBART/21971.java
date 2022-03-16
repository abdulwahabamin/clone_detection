    void scrobble() {
        if (LastfmUserSession.getSession(this).isLogedin()) {
            Log.d("Scrobble", "to LastFM");
            String trackname = getTrackName();
            if (trackname != null)
                LastFmClient.getInstance(this).Scrobble(new ScrobbleQuery(getArtistName(), trackname, System.currentTimeMillis() / 1000));
        }
    }

