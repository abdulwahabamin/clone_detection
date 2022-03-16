	@Override
	protected void onCreate(Bundle arg0) {
		Debug.startMethodTracing();
		super.onCreate(arg0);
		setContentView(R.layout.main);
		// Get sharedPreferences
		preferences = PreferenceManager.getDefaultSharedPreferences(this);
		playQueue = PlayQueue.getInstance();
		fragmentManager = getSupportFragmentManager();
		initialEnergySettings = InitialEnergySettings.getInstance();
		short fragmentId = FRAGMENT_ALBUMS;
		// Register broadcast
		IntentFilter intentFilter = new IntentFilter(MusicService.MUSIC_UPDATE);
		intentFilter.addAction(EnergyService.ENERGY_MODE_SET);
		intentFilter.addAction(EnergyService.ENERGY_STATE_GET);
		registerReceiver(broadcastReceiver, intentFilter);
		if (arg0 != null) {
			album = (Album) arg0.getParcelable(EXTRA_ALBUM);
			fragmentId = arg0.getShort(EXTRA_FRAGMENT_ID);
		}
		// Start energy service to save initial energy settings
		if (!AppState.isEnergyStateSaved()) {
			Intent intentEnergyService = new Intent(getApplicationContext(), EnergyService.class);
			intentEnergyService.setAction(EnergyService.ACTION_GET_ENERGY_STATE);
			startService(intentEnergyService);
		}
		// Load a fragment depending on the ID sent in the Intent.
		if (isFragmentIdValid(fragmentId)) {
			switch (fragmentId) {
			case FRAGMENT_ALBUMS:
				addAlbumFragment();
				break;
			case FRAGMENT_SONGS_ALBUM:
				if (album != null) {
					addSongsByAlbumFragment(album);
					break;
				}
				// if null won't break and will load the default one.
			case FRAGMENT_PLAY_QUEUE:
				addPlayQueueFragment();
				break;
			default:
				addAlbumFragment();
			}
		}
	}

