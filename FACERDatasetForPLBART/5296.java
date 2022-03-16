    void createEmptyMessage() {

        imageView = new ImageView(this);
        imageView.setImageResource(com.singh.multimeet.quicxplo.R.drawable.empty);
        RelativeLayout.LayoutParams imageParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        imageParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        imageView.setId(com.singh.multimeet.quicxplo.R.id.empty_image);

        emptyText = new TextView(this);
        emptyText.setTextSize(18);
        emptyText.setText(com.singh.multimeet.quicxplo.R.string.empty_text);
        emptyText.setTypeface(AppController.getTypeface());
        emptyText.setId(com.singh.multimeet.quicxplo.R.id.empty_text);

        RelativeLayout.LayoutParams textParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        textParams.addRule(RelativeLayout.BELOW, com.singh.multimeet.quicxplo.R.id.empty_image);
        textParams.setMargins(10, 10, 10, 10);
        textParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        imageView.setLayoutParams(imageParams);
        emptyText.setLayoutParams(textParams);

    }

