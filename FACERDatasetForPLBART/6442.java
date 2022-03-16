    public static ProviderExecutor forAuthority(String authority) {
        synchronized (sExecutors) {
            ProviderExecutor executor = sExecutors.get(authority);
            if (executor == null) {
                executor = new ProviderExecutor();
                executor.setName("ProviderExecutor: " + authority);
                executor.start();
                sExecutors.put(authority, executor);
            }
            return executor;
        }
    }

