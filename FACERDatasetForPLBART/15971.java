    @Override
    public void onNewMemberJoined(String memberId, String memberName) {
        Toast.makeText(getContext(), memberName + " connected", Toast.LENGTH_LONG).show();
        ((ArrayAdapter) ((ListView) rootView.findViewById(R.id.group_list))
                .getAdapter()).notifyDataSetChanged();
    }

