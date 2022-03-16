		@Override
		public void onTabUnselected(Tab arg0, android.app.FragmentTransaction ft) {
			if (mFragment!=null) {
				ft.detach(mFragment);
			}
			
		}

