    @Override
    public void onError(Throwable e) {
        failureMessage.clear();
        failureMessage.setFailureMessage(e.getMessage());
        failureMessage.setOther(e.getMessage());
        failureMessage.setResultCode(-1);
        Log.e("失败信�?�",failureMessage.toString());
    }

