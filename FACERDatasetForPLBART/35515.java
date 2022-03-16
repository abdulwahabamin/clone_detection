    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TimeMonitorManager.getInstance().getTimeMonitor(TimeMonitorConfig
                .TIME_MONITOR_ID_APPLICATION_START).recordingTimeTag("StartActivity_create");
        super.onCreate(savedInstanceState);
        TimeMonitorManager.getInstance().getTimeMonitor(TimeMonitorConfig
                .TIME_MONITOR_ID_APPLICATION_START).end
                ("StartActivity_create_setContentView_start");
        setContentView(getLayoutId());
        TimeMonitorManager.getInstance().getTimeMonitor(TimeMonitorConfig
                .TIME_MONITOR_ID_APPLICATION_START).end
                ("StartActivity_create_setContentView_stop");
        ButterKnife.bind(this);
        initEvent();

    }

