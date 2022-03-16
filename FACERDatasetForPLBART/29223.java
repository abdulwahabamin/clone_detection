    @Override
    public View makeView() {
        ImageView imageView=new ImageView(this);
        FrameLayout.LayoutParams lp=new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        imageView.setLayoutParams(lp);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(backGroundRes[randomNum.nextInt(18)]);
        return imageView;
    }

