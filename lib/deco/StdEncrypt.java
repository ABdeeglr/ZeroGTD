package lib.deco;
import lib.std.StdOut;

public class StdEncrypt {
    public static void main(String[] args) {
        String words = "非对称加密:密钥成对出现，分别为公钥和私钥，从公钥无法推知私钥，反之，从私钥也无法推知公钥，加密和解密使用不同的密钥，公钥加密需要私钥解密，反之，私钥加密需要公钥解密。非对称加密速度较慢，典型的非对称算法有：RSA,DSA,DSS.";

        StdOut.println(words);
    }
}
