    private void initView(View view) {
        Switch logSwitch = (Switch) view.findViewById(R.id.log_switch);
        SharedPreferences log = getActivity().getSharedPreferences(MyApplication.logFilename, getActivity().MODE_PRIVATE);
        boolean logChecked = log.getBoolean("ischecked", true);
        logSwitch.setChecked(logChecked);
        switchStatus(logSwitch, MyApplication.logFilename,1);


        Switch notificationSwitch = (Switch) view.findViewById(R.id.notification_switch);
        SharedPreferences notification = getActivity().getSharedPreferences(MyApplication.notificationname, getActivity().MODE_PRIVATE);
        boolean notificationChecked = notification.getBoolean("ischecked", true);
        notificationSwitch.setChecked(notificationChecked);
        switchStatus(notificationSwitch, MyApplication.notificationname,2);

        Switch widgetSwitch = (Switch) view.findViewById(R.id.widget_switch);
        SharedPreferences widget = getActivity().getSharedPreferences(MyApplication.widgetname, getActivity().MODE_PRIVATE);
        boolean widgetChecked = widget.getBoolean("ischecked", true);
        widgetSwitch.setChecked(widgetChecked);
        switchStatus(widgetSwitch, MyApplication.widgetname,3);

        Switch cacheSwitch = (Switch) view.findViewById(R.id.cache_switch);
        SharedPreferences cache = getActivity().getSharedPreferences(MyApplication.cachename, getActivity().MODE_PRIVATE);
        boolean cacheChecked = cache.getBoolean("ischecked", true);
        cacheSwitch.setChecked(cacheChecked);
        switchStatus(cacheSwitch,MyApplication.cachename,4);
    }

