    public void switchStatus(Switch aSwitch, final String fileName) {
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences settings = getActivity().getSharedPreferences(fileName, Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = settings.edit();
                edit.putBoolean("ischecked", isChecked);
                edit.commit();

                if (isChecked) {
                    initNightView(R.layout.night_mode_overlay);
                } else {
                    removeNightView();
                }
            }

        });
    }

