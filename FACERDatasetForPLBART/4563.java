	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		//BLog.e("onCreateOptionsMenu at home");
        boolean callrefresh=true;
        boolean intercept=false;
		switch(item.getItemId()) {
			case R.id.action_search:
				State.addCachedFileManager(fm);
                callrefresh=false;
				Bgo.openFragmentBackStack(activity,new SearchFragment());
                intercept=true;
				break;
            /*
            case R.id.orderby_name_asc:
                //g.setEmailServiceInstance(emailService);
                fm.setOrderBy(activity, fm.ORDER_ALPHA_ASC);
                intercept=true;
                break;
            case R.id.orderby_name_desc:
                //g.setEmailServiceInstance(emailService);
                fm.setOrderBy(activity, fm.ORDER_ALPHA_DESC);
                intercept=true;
                break;
            case R.id.orderby_date_asc:
                //g.setEmailServiceInstance(emailService);
                fm.setOrderBy(activity, fm.ORDER_DATE_ASC);
                intercept=true;
                break;
            case R.id.orderby_date_desc:
                //g.setEmailServiceInstance(emailService);
                fm.setOrderBy(activity, fm.ORDER_DATE_DESC);
                intercept=true;
                break;
            case R.id.showhide_system_files:
                //g.setEmailServiceInstance(emailService);
                //if(fm.getShowSystemFiles())
                    //fm.setOrderBy(fm.ORDER_DATE_DESC);
                fm.setShowSystemFiles(activity, !fm.getShowSystemFiles());
                intercept=true;
                //refreshData();
                break;
            */
            case R.id.action_paste:
                //g.setEmailServiceInstance(emailService);

				if(fm.isCutPasteFilesOnClipboard) {
					Toast.makeText(activity,getString(R.string.action_paste),Toast.LENGTH_SHORT);
					BrowseService.MoveFiles(activity, fm.getClipboardCopyFilesAsList(), fm.getPath());
				} else {
					Toast.makeText(activity,getString(R.string.action_paste),Toast.LENGTH_SHORT);
					BrowseService.PasteFiles(activity,fm.getClipboardCopyFilesAsList(),fm.getPath());
				}
				fm.clearSelectedClipboardCopyFiles();
                //fm.setOrderBy(activity, fm.ORDER_DATE_DESC);
                callrefresh=true;
                intercept=true;
                break;

		}
        if(callrefresh)
            refreshData();
		return intercept;
	}

