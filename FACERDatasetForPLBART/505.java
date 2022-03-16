    @Override
    protected void initEvent() {
        mToolbarTb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mMsgFaceIb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mEmojiconFl.getVisibility() == View.GONE){
                    hideSoftInput();
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mEmojiconFl.setVisibility(View.VISIBLE);
                            setEmojiconFragment(false);
                        }
                    }, 100);
                } else{
                    mEmojiconFl.setVisibility(View.GONE);
                }
            }
        });
        mMsgAddIb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FilePicker picker = new FilePicker(ChatActivity.this, FilePicker.FILE);
                picker.setShowHideDir(false);
                picker.setRootPath(StorageUtils.getInternalRootPath(ChatActivity.this));
                picker.setOnFilePickListener(new FilePicker.OnFilePickListener() {
                    @Override
                    public void onFilePicked(String currentPath) {
                        mIsSendFile = true;
                        mFilePath = currentPath;
                        mSendFile = new File(mFilePath);
                        mMsgEditEt.setText(mSendFile.getName());
                    }
                });
                picker.show();
            }
        });
        mMsgSendIb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mMsgEditEt.getText() != null && mMsgEditEt.getText().toString().trim().length() > 0){
                    sendMessage();
                } else{
                    ToastUtil.showToast(mContext, getString(R.string.send_msg_isEmpty));
                }
            }
        });
        mMsgEditEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEmojiconFl.setVisibility(View.GONE);
            }
        });
    }

