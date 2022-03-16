    protected void initNightView(int layoutID)
    {
        mNightViewParam = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.TYPE_APPLICATION,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSPARENT);

        mWindowManager = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
        mNightView=LayoutInflater.from(getActivity()).inflate(layoutID,null);
        mWindowManager.addView(mNightView, mNightViewParam);
    }

