    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.voice_setting_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(VoiceSettingsActivity.this));

        final VoiceSettingsSwipeController swipeController = new VoiceSettingsSwipeController(new LocationsSwipeControllerActions() {
            @Override
            public void onRightClicked(int position) {
                deleteVoiceSetting(position);
            }

            @Override
            public void onLeftClicked(int position) {
                moveToAddVoiceSettingsActivity(voiceSettingsAdapter.voiceSettingIds.get(position));
            }
        }, this);

        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                swipeController.onDraw(c);
            }
        });

        itemTouchhelper.attachToRecyclerView(recyclerView);
    }

