        @Override
        public void onReceive(Context context, Intent intent) {
            if (!WidgetRefreshIconService.isRotationActive) {
                return;
            }
            rotateRefreshButtonOneStep();
            timerRotateIconHandler.postDelayed(timerRotateIconRunnable, ROTATE_UPDATE_ICON_MILIS);
        }

