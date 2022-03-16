    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                Intent intent = new Intent(this, MusicBrowserActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                return true;
            }

            case R.id.zoom_queue:
                if (playQueueFragment.isQueueZoomed()) {
                    playerHeaderFragment.show();
                    playerFooterFragment.show();
                    if (playerHeaderDivider != null) playerHeaderDivider.setVisibility(View.VISIBLE);
                    if (playerFooterDivider != null) playerFooterDivider.setVisibility(View.VISIBLE);
                    playQueueFragment.setQueueZoomed(false);
                    item.setIcon(R.drawable.ic_menu_zoom);
                } else {
                    playerHeaderFragment.hide();
                    playerFooterFragment.hide();
                    if (playerHeaderDivider != null) playerHeaderDivider.setVisibility(View.GONE);
                    if (playerFooterDivider != null) playerFooterDivider.setVisibility(View.GONE);
                    playQueueFragment.setQueueZoomed(true);
                    item.setIcon(R.drawable.ic_menu_unzoom);
                }
                return true;

            case R.id.repeat:
                cycleRepeat();
                return true;

            case R.id.shuffle:
                if (service != null) service.doShuffle();
                return true;

            case R.id.uniqueify:
                if (service != null) service.uniqueify();
                return true;

            case R.id.clear_queue:
                if (service != null) service.removeTracks(0, Integer.MAX_VALUE);
                return true;

            case R.id.new_playlist:
                if (service != null) CreatePlaylist.showMe(this, service.getQueue());
                return true;

            case R.id.selected_playlist:
                if (service != null) {
                    long playlist = item.getIntent().getLongExtra("playlist", 0);
                    MusicUtils.addToPlaylist(this, service.getQueue(), playlist);
                }
                return true;

            case R.id.settings:
                startActivity(new Intent(this, SettingsActivity.class));
                return true;

            case R.id.search:
                return onSearchRequested();

            case R.id.effect_panel: {
                Intent intent = new Intent(AudioEffect.ACTION_DISPLAY_AUDIO_EFFECT_CONTROL_PANEL);
                intent.putExtra(AudioEffect.EXTRA_AUDIO_SESSION, service.getAudioSessionId());
                startActivityForResult(intent, 0);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

