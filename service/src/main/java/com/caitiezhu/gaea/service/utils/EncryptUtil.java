package com.caitiezhu.gaea.service.utils;

import com.google.common.hash.Hashing;
import com.google.common.io.BaseEncoding;

public class EncryptUtil {
    public static String md5Encode(String str) {
        return Hashing.md5().hashBytes(str.getBytes()).toString();
    }

    public static String base64Encode(String str) {
        return BaseEncoding.base64().encode(str.getBytes());
    }

    public static String base64Decode(String str) {
        return new String(BaseEncoding.base64().decode(str));
    }
}
