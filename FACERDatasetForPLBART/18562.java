	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
		parentActivity = getActivity();
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		sharedPreferences = parentActivity.getSharedPreferences("com.aniruddhc.acemusic.player", Context.MODE_PRIVATE);
		View rootView = parentActivity.getLayoutInflater().inflate(R.layout.dialog_google_authentication_layout, null);
		
		//Check if this dialog was called from the Welcome sequence.
		mFirstRun = getArguments().getBoolean(Common.FIRST_RUN);
		
		infoText = (TextView) rootView.findViewById(R.id.google_authentication_dialog_text);
		infoText.setTypeface(TypefaceHelper.getTypeface(getActivity(), "RobotoCondensed-Light"));
		infoText.setPaintFlags(infoText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
        
        final AccountManager accountManager = AccountManager.get(getActivity().getApplicationContext());
        final Account[] accounts = accountManager.getAccountsByType("com.google");
        final int size = accounts.length;
        String[] accountNames = new String[size];
        
        for (int i=0; i < size; i++) {
        	accountNames[i] = accounts[i].name;
        }
        
        //Set the dialog title.
        builder.setTitle(R.string.sign_in_google_play_music);
        builder.setCancelable(false);
        builder.setItems(accountNames, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				account = accounts[which];
				sharedPreferences.edit().putString("GOOGLE_PLAY_MUSIC_ACCOUNT", account.name).commit();
				AsyncGoogleMusicAuthenticationTask task = new AsyncGoogleMusicAuthenticationTask(parentActivity.getApplicationContext(), 
																								 parentActivity,
																								 mFirstRun,
																								 account.name);
				
				task.execute();

			}
			
		});
        
        

        return builder.create();
    }

