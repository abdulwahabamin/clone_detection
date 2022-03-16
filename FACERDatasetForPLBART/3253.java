	public static void refreshCurrentFragment(Activity activity) {
		if (activity != null) {

			BRefreshable f = getCurrentRefeshableFragment(activity);
			if (f != null) {

				f.refresh();
			}

		}
	}

