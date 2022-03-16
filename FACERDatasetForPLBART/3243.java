	public static boolean openFragment(Activity activity, Class<? extends Fragment> fragment) {


        //if(!activity.isDestroyed()) {
		setUseActivity(activity);

		Device.hideKeyboard(activity);
		State.sectionsGoBackstack();
            FragmentManager fm = activity.getFragmentManager();

            FragmentTransaction tr = fm.beginTransaction();
			tr.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		tr.replace(R.id.container, Fragment.instantiate(activity, fragment.getName()));
           // tr.replace(R.id.container, fragment, fragment.getClass().getName());
            //tr.replace(R.id.container, fragment, fragment.getClass().getName());

            tr.commit();
        //}
		//Log.e("BGO", "openfrgament: " + fragment.getClass().getName() + " - backstack: " + fm.getBackStackEntryCount());
		return true;
	}

