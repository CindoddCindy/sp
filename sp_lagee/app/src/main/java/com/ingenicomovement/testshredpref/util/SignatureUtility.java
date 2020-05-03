package com.ingenicomovement.testshredpref.util;

public class SignatureUtility {

    private static MD5Utility md5Utility;

    public static String doSignature(String _datetime, String _others) {
        md5Utility      = new MD5Utility();

        String _signature = md5Utility.doMD5(md5Utility.doMD5(_datetime) + md5Utility.doMD5(_others) + md5Utility.doMD5("0a5941c1-e4bd-471c-8ceb-ecc1a940eb57"));
        return _signature;
    }
}
