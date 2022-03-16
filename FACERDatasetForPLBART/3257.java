	public static BRefreshable getCurrentRefeshableFragment(Activity activity) {
		if (activity != null) {
			FragmentManager fm = activity.getFragmentManager();
			try {

				BRefreshable f = (BRefreshable) fm
						.findFragmentByTag(getFragmentNameBystate(State.getCurrentSection()));
                //BLog.e("REF","---"+getFragmentNameBystate(State.getCurrentSection()));
				if (f != null) {
					return f;
				} else {
                    BRefreshable fr = (BRefreshable) fm
                            .findFragmentById(R.id.container);
                    if (fr != null) {
                        return fr;
                    }
                }
			} catch (Exception e) {
               // BLog.e("REF","ex: "+e.toString());
			}
		}
		return null;
	}

