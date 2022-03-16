        private void endActivity() {
            if (!isHost) {
                mActivity.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        Toast.makeText(mActivity, mActivity.getString(R.string.chatroom_closed), Toast.LENGTH_SHORT).show();
                        mActivity.finish();
                    }

                });
            }
        }

