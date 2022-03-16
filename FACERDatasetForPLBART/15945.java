    private void createGroup(View view) {
        String username = checkUsername();
        if(username != null) {
            connectivitySelectionListener.OnCreateGroupSelected(username);
        }
    }

