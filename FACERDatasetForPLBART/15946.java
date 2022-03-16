    String checkUsername() {
        String username =((EditText) parentView.findViewById(R.id.username)).getText().toString();
        if(username.isEmpty()) {
            TextView caption = (TextView) parentView.findViewById(R.id.username_caption);
            caption.setText("Cannot be empty!");
            caption.setTextColor(Color.RED);
            return null;
        } else {
            hideKeyboard();
            SharedPreferences.Editor editor = getActivity()
                    .getSharedPreferences(Global.SHARED_PREFS_NAME, Context.MODE_PRIVATE).edit();

            editor.putString(ConnectivityFragment.LAST_USED_USERNAME_KEY, username);
            editor.apply();

            return username;
        }
    }

