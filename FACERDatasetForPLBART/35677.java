    public <T> void syncRequest(final Call<T> requestCall,final IResponseListener<T> responseListener){

        final FailureMessage failureMessage = new FailureMessage();
        if (responseListener == null) {
            return;
        }

        Call<T> call;
        if (requestCall.isExecuted()) {
            call = requestCall.clone();
        } else {
            call = requestCall;
        }

        try{
            Response<T> response = call.execute();
            int resultCode = response.code();
            if (response.isSuccessful()) {
                T result = response.body();
                if (result == null) {
                    failureMessage.clear();
                    failureMessage.setResultCode(resultCode);
                    failureMessage.setFailureMessage("body为空");
                    responseListener.onFailure(failureMessage.toString());
                }else {
                    responseListener.onSuccess(result);
                }
            }else {
                failureMessage.clear();
                failureMessage.setResultCode(resultCode);
                failureMessage.setFailureMessage(resultCode + "错误");
                responseListener.onFailure(failureMessage.toString());
            }
        } catch (IOException e) {
            failureMessage.clear();
            failureMessage.setResultCode(-1);
            failureMessage.setFailureMessage(e.getMessage());
            responseListener.onFailure(failureMessage.toString());
        }

    }

