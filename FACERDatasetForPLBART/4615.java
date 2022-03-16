	@Override
	public void onResume() {
		super.onResume();
		State.setCurrentSection(State.SECTION_FILE_EXPLORE_DELETE);


        head = (RelativeLayout) view.findViewById(R.id.files_header);
        //upgrade = PlusMember.getPlusMemberUpgradeView(activity,view,cancelUpgradeListener); //(RelativeLayout) view.findViewById(R.id.file_explore_delete_upgrade_message);
        deleteing = (LinearLayout) view.findViewById(R.id.file_explore_deleteing);
        completed = (LinearLayout) view.findViewById(R.id.file_explore_deleteing_completed);
        progressText = (TextView) view.findViewById(R.id.file_explore_progress_text);

        deletenow = (Button) view.findViewById(R.id.file_explore_delete_now);
        //bButton cancel = (bButton) view.findViewById(R.id.file_explore_delete_cancel);


        //upgradeCancel = (bButton) view.findViewById(R.id.upgrade_cancel);
        //upgradeNow = (bButton) view.findViewById(R.id.upgrade_now);


		refresh();
	}

