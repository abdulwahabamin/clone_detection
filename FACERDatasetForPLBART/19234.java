		public void onIabPurchaseFinished(IabResult result, Purchase purchase) {
			
			if (result.isFailure()) {	
				Toast.makeText(mContext, R.string.unable_to_purchase, Toast.LENGTH_LONG).show();
				sharedPreferences.edit().putBoolean("TRIAL", true).commit();
				return;
			} else if (purchase.getSku().equals(ITEM_SKU) || purchase.getSku().equals(ITEM_SKU_PROMO)) {
				Toast.makeText(mContext, R.string.jams_trial_time_removed, Toast.LENGTH_LONG).show();
				sharedPreferences.edit().putBoolean("TRIAL", false).commit();
				launchMainActivity();
				
			}
	      
		}

