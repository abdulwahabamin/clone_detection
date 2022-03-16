		@Override
		public void onTabSelected(Tab tab, android.app.FragmentTransaction ft) {
			
			currentTab = (String) tab.getText();
			//Check if the fragment is already initialized
			if (mFragment==null) {
				//If not, instantiate and add it to the activity
				mFragment = android.app.Fragment.instantiate(mActivity, mClass.getName());
				ft.replace(android.R.id.content, mFragment, mTag);
			} else {
				//If it exists, simply attach it in order to show it
				ft.attach(mFragment);
			}
			
		}

