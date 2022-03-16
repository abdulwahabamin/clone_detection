    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int width = 0;
        int height = 0;

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int widthAllowed = MeasureSpec.getSize(widthMeasureSpec);
        int heightAllowed = MeasureSpec.getSize(heightMeasureSpec);


        widthAllowed = chooseWidth(widthMode, widthAllowed);
        heightAllowed = chooseHeight(heightMode, heightAllowed);


        if (!mShowAlphaPanel) {
            height = (int) (widthAllowed - PANEL_SPACING - HUE_PANEL_WIDTH);

            //If calculated height (based on the width) is more than the allowed height.
            if (height > heightAllowed) {
                height = heightAllowed;
                width = (int) (height + PANEL_SPACING + HUE_PANEL_WIDTH);
            }
            else{
                width = widthAllowed;
            }
        }
        else{

            width = (int) (heightAllowed - ALPHA_PANEL_HEIGHT + HUE_PANEL_WIDTH);

            if (width > widthAllowed) {
                width = widthAllowed;
                height = (int) (widthAllowed - HUE_PANEL_WIDTH + ALPHA_PANEL_HEIGHT);
            }
            else{
                height = heightAllowed;
            }


        }


        setMeasuredDimension(width, height);
    }

