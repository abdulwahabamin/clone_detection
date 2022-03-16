    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home: {
                Intent intent = new Intent();
                intent.setClass(this, MusicLibrary.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                break;
            }
            case FAVORITE: {
                MusicUtils.toggleFavorite();
                invalidateOptionsMenu();
                break;
            }
            case SEARCH: {
                onSearchRequested();
                break;
            }
            case R.id.add_to_playlist: {
                Intent intent = new Intent(INTENT_ADD_TO_PLAYLIST);
                long[] list = new long[1];
                list[0] = MusicUtils.getCurrentAudioId();
                intent.putExtra(INTENT_PLAYLIST_LIST, list);
                startActivity(intent);
                break;
            }
            case R.id.eq: {
                Intent i = new Intent(AudioEffect.ACTION_DISPLAY_AUDIO_EFFECT_CONTROL_PANEL);
                i.putExtra(AudioEffect.EXTRA_AUDIO_SESSION, MusicUtils.getCurrentAudioId());
                startActivityForResult(i, EFFECTS_PANEL);
                break;
            }
            case R.id.play_store: {
                ApolloUtils.shopFor(this, MusicUtils.getArtistName());
                break;
            }
            case R.id.share: {
                shareCurrentTrack();
                break;
            }
            case R.id.settings: {
	        	startActivityForResult(new Intent(this, SettingsHolder.class),0);
                break;
            }
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

