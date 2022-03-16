    public static boolean bindToService(Context context, ServiceConnection callback) {
        context.startService(new Intent(context, MediaPlaybackService.class));
        ServiceBinder sb = new ServiceBinder(callback);
        sConnectionMap.put(context, sb);
        return context.bindService((new Intent()).setClass(context,
                MediaPlaybackService.class), sb, 0);
    }

