    public <T> T syncRequest(final Call<T> requestCall) {
        Call<T> call;
        if (requestCall.isExecuted()) {
            call = requestCall.clone();
        } else {
            call = requestCall;
        }
        try{
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                T result = response.body();
                return result;
            }else {
                return null;
            }
        } catch (IOException e) {
            Logger.e(e.getMessage());
        }
        return null;

    }

