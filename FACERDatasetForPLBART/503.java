    @Override
    protected void initWidget() {
        mToolbarTb =  (Toolbar) findViewById(R.id.toolbar);
        mTitleTv = (TextView) findViewById(R.id.title);
        mChatMsgLv = (ListView) findViewById(R.id.chat_msg_show_list);
        mMsgFaceIb = (ImageButton) findViewById(R.id.chat_msg_face);
        mMsgAddIb = (ImageButton) findViewById(R.id.chat_msg_add);
        mMsgEditEt = (EditText) findViewById(R.id.chat_msg_edit);
        mMsgSendIb = (ImageButton) findViewById(R.id.chat_msg_send);
        mEmojiconFl = (FrameLayout) findViewById(R.id.chat_emojicons);
        mProgressDialog = new ProgressDialog(mContext);
    }

