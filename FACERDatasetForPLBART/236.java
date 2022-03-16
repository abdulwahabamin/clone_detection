        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i(TAG, intent.getAction());
            if (intent.getAction().equals(ACTION_BOND_STATE_CHANGED)) {
                initDeviceBondState();
            }
        }

