    public Intent startShare(String activityTitle, String msgText, String link, File f, int flag){
        this.activityTitle = activityTitle;
        this.msgText = msgText;
        this.link = link;

        Intent intent = new Intent(Intent.ACTION_SEND);
        switch (flag) {
            case SHARE_LINK:
            case SHARE_TEXT:
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, msgText);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                return intent;

            case SHARE_IMAGE:
                if (f.exists() && f.isFile()) {
                    intent.setType("image/png");
                    Uri u = Uri.fromFile(f);
                    intent.putExtra(Intent.EXTRA_STREAM, u);
                }
                intent.putExtra(Intent.EXTRA_TEXT, msgText);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                return intent;

        }

        return null;

    }

