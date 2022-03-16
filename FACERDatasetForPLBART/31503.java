        @Override
        public void onReceive(Context context, Intent intent) {
            Message message = mHandler.obtainMessage(MSG_WEATHER_UPDATE);
            Bundle bundle = new Bundle();
            bundle.putParcelable(WEATHER_ENTITY, intent.getParcelableExtra(WEATHER_ENTITY));
            message.setData(bundle);
            message.sendToTarget();
        }

