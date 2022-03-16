    private void onError(Throwable throwable) {
        failureMessage.clear();
        failureMessage.setResultCode(-1);
        failureMessage.setFailureMessage(throwable.getMessage());
        listener.onError(entity, failureMessage);
    }

