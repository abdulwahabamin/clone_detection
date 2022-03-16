		@Override
		public void onClick(View view) {
		    boolean restart=false;
		    BriefSettings settings = State.getSettings();
			if(settings.getBoolean(BriefSettings.BOOL_STYLE_DARK)==Boolean.FALSE) {
				settings.setBoolean(BriefSettings.BOOL_STYLE_DARK, Boolean.TRUE);
				restart=true;
			}
		    settings.save();
		    State.setSettings(settings);
			if(restart)
				BriefActivityManager.closeAndRestartBrief(getActivity());
		}

