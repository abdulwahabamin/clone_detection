    @OnLongClick(R2.id.pay_qrcode)
    boolean onShareToWeChat() {
        ShareAction shareAction = new ShareAction(this).setPlatform(SHARE_MEDIA.WEIXIN).withTitle(getString(R.string.thanks));

        final UMImage umImage = new UMImage(this, R.mipmap.setting_wechat_pay);
        shareAction.withMedia(umImage);


        shareAction.setCallback(new UMShareListener() {
            @Override
            public void onResult(SHARE_MEDIA platform) {
                Toast.makeText(PayActivity.this, R.string.core_share_success, Toast.LENGTH_SHORT).show();
                umImage.asBitmap().recycle();
            }

            @Override
            public void onError(SHARE_MEDIA platform, Throwable t) {
                if (t != null) {
                    Toast.makeText(PayActivity.this, R.string.core_share_fail, Toast.LENGTH_LONG).show();
                }
                umImage.asBitmap().recycle();

            }

            @Override
            public void onCancel(SHARE_MEDIA platform) {
                umImage.asBitmap().recycle();
            }
        });
        shareAction.share();
        return true;
    }

