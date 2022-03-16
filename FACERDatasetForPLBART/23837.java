    private void initToolBar() {
        shuffleSpinner = findViewById(R.id.shuffle_select);

        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this, R.array.play_select, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        shuffleSpinner.setAdapter(adapter);
        shuffleSpinner.setSelection(displayInfo.shuffle);

        shuffleSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                Log.d(TAG, "shuffleSpinner.setOnItemSelectedListener.onItemSelected(" + position + ")");
                switch (position) {
                    case 0:
                        displayInfo.shuffle = MusicService.PLAY_SEQUENTIAL;
                        break;
                    case 1:
                        displayInfo.shuffle = MusicService.PLAY_RANDOM_SONG;
                        break;
                    case 2:
                        displayInfo.shuffle = MusicService.PLAY_RANDOM_ALBUM;
                        break;
                }
                if (musicSrv != null) {
                    musicSrv.setShuffle(displayInfo.shuffle);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
    }

