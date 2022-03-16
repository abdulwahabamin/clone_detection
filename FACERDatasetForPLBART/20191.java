    private Notice getNotice() {
        final Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey(ARGUMENT_NOTICE)) {
            return (Notice) arguments.getSerializable(ARGUMENT_NOTICE);
        }

        throw new IllegalStateException("no notice provided");
    }

