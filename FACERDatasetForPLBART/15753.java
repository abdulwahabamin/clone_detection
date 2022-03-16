    public void overrideBackButton(Runnable backOverride) {
        if(backOverride == null) {
            this.backOverride = null;
        } else {
            this.backOverride = backOverride;
        }
    }

