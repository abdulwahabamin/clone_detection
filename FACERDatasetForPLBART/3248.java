	public static void refreshFragment(Activity activity,String fragmentClassName) {
		FragmentManager fm = activity.getFragmentManager();
		try {
			BRefreshable f = (BRefreshable) fm
					.findFragmentByTag(fragmentClassName);
			if (f != null) {
				f.refresh();
			}
		} catch (Exception e) {

		}
	}

