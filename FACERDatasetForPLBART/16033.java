    private void initSpinner() {

        if(shareGroupWeakReference != null
                && shareGroupWeakReference.get() != null) {
            final ShareGroup group = shareGroupWeakReference.get();

            group.registerGroupMemberListener(this);
            group.registerGroupConnectionListener(this);

            if (rootView.findViewById(R.id.library_spinner) == null) {
                ((ViewGroup) rootView.findViewById(R.id.library_app_bar))
                        .addView(librarySpinner, 1);
            }

            memberListAdapter = new ArrayAdapter<>(getContext(),
                    R.layout.library_spinner_item, group.getMemberList());

            librarySpinner.setAdapter(memberListAdapter);

            librarySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                private int lastPosition = 0;

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position,
                                           long id) {
                    if (position == lastPosition) {
                        return;
                    } else {
                        lastPosition = position;
                    }
                    String name = group.getMemberList().get(position);

                    if (name.equals(ShareGroup.userName)) {
                        name = null;
                    }

                    if (fragmentInitialized) {
                        libraryChanged(name);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        } else {
            ((ViewGroup)rootView.findViewById(R.id.library_app_bar)).removeView(librarySpinner);
            if(fragmentInitialized) {
                libraryChanged(null);
            }
        }
    }

