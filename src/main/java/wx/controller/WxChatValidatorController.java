package wx.controller;

import org.springframework.web.bind.annotation.*;
import wx.config.WeChatCallBackValidator;
import wx.factory.WxPostFactory;
import wx.req.CheckUrlReq;
import wx.service.WxBaseService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/wxLogin")
public class WxChatValidatorController {

    @Resource
    private WxPostFactory wxPostFactory;

    @GetMapping("/checkUrl")
    public String checkUrl(CheckUrlReq checkUrlReq){
        WeChatCallBackValidator validator = new WeChatCallBackValidator();
        return validator.checkSignature(checkUrlReq);
    }

    @PostMapping("/checkUrl")
    @ResponseBody
    public String doPost (@RequestBody String body){
        System.out.println("请求"+ body);
        WxBaseService service = wxPostFactory.getService(body);
        String result = service.doPost();
        System.out.println("返回"+result);
        return result;
    }
}
