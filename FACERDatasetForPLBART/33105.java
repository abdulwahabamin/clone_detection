        @Override
        public void run() {
            if (!isScreenOn() || !WidgetRefreshIconService.isRotationActive) {
                return;
            }
            rotateRefreshButtonOneStep();
            timerRotateIconHandler.postDelayed(timerRotateIconRunnable, ROTATE_UPDATE_ICON_MILIS);
        }

