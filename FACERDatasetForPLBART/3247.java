	public static void clearBackStack(Activity activity) {
		FragmentManager fm = activity.getFragmentManager();
		int backStackCount = fm.getBackStackEntryCount();
		for (int i = 0; i < backStackCount; i++) {
			int backStackId = fm.getBackStackEntryAt(i).getId();

			fm.popBackStack(backStackId,
					FragmentManager.POP_BACK_STACK_INCLUSIVE);

		}
		State.sectionsClearBackstack();
	}

