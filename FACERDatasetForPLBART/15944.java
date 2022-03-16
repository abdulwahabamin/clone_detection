    private void joinGroup(View view) {
        String username = checkUsername();
        if(username!=null){
            connectivitySelectionListener.OnJoinGroupSelected(username);
        }
    }

