    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int ret = super.onStartCommand(intent, flags, startId);

        if (intent == null) {
            return ret;
        }

        if (null != intent.getAction()) switch (intent.getAction()) {
            case "org.openbmap.unifiedNlp.LOCATION_UPDATE_CELLS_ONLY":
                startLocationUpdateCellsOnly();
                return ret;
            default:
                break;
        }
        return START_STICKY;
    }

