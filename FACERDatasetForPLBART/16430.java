    @Override
    public void finishLaunchActivity(Message message) {
        try {
            Object activityClientRecord = message.obj;
            Field tokenField = activityClientRecord.getClass().getDeclaredField("token");
            tokenField.setAccessible(true);
            IBinder binder = (IBinder) tokenField.get(activityClientRecord);
            finish(binder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

