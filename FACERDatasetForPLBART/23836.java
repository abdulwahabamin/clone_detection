    private void setupGenreList(PlayInfo playInfo) {
        Log.d(TAG, "setupGenreList(" + playInfo.toString() + ") Entry.");
        getGenreList();
        try {
            ArrayAdapter<Genre> genreAdaptor = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, genres);
            genreSpinner.setAdapter(genreAdaptor);
            genreSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> adapter, View v,
                                           int position, long id) {
                    // On selecting a spinner item
                    Log.d(TAG, "genreSpinner.setOnItemSelectedListener.onItemSelected(" + position + ")");
                    setDisplayGenre(position);
                }

                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                    // TODO Auto-generated method stub
                }
            });

            albumAdaptor = new AlbumSpinnerAdaptor(this, currentDisplayAlbums, mImageLoader);
            albumSpinner.setAdapter(albumAdaptor);
            albumSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> adapter, View v,
                                           int position, long id) {
                    // On selecting a spinner item
                    Log.d(TAG, "albumSpinner.setOnItemSelectedListener.onItemSelected(" + position + ")");
                    try {
                        Album selectedAlbum = currentDisplayAlbums.get(position);
                        int lastTrack = currentDisplayPlayList.size();
                        if ((position + 1) < currentDisplayAlbums.size())
                            lastTrack = currentDisplayAlbums.get(position + 1).getTrack() - 1;
                        int firstTrack = selectedAlbum.getTrack();
                        if ((displayInfo.trackId < firstTrack) ||
                                (displayInfo.trackId >= lastTrack))
                            displayInfo.trackId = firstTrack;
                        selectDisplayAlbum(displayInfo.trackId);
                        songView.setSelection(displayInfo.trackId);
                    } catch (Exception e) {
                        Log.e(TAG, "onItemSelected()", e);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                    // TODO Auto-generated method stub
                }
            });

            int genreIndex = getGenreIndex(playInfo.genreName);
            setDisplayGenre(genreIndex);
            genreSpinner.setSelection(genreIndex);

            if (playingInfo.genreName.equals(playInfo.genreName)) {
                displayInfo.trackId = Math.max(0, playInfo.trackId);
            }
            selectDisplayAlbum(displayInfo.trackId);
        } catch (Exception e) {
            Log.d(TAG, "setupGenreList() - Failed: " + e.getMessage());
        }
    }

