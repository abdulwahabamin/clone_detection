    /**
     * Sets text with clickable links in the specified TextView.
     */
    private void displayTextWithLinks(TextView textView, final SpannableString spannableString) {
        MovementMethod m1 = textView.getMovementMethod();
        if ((m1 == null) || !(m1 instanceof LinkMovementMethod))
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setLinkTextColor(linkTextColour);
        textView.setText(spannableString);
    }

