    @Override
    public void initViews() {

        mScheduleKeys = getResources().getStringArray(R.array.setting_schedule);

        mThemeSwitch.setChecked(PreferencesHelper.get(ResourceProvider.NOTIFICATION_ALLOW, true));
        mThemeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                PreferencesHelper.put(ResourceProvider.NOTIFICATION_ALLOW, isChecked);
                Router.instance().getReceiver(EventCenter.NotificationStatus.class).onAllowNotification(isChecked);
            }
        });

        mNotificationThemeDialog = new AlertDialog.Builder(getContext(), R.style.core_AlertDialogStyle);
        mNotificationThemeDialog.setTitle(R.string.notification_theme);
        int which = PreferencesHelper.get(ResourceProvider.NOTIFICATION_THEME, 1);
        mNotificationTheme.setText(ResourceProvider.getNotificationName(which));

        mAlarmSwitch.setChecked(PreferencesHelper.get(ResourceProvider.ALARM_ALLOW, false));

        //close alarm this version
        PreferencesHelper.put(ResourceProvider.ALARM_ALLOW, false);

        mAlarmSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                PreferencesHelper.put(ResourceProvider.ALARM_ALLOW, isChecked);
            }
        });

        mScheduleDialog = new AlertDialog.Builder(getContext(), R.style.core_AlertDialogStyle);
        mScheduleDialog.setTitle(R.string.update_allow);
        int scheduleWhich = PreferencesHelper.get(ResourceProvider.POLLING_TIME, 0);
        mUpdateSchedule.setText(mScheduleKeys[scheduleWhich]);
        if (isAdded()) {
            CoreManager.getImpl(IWeatherProvider.class).startService(getActivity(), scheduleWhich != mScheduleKeys.length - 1);
        }

    }

