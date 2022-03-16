    public <T> void asynRequest(final Call<T> requestCall, final IResponseListener<T> resonseListener) {

        final FailureMessage failureMessage = new FailureMessage();
        if (resonseListener == null) {
            return;
        }

        Call<T> call;
        if (requestCall.isExecuted()) {
            call = requestCall.clone();
        } else {
            call = requestCall;
        }


        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                int resultCode = response.code();
                if (response.isSuccessful()) {
                    T result = response.body();
                    if (result == null) {
                        failureMessage.clear();
                        failureMessage.setResultCode(resultCode);
                        failureMessage.setFailureMessage("body为空");
                        resonseListener.onFailure(failureMessage.toString());
                    } else {
                        resonseListener.onSuccess(result);
                    }

                } else {
                    failureMessage.clear();
                    failureMessage.setResultCode(resultCode);
                    failureMessage.setFailureMessage(resultCode + "错误");
                    resonseListener.onFailure(failureMessage.toString());

                }


            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                failureMessage.clear();
                failureMessage.setResultCode(-1);
                failureMessage.setFailureMessage(t.getMessage());
                resonseListener.onFailure(failureMessage.toString());
            }
        });

    }

