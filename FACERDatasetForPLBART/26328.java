    @OnClick({R2.id.notification_choose, R2.id.update_allow, R2.id.about})
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.notification_choose) {
            int which = PreferencesHelper.get(ResourceProvider.NOTIFICATION_THEME, 1);
            mNotificationThemeDialog.setSingleChoiceItems(R.array.setting_notification_theme_key, which, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    if (which == 0) {
                        Toast.makeText(getContext(), R.string.follow_system_warn, Toast.LENGTH_LONG).show();
                    }
                    PreferencesHelper.put(ResourceProvider.NOTIFICATION_THEME, which);
                    mNotificationTheme.setText(ResourceProvider.getNotificationName(which));
                    Router.instance().getReceiver(EventCenter.NotificationStatus.class).onUpdateNotification();
                }
            });
            mNotificationThemeDialog.show();

        } else if (i == R.id.update_allow) {
            int whichSchedule = PreferencesHelper.get(ResourceProvider.POLLING_TIME, 0);
            mScheduleDialog.setSingleChoiceItems(R.array.setting_schedule, whichSchedule, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    PreferencesHelper.put(ResourceProvider.POLLING_TIME, which);

                    mUpdateSchedule.setText(mScheduleKeys[which]);

                    dialog.dismiss();
                }
            });
            mScheduleDialog.show();

        } else if (i == R.id.about) {
            CoreManager.getActivityRouter(IActivityRouter.class).toAboutActivity();
        }
    }

