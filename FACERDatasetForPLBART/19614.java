		public void onIabPurchaseFinished(IabResult result, Purchase purchase) {
			
			if (result.isFailure()) {
				Toast.makeText(mContext, R.string.unable_to_purchase, Toast.LENGTH_LONG).show();
				sharedPreferences.edit().putBoolean("TRIAL", true).commit();
				return;
			} else if (purchase.getSku().equals(ITEM_SKU)) {

				Toast.makeText(mContext, R.string.jams_trial_time_removed, Toast.LENGTH_LONG).show();
				mApp.getSharedPreferences().edit().putBoolean("TRIAL", false).commit();
				PreferenceCategory upgradePrefCategory = (PreferenceCategory) preferenceManager.findPreference("upgrade_pref_category");
	    		upgradePrefCategory.removeAll();
	    		
			}
	      
		}

