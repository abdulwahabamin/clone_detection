    private void initAboutDialog(){
        final Preference aboutApolloMod = findPreference(BUILD_VERSION);
        String versionName = null;
		try {
			versionName = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(versionName!=null){
	        aboutApolloMod.setSummary(versionName);
		}
        aboutApolloMod.setOnPreferenceClickListener(new OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(final Preference preference) {
            	  final TextView message = new TextView(mContext);
            	  message.setPadding(25, 25, 25, 25);
            	  // i.e.: R.string.dialog_message =>
            	            // "Test this dialog following the link to dtmilano.blogspot.com"
            	  final SpannableString s = new SpannableString(mContext.getText(R.string.about_apollomod_message));
            	  Linkify.addLinks(s, Linkify.WEB_URLS);
            	  message.setText(s);
            	  message.setMovementMethod(LinkMovementMethod.getInstance());

            	 new AlertDialog.Builder(SettingsHolder.this)
            	  		.setTitle(R.string.about_apollomod_title)
            	  		.setCancelable(true)
            	  		.setPositiveButton(android.R.string.ok, null)
            	  		.setView(message)
            	  		.create()
            	  		.show();
            	 

            	
            	
            	
            	
            	return true;
            }
        });
    	
    }

