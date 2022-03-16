    @Override
    public void run() {
        Response response = null;
        try {
            response = call.execute();
            if (response.isSuccessful()) {
                if (listener != null) {
                    listener.success((!TextUtils.isEmpty(response.headers().get("Content-Range")) &&
                            !TextUtils.isEmpty(response.headers().get("Content-Length"))),
                            response.code() != 206,
                            response.headers().get("Last-Modified"),
                            Long.parseLong(response.headers().get("Content-Range").split("/")[1]));
                }
            }else {
                if (listener != null) {
                    failureMessage.clear();
                    failureMessage.setResultCode(-1);
                    failureMessage.setFailureMessage("response请求失败");
                    listener.onFailure(failureMessage);
                }

            }
        } catch (Exception e){
            if (listener != null) {
                failureMessage.clear();
                failureMessage.setFailureMessage(e.getMessage());
                listener.onFailure(failureMessage);
            }

        }finally {
            if (response != null) {
                if (response.body() != null) {
                    ((ResponseBody) response.body()).close();
                }
            }

        }
    }

