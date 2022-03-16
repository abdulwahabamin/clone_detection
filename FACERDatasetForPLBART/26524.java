    @OnClick(R2.id.share_container)
    public void onClick() {
        final UMImage umImage;
        Bitmap screenBitmap = null;
        ShareAction shareAction = new ShareAction((Activity) getContext()).setPlatform(SHAREMEDIAS[mPosition]).withTitle("知天气，天气尽在掌�?�之中").withText("简�?，实用，美观的天气应用,你的专属天气");
        if (mShareData.mIsWeather) {
            screenBitmap = UIUtil.takeScreenShot((Activity) getContext());
            if (screenBitmap == null) {
                Toast.makeText(getContext(), "抱歉，分享失败", Toast.LENGTH_LONG).show();
                return;
            }
            umImage = new UMImage(getContext(), screenBitmap);
            shareAction.withMedia(umImage);
        } else {
            umImage = new UMImage(getContext(), R.mipmap.core_icon);
            shareAction.withMedia(umImage).withTargetUrl("https://beta.bugly.qq.com/knowweather");
        }

        final Bitmap finalScreenBitmap = screenBitmap;

        shareAction.setCallback(new UMShareListener() {
            @Override
            public void onResult(SHARE_MEDIA platform) {
                Toast.makeText(getContext(), "分享�?功", Toast.LENGTH_SHORT).show();
                umImage.asBitmap().recycle();
                if (finalScreenBitmap != null) {
                    finalScreenBitmap.recycle();
                }
            }

            @Override
            public void onError(SHARE_MEDIA platform, Throwable t) {
                if (t != null) {
                    Toast.makeText(getContext(), "抱歉，分享失败", Toast.LENGTH_LONG).show();
                }
                umImage.asBitmap().recycle();
                if (finalScreenBitmap != null) {
                    finalScreenBitmap.recycle();
                }
            }

            @Override
            public void onCancel(SHARE_MEDIA platform) {
                umImage.asBitmap().recycle();
                if (finalScreenBitmap != null) {
                    finalScreenBitmap.recycle();
                }
            }
        });
        shareAction.share();
        mShareData.mShareDialog.dismiss();

    }

