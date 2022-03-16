	private void showTrialFragment(final boolean expired, int numDaysRemaining) {
		
		//Load the trial fragment into the activity.
		TrialFragment fragment = new TrialFragment();
		Bundle bundle = new Bundle();
		bundle.putInt("NUM_DAYS_REMAINING", numDaysRemaining);
		bundle.putBoolean("EXPIRED", expired);
		fragment.setArguments(bundle);
		
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
	    transaction.replace(R.id.launcher_root_view, fragment, "trialFragment");
	    transaction.commit();

	}

