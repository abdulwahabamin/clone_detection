    protected V getV() {
        if (v == null || v.get() == null) {
            throw new IllegalStateException("V�?能为空�?");
        }
        return v.get();
    }

