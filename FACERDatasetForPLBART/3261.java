	public static void goPreviousFragment(Activity activity) {
		Device.hideKeyboard(activity);
//BLog.e("SS", "Go previous sections size: " + State.getSectionsSize());
		if (State.getSectionsSize() == 0) {
			Bgo.clearBackStack(activity);
			Bgo.openFragment(activity, FileExploreFragment.class);
		} else {
			State.sectionsGoBackstack();
			Bgo.openCurrentState(activity);

		}

	}

