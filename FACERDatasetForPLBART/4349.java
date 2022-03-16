	@Override
	public void onResume() {
		super.onResume();

		darkview=(View) view.findViewById(R.id.settings_theme_dark);
		darkview.setOnClickListener(goDarkTheme);
		lightview=(View) view.findViewById(R.id.settings_theme_light);
		lightview.setOnClickListener(goLightTheme);

		//pasterename = (RadioButton) view.findViewById(R.id.settings_paste_rename);
        //pasterename.setOnClickListener(onRadioClicked);
		//pasteover= (RadioButton) view.findViewById(R.id.settings_paste_overwrite);
        //pasteover.setOnClickListener(onRadioClicked);

		refresh();

        //}
	}

