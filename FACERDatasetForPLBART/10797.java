    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize() {
        this.mMultiLine = false;
        this.mSpannable = null;
        if (this.mResourcesResolver != null) {
            this.mKeyColor = this.mResourcesResolver.getColor(
                    HighlightColors.TEXT.getId(),
                    HighlightColors.TEXT.getResId(),
                    HighlightColors.TEXT.getDefault());
            this.mAssignmentColor = this.mResourcesResolver.getColor(
                    HighlightColors.ASSIGNMENT.getId(),
                    HighlightColors.ASSIGNMENT.getResId(),
                    HighlightColors.ASSIGNMENT.getDefault());
            this.mCommentColor = this.mResourcesResolver.getColor(
                    HighlightColors.SINGLE_LINE_COMMENT.getId(),
                    HighlightColors.SINGLE_LINE_COMMENT.getResId(),
                    HighlightColors.SINGLE_LINE_COMMENT.getDefault());
            this.mValueColor = this.mResourcesResolver.getColor(
                    HighlightColors.VARIABLE.getId(),
                    HighlightColors.VARIABLE.getResId(),
                    HighlightColors.VARIABLE.getDefault());
            this.mArgumentColor = this.mResourcesResolver.getColor(
                    HighlightColors.KEYWORD.getId(),
                    HighlightColors.KEYWORD.getResId(),
                    HighlightColors.KEYWORD.getDefault());
        } else {
            // By default
            this.mKeyColor = HighlightColors.TEXT.getDefault();
            this.mAssignmentColor = HighlightColors.TEXT.getDefault();
            this.mCommentColor = HighlightColors.SINGLE_LINE_COMMENT.getDefault();
            this.mValueColor = HighlightColors.VARIABLE.getDefault();
            this.mArgumentColor = HighlightColors.KEYWORD.getDefault();
        }
    }

