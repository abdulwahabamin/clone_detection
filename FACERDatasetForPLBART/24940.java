    @Override
    public void finishedDBUpdate() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                List<ArtistDTO> artists = DTOConverter.getArtistList(MusicDataUtility.allArtists(getApplicationContext()));
                if (artists != null && artists.size() > 0) {
                    if (browseGrid.getAdapter() == null) {
                        artistGridAdapter = new ArtistGridAdapter(artists, BrowseActivity.this);
                        browseGrid.setAdapter(artistGridAdapter);
                    } else {
                        artistGridAdapter.updateData(artists);
                    }
                    findViewById(R.id.no_music_added).setVisibility(View.GONE);
                } else {
                    findViewById(R.id.no_music_added).setVisibility(View.VISIBLE);
                }
                loadingContainer.setVisibility(View.GONE);
            }
        });
    }

