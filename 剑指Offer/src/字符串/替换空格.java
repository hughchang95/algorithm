package 字符串;

public class 替换空格 {
    //调用函数替换
    public String replaceSpace(String s) {
       return s.replaceAll(" ","%20");
    }

    //利用char数组替换
    public String replaceSpace2(String s) {
        int length = s.length();
        char[] chars =new char[length*3];
        int size=0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c==' '){
                chars[size++]='%';
                chars[size++]='2';
                chars[size++]='0';
            }else
                chars[size++]=c;
        }
        String result=new String(chars,0,size);
        return result;
    }
}
