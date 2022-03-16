	public static boolean openFragmentBackStackAnimate(Activity activity,Fragment fragment) {
        setUseActivity(activity);
		Device.hideKeyboard(activity);

		FragmentManager fm = activity.getFragmentManager();
		FragmentTransaction tr = fm.beginTransaction();
        tr.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		tr.replace(R.id.container, fragment, fragment.getClass().getName());

		tr.commit();
		return true;
	}

