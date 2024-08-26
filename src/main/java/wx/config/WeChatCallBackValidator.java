package wx.config;


import wx.req.CheckUrlReq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeChatCallBackValidator {


    private static final String TOKEN = "mywx11";

    public String checkSignature(CheckUrlReq checkUrlReq) {
        List<String> paramList = new ArrayList<>();
        paramList.add(checkUrlReq.getNonce());
        paramList.add(checkUrlReq.getTimestamp());
        paramList.add(TOKEN);
        Collections.sort(paramList);
        //按顺序拼接字符串
        StringBuilder stringBuilder = new StringBuilder();
        paramList.forEach(stringBuilder::append);
        String encode = SHA1.encode(stringBuilder.toString());
        System.out.println("微信消息发过来了：" + checkUrlReq.getEchostr());
        if (encode.equals(checkUrlReq.getSignature())) {
            return checkUrlReq.getEchostr();
        } else {
            throw new RuntimeException("微信验证失败");
        }
    }


}
