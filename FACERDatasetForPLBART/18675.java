    /**
     * Initializes the ActionBar.
     */
    private void showEqualizerActionBar(Menu menu) {

        //Set the Actionbar color.
        getActionBar().setBackgroundDrawable(UIElementsHelper.getGeneralActionBarBackground(mContext));

        //Hide all menu items except the toggle button and "done" icon.
        menu.findItem(R.id.action_equalizer).setVisible(false);
        menu.findItem(R.id.action_pin).setVisible(false);
        menu.findItem(R.id.action_queue_drawer).setVisible(false);
        menu.findItem(R.id.action_settings).setVisible(false);
        menu.findItem(R.id.action_done).setVisible(true);

        /**
         * The Toggle button in the actionbar doesn't work at this point. The setChecked()
         * method doesn't do anything, so there's no way to programmatically set the
         * switch to its correct position when the equalizer fragment is first shown.
         * Users will just have to rely on the "Reset" button in the equalizer fragment
         * to effectively switch off the equalizer.
         */
        menu.findItem(R.id.action_equalizer_toggle).setVisible(false); //Hide the toggle for now.

		//Set the toggle listener.
		ToggleButton equalizerToggle = (ToggleButton) menu.findItem(R.id.action_equalizer_toggle)
									 		  			  .getActionView()
									 		  			  .findViewById(R.id.actionbar_toggle_switch);

		//Set the current state of the toggle.
		boolean toggleSetting = true;
		if (mApp.isEqualizerEnabled())
			toggleSetting = true;
		else
			toggleSetting = false;

        //Set the ActionBar title text color.
        int titleId = getResources().getIdentifier("action_bar_title", "id", "android");
        TextView abTitle = (TextView) findViewById(titleId);
        abTitle.setTextColor(0xFFFFFFFF);

		equalizerToggle.setChecked(toggleSetting);
		equalizerToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean state) {
				mApp.setIsEqualizerEnabled(state);

				if (state==true)
					applyCurrentEQSettings();

			}

		});

        getActionBar().setHomeButtonEnabled(false);
        getActionBar().setDisplayHomeAsUpEnabled(false);

    }

