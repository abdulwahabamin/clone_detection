	public void showTrialDialog(final boolean expired, int numDaysRemaining) {
		
		AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
		builder.setTitle(R.string.app_name);
		builder.setCancelable(false);

		View view = this.getLayoutInflater().inflate(R.layout.trial_expiry_dialog, null);
		TextView trialExpiredText = (TextView) view.findViewById(R.id.trial_message);
		TextView trialDaysRemaining = (TextView) view.findViewById(R.id.trial_days_remaining);
		TextView trialDaysCaps = (TextView) view.findViewById(R.id.days_caps);
		
		trialExpiredText.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Light"));
		trialExpiredText.setPaintFlags(trialExpiredText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
		
		trialDaysRemaining.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Light"));
		
		trialDaysCaps.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Light"));
		trialDaysCaps.setPaintFlags(trialDaysCaps.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
		
		if (expired) {
			trialDaysRemaining.setText(R.string.expired);
			trialExpiredText.setText(R.string.trial_expired);
			trialDaysRemaining.setTextColor(0xFFFF8800);
			trialDaysCaps.setVisibility(View.GONE);
			trialDaysRemaining.setTextSize(36);
			trialDaysRemaining.setPaintFlags(trialDaysRemaining.getPaintFlags() 
											 | Paint.ANTI_ALIAS_FLAG 
											 | Paint.SUBPIXEL_TEXT_FLAG);
		} else {
			trialExpiredText.setText(R.string.trial_running);
			trialDaysRemaining.setText("" + numDaysRemaining);
			trialDaysCaps.setVisibility(View.VISIBLE);
			trialDaysRemaining.setTextColor(0xFF0099CC);
			trialDaysRemaining.setPaintFlags(trialDaysRemaining.getPaintFlags() 
											 | Paint.ANTI_ALIAS_FLAG 
											 | Paint.SUBPIXEL_TEXT_FLAG 
											 | Paint.FAKE_BOLD_TEXT_FLAG);
		}
		
		builder.setView(view);
		builder.setPositiveButton(R.string.upgrade, new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				showUpgradeFragmentWithPromo();

			}
			
		});
		
		builder.setNegativeButton(R.string.later, new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				if (expired) {
					finish();
				} else {
					launchMainActivity();
				}
				
				
			}
			
		});
		
		builder.create().show();
	}

