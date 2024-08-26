package wx.res;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ClickRes extends BaseRes{

    private String ToUserName;

    private String FromUserName;

    private String CreateTime;

    private String MsgType;

    private String Content;
}
