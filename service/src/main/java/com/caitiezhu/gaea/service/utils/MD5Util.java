package com.caitiezhu.gaea.service.utils;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

public class MD5Util {

    public static String md5Encode(String password) {
        return Hashing.md5().newHasher().putString(password, Charsets.UTF_8).hash().toString();
    }
}
