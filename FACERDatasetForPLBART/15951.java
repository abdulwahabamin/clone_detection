    private void createGroup(View view){
        String groupName = ((EditText) rootView.findViewById(R.id.group_name)).getText().toString();
        if(groupName.equals("")) {
            EditText editText = (EditText)rootView.findViewById(R.id.group_name);
            editText.setHint("Cannot be empty!");
            editText.setHintTextColor(Color.RED);
        } else {
            this.groupName = groupName;
            SharedPreferences.Editor editor = getContext()
                    .getSharedPreferences(Global.SHARED_PREFS_NAME, Context.MODE_PRIVATE).edit();
            editor.putString(ConnectivityFragment.LAST_USED_GROUP_NAME_KEY, groupName);
            editor.apply();

            group.createGroup(groupName, this, this);
            groupCreationStatus = ShareGroup.CreationStatus.GROUP_WAITING_FOR_CREATION;
            onWaitingForGroupCreation();
        }
    }

