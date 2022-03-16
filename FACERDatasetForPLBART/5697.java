	/**
	 * @since 2011-09-30
	 */
	private void showMoreCommandsDialog() {
		final Uri data = Uri.fromFile(mContextFile);
		final Intent intent = new Intent(null, data);
		String type = mMimeTypes.getMimeType(mContextFile.getName());

		intent.setDataAndType(data, type);

		Log.v(TAG, "Data=" + data);
		Log.v(TAG, "Type=" + type);

		if (type != null) {
			// Add additional options for the MIME type of the selected file.
			PackageManager pm = getPackageManager();
			final List<ResolveInfo> lri = pm.queryIntentActivityOptions(
					new ComponentName(this, FileManagerActivity.class),
					null, intent, 0);
			final int N = lri != null ? lri.size() : 0;

			// Create name list for menu item.
			final List<CharSequence> items = new ArrayList<CharSequence>();
			/* Some of the options don't go to the list hence we have to remove them
			 * to keep the lri correspond with the menu items. In the addition, we have
			 * to remove them after the first iteration, otherwise the iteration breaks.
			 */
			List<ResolveInfo> toRemove = new ArrayList<ResolveInfo>();
			for (int i = 0; i < N; i++) {
				final ResolveInfo ri = lri.get(i);
				Intent rintent = new Intent(intent);
				rintent.setComponent(
						new ComponentName(
								ri.activityInfo.applicationInfo.packageName,
								ri.activityInfo.name));
				ActivityInfo info = rintent.resolveActivityInfo(pm, 0);
				String permission = info.permission;
				if(info.exported && (permission == null 
						|| checkCallingPermission(permission) == PackageManager.PERMISSION_GRANTED))
					items.add(ri.loadLabel(pm));
				else
					toRemove.add(ri);
			}

			for(ResolveInfo ri : toRemove){
				lri.remove(ri);
			}

			new AlertDialog.Builder(this)
					.setTitle(mContextText)
					.setIcon(mContextIcon)
					.setItems(items.toArray(new CharSequence[0]),
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int item) {
									final ResolveInfo ri = lri.get(item);
									Intent rintent = new Intent(intent)
											.setComponent(new ComponentName(
													ri.activityInfo.applicationInfo.packageName,
													ri.activityInfo.name));
									startActivity(rintent);
								}
							}).create()
						.show();
		}
	}

