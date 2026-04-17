package com.lullaby.lambda.lazy;

public class PrintUtil {

    public static void print(boolean valid, String msg) {
        if (valid) {
            System.out.println(msg);
        }
    }

    private static String build(String...infos) {
        StringBuilder builder = new StringBuilder();
        for (String info : infos) {
            builder.append(info);
        }
        return builder.toString();
    }

    public static void print(boolean valid, String... infos) {
        if (valid) {
//            MsgBuilder msgBuilder = new MsgBuilder() {
//                @Override
//                public String builderMsg(String... infos) {
//                    return PrintUtil.build(infos);
//                }
//            };

            MsgBuilder msgBuilder = PrintUtil::build;
            System.out.println(msgBuilder.builderMsg(infos));
        }
    }

}
