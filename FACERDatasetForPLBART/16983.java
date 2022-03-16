    /**
     * @return false if the caller is not authorized to get data from this MediaBrowserService
     */
    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public boolean isCallerAllowed(Context context, String callingPackage, int callingUid) {
        // Always allow calls from the framework, self app or development environment.
        if (Process.SYSTEM_UID == callingUid || Process.myUid() == callingUid) {
            return true;
        }

        if (isPlatformSigned(context, callingPackage)) {
            return true;
        }

        PackageInfo packageInfo = getPackageInfo(context, callingPackage);
        if (packageInfo == null) {
            return false;
        }
        if (packageInfo.signatures.length != 1) {
            FireLog.w(TAG, "Caller does not have exactly one signature certificate!");
            return false;
        }
        String signature = Base64.encodeToString(
                packageInfo.signatures[0].toByteArray(), Base64.NO_WRAP);

        // Test for known signatures:
        ArrayList<CallerInfo> validCallers = validCertificates.get(signature);
        if (validCallers == null) {
            FireLog.v(TAG, "Signature for caller " + callingPackage + " is not valid: \n"
                    + signature);
            if (validCertificates.isEmpty()) {
                FireLog.w(TAG, "The list of valid certificates is empty. Either your file " +
                        "res/xml/allowed_media_browser_callers.xml is empty or there was an error " +
                        "while reading it. Check previous log messages.");
            }
            return false;
        }

        // Check if the package name is valid for the certificate:
        StringBuffer expectedPackages = new StringBuffer();
        for (CallerInfo info : validCallers) {
            if (callingPackage.equals(info.packageName)) {
                FireLog.v(TAG, "Valid caller: " + info.name + "  package=" + info.packageName +
                        " release=" + info.release);
                return true;
            }
            expectedPackages.append(info.packageName).append(' ');
        }

        FireLog.i(TAG, "Caller has a valid certificate, but its package doesn't match any " +
                "expected package for the given certificate. Caller's package is " + callingPackage +
                ". Expected packages as defined in res/xml/allowed_media_browser_callers.xml are (" +
                expectedPackages + "). This caller's certificate is: \n" + signature);

        return false;
    }

