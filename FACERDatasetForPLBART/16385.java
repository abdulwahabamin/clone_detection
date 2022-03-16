    protected V getV() {
        if (v == null || v.get() == null) {
            throw new IllegalStateException("Vä¸?èƒ½ä¸ºç©ºï¼?");
        }
        return v.get();
    }

