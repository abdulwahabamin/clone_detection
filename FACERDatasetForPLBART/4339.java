	@Override
	public void onResume() {
		super.onResume();
		TextView wwwlink = (TextView) view.findViewById(R.id.www_link);
		wwwlink.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				BriefActivityManager.openAndroidBrowserUrl(getActivity(), "http://www.brief.ink");
			}
		});
		final TextView emaillink = (TextView) view.findViewById(R.id.email_link);
		emaillink.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(BriefActivityManager.isGmailClientInstalled(getActivity())) {
					BriefActivityManager.openGmailClient(getActivity(),emaillink.getText().toString(),"Feedback for Browse - file manager app");
				} else {
					BriefActivityManager.openAndroidBrowserUrl(getActivity(), "mailto:" + emaillink.getText());
				}
			}
		});
            //TextView textHeadTheme = (TextView) view.findViewById(R.id.settings_brief_head_theme);

            //.addStyleBold(textHeadShow, B.FONT_LARGE);

            //B.addStyleBold(themeText, B.FONT_XLARGE);

        //}

	}

