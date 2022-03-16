    @Override
    public void onGroupCreationFailed(String failureMessage) {
        Toast.makeText(getContext(), failureMessage, Toast.LENGTH_LONG).show();
        EditText editText = (EditText)rootView.findViewById(R.id.group_name);
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.setClickable(true);
        groupCreationStatus = ShareGroup.CreationStatus.GROUP_NOT_CREATED;
        rootView.findViewById(R.id.creating_group_progress_bar).setVisibility(View.INVISIBLE);
        rootView.findViewById(R.id.create_group).setEnabled(true);
    }

