    public void getUserLoginInfo(UserLoginQuery userLoginQuery, final UserListener listener) {
        mUserRestService.getUserLoginInfo(UserLoginQuery.Method, JSON, API_KEY, generateMD5(userLoginQuery.getSignature()), userLoginQuery.mUsername, userLoginQuery.mPassword, new Callback<UserLoginInfo>() {
            @Override
            public void success(UserLoginInfo userLoginInfo, Response response) {
                Log.d("Logedin", userLoginInfo.mSession.mToken + " " + userLoginInfo.mSession.mUsername);
                Bundle extras = new Bundle();
                extras.putString("lf_token", userLoginInfo.mSession.mToken);
                extras.putString("lf_user", userLoginInfo.mSession.mUsername);
                PreferencesUtility.getInstance(context).updateService(extras);
                mUserSession = userLoginInfo.mSession;
                mUserSession.update(context);
                listener.userSuccess();
            }

            @Override
            public void failure(RetrofitError error) {
                listener.userInfoFailed();
            }
        });
    }

