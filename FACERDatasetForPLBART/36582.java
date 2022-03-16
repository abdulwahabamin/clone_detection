    @Override
    public void onReceive(Context context, Intent intent) {
        // 接收开机和�?�动程�?时候的广播时执行
        super.onReceive(context, intent);
        context.startService(new Intent(context, TimerService.class));
    }

