    @Override
    public void onEnabled(Context context) {
        // Widget添加到�?幕时执行
        super.onEnabled(context);
        context.startService(new Intent(context, TimerService.class));
    }

