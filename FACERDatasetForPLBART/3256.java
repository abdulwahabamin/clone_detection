	public static void refreshCurrentIfFragment(Activity activity,Class ifRefreshableClass) {
		if (activity != null) {

			final BRefreshable f = getCurrentRefeshableFragment(activity);
            //BLog.e("REFC","current: "+f.getClass().getName()+" -- need match : "+ifRefreshableClass.getName());
			if (f != null && f.getClass().getName().equals(ifRefreshableClass.getName())) {
				activity.runOnUiThread(new Runnable() {
					@Override
					public void run() {
						f.refresh();
					}
				});
			}

		}
	}

