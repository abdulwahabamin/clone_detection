    public void switchStatus(Switch aSwitch, final String fileName, final int flag) {
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences settings = getActivity().getSharedPreferences(fileName, Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = settings.edit();
                edit.putBoolean("ischecked", isChecked);
                edit.apply();
                if (isChecked) {
                    if (flag == 2) {
                        getActivity().startService(new Intent(getActivity(), NotificationService.class));
                    }
                }else{
                    if (flag == 2) {
                        getActivity().stopService(new Intent(getActivity(), NotificationService.class));
                    }
                }
            }

        });
    }

