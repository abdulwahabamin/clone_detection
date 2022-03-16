	public static boolean openFragmentAnimate(Activity activity, Fragment fragment) {
        setUseActivity(activity);

		Device.hideKeyboard(activity);
		State.sectionsGoBackstack();
		FragmentManager fm = activity.getFragmentManager();
		FragmentTransaction tr = fm.beginTransaction();
        tr.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		tr.replace(R.id.container, fragment, fragment.getClass().getName());
		tr.commit();
		return true;
	}

