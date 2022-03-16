    @Override
    public void onGroupCreated() {
        EditText editText = (EditText)rootView.findViewById(R.id.group_name);
        editText.setText(groupName); //in case this is called on first run of fragment.
        editText.setFocusable(false);
        editText.setFocusableInTouchMode(false);
        editText.setClickable(false);
        rootView.findViewById(R.id.creating_group_progress_bar).setVisibility(View.INVISIBLE);
        rootView.findViewById(R.id.create_group).setVisibility(View.INVISIBLE);
        rootView.findViewById(R.id.group_created_message).setVisibility(View.VISIBLE);
        groupCreationStatus = ShareGroup.CreationStatus.GROUP_CREATED;
    }

