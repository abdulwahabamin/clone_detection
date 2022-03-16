    /**
     * 为按键注册监�?�事件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.share_app:
                ShareUtils.share(null, "最简�?�?最轻巧的天气软件：简约天气\n快�?�下载�?�~\n\n点击下载：http://www.coolapk.com/apk/online.laoliang.simpleweather", this);
                break;
            case R.id.check_welcome:
                Intent intent_welcome = new Intent(this, WelcomeActivity.class);
                startActivity(intent_welcome);
                finish();
                break;
            case R.id.feed_back:
                Intent intent_feedback = new Intent(this, FeedBackACtivity.class);
                startActivity(intent_feedback);
                break;
            case R.id.project_address:
                Intent intent_project = new Intent(Intent.ACTION_VIEW);
                intent_project.setData(Uri.parse("https://github.com/liangpengyv/SimpleWeather"));
                startActivity(intent_project);
                break;
            case R.id.my_blog:
                Intent intent_blog = new Intent(Intent.ACTION_VIEW);
                intent_blog.setData(Uri.parse("http://laoliang.online/"));
                startActivity(intent_blog);
                break;
            case R.id.qq_qun:
                Intent intent_qq = new Intent(Intent.ACTION_VIEW);
                intent_qq.setData(Uri.parse("http://jq.qq.com/?_wv=1027&k=2AgKvcH"));
                startActivity(intent_qq);
                break;
            default:
                break;
        }
    }

