package 字符串;

import java.net.UnknownHostException;

public class 验证IP地址 {
    public static String validIPAddress(String IP) {
        try {
            if (IP.startsWith(":") || IP.startsWith(".") || IP.endsWith(":") || IP.endsWith(".")) {
                return "Neither";
            }

            String[] v4s = IP.split("\\.");
            if (v4s.length == 4) {
                for (String v4 : v4s) {
                    if (v4.length() != 1 && v4.charAt(0) == '0') {
                        return "Neither";
                    }
                    if (v4.charAt(0) == '-') {
                        return "Neither";
                    }
                    Integer v4num = Integer.valueOf(v4);
                    if (v4num > 255 || v4num < 0) {
                        return "Neither";
                    }
                }
                int count = 0;
                for (int i = 0; i < IP.length(); i++) {
                    if (IP.charAt(i) == '.') {
                        count++;
                    }
                }
                if (count != 3) {
                    return "Neither";
                }
                return "IPv4";
            }

            String[] v6s = IP.split(":");
            if (v6s.length == 8) {
                for (String v6 : v6s) {
                    if (v6.equals("")) {
                        return "Neither";
                    }
                    if (v6.charAt(0) == '-') {
                        return "Neither";
                    }
                    Integer v6num = Integer.valueOf(v6, 16);
                    if (v6.length() > 4) {
                        return "Neither";
                    }
                    if (v6num > 65535 || v6num < 0) {
                        return "Neither";
                    }
                }
                int count = 0;
                for (int i = 0; i < IP.length(); i++) {
                    if (IP.charAt(i) == ':') {
                        count++;
                    }
                }
                if (count != 7) {
                    return "Neither";
                }
                return "IPv6";
            }
            return "Neither";
        } catch (Exception e) {
            return "Neither";
        }
    }


    public static void main(String[] args) throws UnknownHostException {
        System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));

    }
}
