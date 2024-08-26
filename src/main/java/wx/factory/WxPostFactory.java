package wx.factory;

import cn.hutool.json.JSONObject;
import cn.hutool.json.XML;
import org.springframework.stereotype.Service;
import wx.service.ClickService;
import wx.service.WxBaseService;

@Service
public class WxPostFactory {

    public WxBaseService getService(String body){
        JSONObject jsonBody = XML.toJSONObject(body);
        Object jsonBodyStr = jsonBody.get("xml");
        JSONObject json = new JSONObject(jsonBodyStr);
        String event = (String)json.get("MsgType");
        if("event".equals(event)){
            return new ClickService(json.toString());
        }else {
            return null;
        }

    }
}
