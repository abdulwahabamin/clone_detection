	public static Fragment getCurrentFragment(Activity activity) {
		if (activity != null) {
			FragmentManager fm = activity.getFragmentManager();
			try {

				Fragment f = (Fragment) fm
						.findFragmentByTag(getFragmentNameBystate(State.getCurrentSection()));
				//BLog.e("REF","---"+getFragmentNameBystate(State.getCurrentSection()));
				if (f != null) {
					return f;
				}
			} catch (Exception e) {
				// BLog.e("REF","ex: "+e.toString());
			}
		}
		return null;
	}

