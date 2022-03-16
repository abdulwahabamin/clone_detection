    @Override
    public Bundle call(String method, String arg, Bundle extras) {
        if (METHOD_PURGE.equals(method)) {
            // Purge references to unknown authorities
            final Intent intent = new Intent(DocumentsContract.PROVIDER_INTERFACE);
            final Set<String> knownAuth = Sets.newHashSet();
            for (ResolveInfo info : getContext()
                    .getPackageManager().queryIntentContentProviders(intent, 0)) {
                knownAuth.add(info.providerInfo.authority);
            }

            purgeByAuthority(new Predicate<String>() {
                @Override
                public boolean apply(String authority) {
                    // Purge unknown authorities
                    return !knownAuth.contains(authority);
                }
            });

            return null;

        } else if (METHOD_PURGE_PACKAGE.equals(method)) {
            // Purge references to authorities in given package
            final Intent intent = new Intent(DocumentsContract.PROVIDER_INTERFACE);
            intent.setPackage(arg);
            final Set<String> packageAuth = Sets.newHashSet();
            for (ResolveInfo info : getContext()
                    .getPackageManager().queryIntentContentProviders(intent, 0)) {
                packageAuth.add(info.providerInfo.authority);
            }

            if (!packageAuth.isEmpty()) {
                purgeByAuthority(new Predicate<String>() {
                    @Override
                    public boolean apply(String authority) {
                        // Purge authority matches
                        return packageAuth.contains(authority);
                    }
                });
            }

            return null;

        } else {
            return super.call(method, arg, extras);
        }
    }

