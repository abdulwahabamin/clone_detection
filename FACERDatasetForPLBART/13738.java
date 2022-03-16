    public void getSongs(){
        context = MusicListActivity.this;
        audioListView = findViewById(R.id.audioListView);

        List<AudioModel> allAudioFiles = getAllAudioFromDevice(context);

        audioListAdapter = new AudioListAdapter(context,allAudioFiles);
        audioListView.setLayoutManager(new LinearLayoutManager(context));
        audioListView.setAdapter(audioListAdapter);
    }

