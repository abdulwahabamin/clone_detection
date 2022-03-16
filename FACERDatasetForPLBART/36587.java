    @Override
    public void onReceive(Context context, Intent intent) {
        // 因为定义了开机接收�?�动�?��?�更新�?务的广播
        // 所以�?先检测是�?�打开了�?��?�更新�?务
        // �?决定是�?��?��?�?�动�?��?�更新�?务的Intent命令
        // 至于这里为什么先�?创建一个“data_setting�?
        // 是为了防止用户安装完应用直接�?�?�手机的�?端情况
        // 哎，强迫症，想的也是蛮细的，哈哈哈�?�?�?
        // 对了，这些�?作，虽然很多，但也�?会超过5秒
        SharedPreferences.Editor editor = context.getSharedPreferences("data_setting", Context.MODE_PRIVATE).edit();
        editor.commit();
        SharedPreferences prefs = context.getSharedPreferences("data_setting", Context.MODE_PRIVATE);
        boolean isBackUpdate = prefs.getBoolean("back_update", false);
        if (isBackUpdate) {
            Intent i = new Intent(context, AutoUpdateService.class);
            i.putExtra("anHour", -1);
            context.startService(i);
        }

    }

