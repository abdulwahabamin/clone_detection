    public PersistableBundle getPersistableBundle() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putLong("id", id);
            persistableBundle.putLong("voiceSettingId", voiceSettingId);
            persistableBundle.putInt("paramTypeId", paramTypeId);
            persistableBundle.putInt("paramBooleanValue", mapBooleanToInt(paramBooleanValue));
            persistableBundle.putLong("paramLongValue", paramLongValue);
            persistableBundle.putString("paramStringValue", paramStringValue);
            return persistableBundle;
        } else {
            return null;
        }
    }

