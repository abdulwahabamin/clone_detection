	private void setColors() {
		int set=activity.getResources().getColor(R.color.black);
		if(fm.isCurrentDirImages()) {
			set=activity.getResources().getColor(R.color.white);
		} else {
            TypedValue outValue = new TypedValue();
            activity.getTheme().resolveAttribute(R.attr.themeName, outValue, true);
            if ("dark".equals(outValue.string)) {
                set=activity.getResources().getColor(R.color.white);
            }

        }
		path.setTextColor(set);
		info.setTextColor(set);
		title.setTextColor(set);
		files.setTextColor(set);
	}

