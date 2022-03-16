    @Override
    public void onDisabled(Context context) {
        // 最�?�一次Widget从�?幕移除时执行
        super.onDisabled(context);
        context.stopService(new Intent(context, TimerService.class));
    }

