    @Override
    public void onBindViewHolder(@NonNull UserListViewHolder userListViewHolder, int i) {
       preferenceManager = new PreferenceManager(context);
       String userName = preferenceManager.getUserName();
       String deviceName = allPairedDevices.get(i).getName();
       userListViewHolder.usernameTv.setText(userName + deviceName);


    }

