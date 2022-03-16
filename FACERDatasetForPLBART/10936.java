    /**package**/ void toggleWordWrap() {
        synchronized (this.mExecSync) {
            ViewGroup vSrc = this.mWordWrap ? this.mWordWrapView : this.mNoWordWrapView;
            ViewGroup vDst = this.mWordWrap ? this.mNoWordWrapView : this.mWordWrapView;
            ViewGroup vSrcParent = this.mWordWrap
                                                ? this.mWordWrapView
                                                : (ViewGroup)this.mNoWordWrapView.getChildAt(0);
            ViewGroup vDstParent = this.mWordWrap
                                                ? (ViewGroup)this.mNoWordWrapView.getChildAt(0)
                                                : this.mWordWrapView;
            vSrc.setVisibility(View.GONE);
            vSrcParent.removeView(this.mEditor);
            vDstParent.addView(this.mEditor);
            vDst.setVisibility(View.VISIBLE);
            vDst.scrollTo(0, 0);
            this.mWordWrap = !this.mWordWrap;
        }
    }

